package com.github.kukuhyoniatmoko.buildconfigkotlin

import com.squareup.kotlinpoet.*

object BuildConfigSpecFactory {

    fun create(sourceSet: BuildConfigKotlinSourceSet): FileSpec {
        val className = ClassName(sourceSet.packageName, sourceSet.className)
        val builder = TypeSpec.objectBuilder(className)

        for (it in sourceSet.fields) {
            val type = it.value::class
            val initFormat = when (type) {
                String::class -> "%S"
                Char::class -> "\'%L\'"
                Long::class -> "%LL"
                Float::class -> "%Lf"
                else -> "%L"
            }
            val spec = PropertySpec.builder(it.name, type)
                    .addModifiers(KModifier.CONST)
                    .initializer(initFormat, it.value)
                    .build()
            builder.addProperty(spec)
        }

        return FileSpec.get(sourceSet.packageName, builder.build())
    }
}