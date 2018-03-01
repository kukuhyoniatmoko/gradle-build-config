package com.github.kukuhyoniatmoko.buildconfigkotlin

import org.gradle.api.internal.AbstractTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import java.io.File

open class GenerateBuildConfigTask : AbstractTask() {

    @get:Input
    lateinit var sourceSet: BuildConfigKotlinSourceSet

    @get:OutputDirectory
    lateinit var outputDir: File

    @TaskAction
    fun generate() {
        BuildConfigSpecFactory.create(sourceSet).writeTo(outputDir)
    }
}