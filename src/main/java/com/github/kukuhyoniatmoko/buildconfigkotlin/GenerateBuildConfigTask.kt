package com.github.kukuhyoniatmoko.buildconfigkotlin

import org.gradle.api.internal.AbstractTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import java.io.File

open class GenerateBuildConfigTask : AbstractTask() {

    @Input
    lateinit var sourceSet: BuildConfigKotlinSourceSet

    @OutputDirectory
    lateinit var outputDir: File

    @TaskAction
    fun generate() {
        println("Generating $sourceSet into $outputDir starts")
        BuildConfigSpecFactory.create(sourceSet).writeTo(outputDir)
        println("Generating $sourceSet into $outputDir ends")
    }
}