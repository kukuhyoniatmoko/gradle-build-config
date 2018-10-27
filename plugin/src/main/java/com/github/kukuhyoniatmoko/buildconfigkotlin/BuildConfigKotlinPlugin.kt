package com.github.kukuhyoniatmoko.buildconfigkotlin

import org.gradle.api.GradleException
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.artifacts.UnknownConfigurationException
import org.gradle.api.logging.LogLevel
import org.gradle.api.plugins.JavaPluginConvention
import org.gradle.api.tasks.SourceSet
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class BuildConfigKotlinPlugin : Plugin<Project> {

    private val taskOptions = mapOf(
        Task.TASK_TYPE to GenerateBuildConfigTask::class.java,
        Task.TASK_GROUP to TASK_GROUP
    )

    override fun apply(target: Project) {
        target.extensions.create(
            EXTENSION_NAME,
            BuildConfigKotlinExtension::class.java,
            target
        )
        target.afterEvaluate {
            buildConfigSourceSets.forEach { set ->
                checkConfiguration(set)
                val sourceSet = extractSourceSet(set)
                val task = createGenerateBuildConfigTask(set)
                sourceSet?.java?.srcDir(task.outputDir)
                tasks.withType<KotlinCompile> {
                    dependsOn += task
                }
            }
        }
    }

    private val Project.buildConfigSourceSets: List<BuildConfigKotlinSourceSet>
        get() {
            val extension = extensions.getByType(BuildConfigKotlinExtension::class.java)
            val sourceSets = extension.sourceSets
            return sourceSets.toList()
        }

    private fun Project.extractSourceSet(set: BuildConfigKotlinSourceSet): SourceSet? {
        return convention.findPlugin(JavaPluginConvention::class.java)
            ?.sourceSets
            ?.findByName(set.name)
            .also {
                if (it == null) {
                    logger.log(LogLevel.WARN, """
                        buildConfigKotlin can not find source set with name `${set.name}`!
                        The generated code should be included into source set manually
                        Usually its on build/$GENERATE_DIR/${set.name}
                    """.trimIndent())
                }
            }
    }

    private fun Project.checkConfiguration(set: BuildConfigKotlinSourceSet) {
        val configurationName = if (set.name == "main") "compile" else "${set.name}Compile"
        try {
            configurations.getByName(configurationName)
        } catch (e: UnknownConfigurationException) {
            throw  GradleException("Configuration with name: $configurationName not found.", e)
        }
    }

    private fun createTaskName(prefix: String, name: String, suffix: String): String {
        val isMain = name == "main"
        val nameIt: String = if (isMain) "" else name.capitalize()
        return "$prefix$nameIt$suffix"
    }

    private fun Project.createGenerateBuildConfigTask(
        set: BuildConfigKotlinSourceSet
    ): GenerateBuildConfigTask {
        val taskName = createTaskName("generate", set.name, TASK_GROUP)
        val task = task(taskOptions, taskName) as GenerateBuildConfigTask

        task.sourceSet = set
        task.outputDir = buildDir.toPath()
            .resolve(GENERATE_DIR)
            .resolve(set.name)
            .toFile()

        task.description = "Generate ${set.packageName}.${set.className} for configuration: ${set.name}"

        return task
    }

    companion object {
        private const val GENERATE_DIR = "generated/source/buildconfigkotlin/src"
        private const val EXTENSION_NAME = "buildConfigKotlin"
        private const val TASK_GROUP = "BuildConfigKotlin"
    }
}
