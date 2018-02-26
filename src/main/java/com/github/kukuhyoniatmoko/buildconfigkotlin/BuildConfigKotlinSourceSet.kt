package com.github.kukuhyoniatmoko.buildconfigkotlin

import org.gradle.api.Named
import java.io.Serializable

class BuildConfigKotlinSourceSet(private val name: String) : Named, Serializable {

    override fun getName(): String = name

    var className: String = "BuildConfig"

    var packageName: String = ""

    private var _fields: MutableMap<String, BuildConfigField> = mutableMapOf()

    val fields: List<BuildConfigField> get() = _fields.values.toList()

    private fun checkName(name: String) {
        if (_fields.containsKey(name)) {
            throw IllegalArgumentException("Name: $name is already defined")
        }
    }

    fun buildConfig(name: String, value: String) {
        checkName(name)
        _fields[name] = BuildConfigField(name, value)
    }

    fun buildConfigString(configuration: BuildConfigFieldBuilder<String>.() -> Unit) {
        val builder = BuildConfigFieldBuilder<String>()
        builder.configuration()
        _fields[builder.name] = BuildConfigField(builder.name, builder.value)
    }

    fun buildConfig(name: String, value: Int) {
        _fields[name] = BuildConfigField(name, value)
    }

    fun buildConfigInt(configuration: BuildConfigFieldBuilder<Int>.() -> Unit) {
        val builder = BuildConfigFieldBuilder<Int>()
        builder.configuration()
        _fields[builder.name] = BuildConfigField(builder.name, builder.value)
    }

    fun buildConfig(name: String, value: Float) {
        _fields[name] = BuildConfigField(name, value)
    }

    fun buildConfigFloat(configuration: BuildConfigFieldBuilder<Float>.() -> Unit) {
        val builder = BuildConfigFieldBuilder<Float>()
        builder.configuration()
        _fields[builder.name] = BuildConfigField(builder.name, builder.value)
    }

    fun buildConfig(name: String, value: Long) {
        _fields[name] = BuildConfigField(name, value)
    }

    fun buildConfigLong(configuration: BuildConfigFieldBuilder<Long>.() -> Unit) {
        val builder = BuildConfigFieldBuilder<Long>()
        builder.configuration()
        _fields[builder.name] = BuildConfigField(builder.name, builder.value)
    }

    fun buildConfig(name: String, value: Double) {
        _fields[name] = BuildConfigField(name, value)
    }

    fun buildConfigDouble(configuration: BuildConfigFieldBuilder<Double>.() -> Unit) {
        val builder = BuildConfigFieldBuilder<Double>()
        builder.configuration()
        _fields[builder.name] = BuildConfigField(builder.name, builder.value)
    }

    fun buildConfig(name: String, value: Char) {
        _fields[name] = BuildConfigField(name, value)
    }

    fun buildConfigChar(configuration: BuildConfigFieldBuilder<Char>.() -> Unit) {
        val builder = BuildConfigFieldBuilder<Char>()
        builder.configuration()
        _fields[builder.name] = BuildConfigField(builder.name, builder.value)
    }

    override fun toString(): String {
        return "BuildConfigKotlinSourceSet(" +
                "name = $name," +
                "className = $className," +
                "packageName = $packageName," +
                "fields = $fields" +
                ")"
    }
}