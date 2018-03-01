package com.github.kukuhyoniatmoko.buildconfigkotlin

import org.gradle.testkit.runner.GradleRunner
import org.gradle.testkit.runner.TaskOutcome
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import java.io.File
import java.io.FileOutputStream

class GenerateBuildConfigTaskTest {

    @Rule
    @JvmField
    val testProjectDir = TemporaryFolder()
    private lateinit var buildFile: File

    @Before
    fun setup() {
        buildFile = testProjectDir.newFile("build.gradle")
        val buildGradle = """
            buildscript {
                repositories {
                    jcenter()
                }
                dependencies {
                    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.2.21")
                }
            }

            plugins {
                id("kotlin")
                id("com.github.kukuhyoniatmoko.buildconfigkotlin")
            }

            buildConfigKotlin {
                main {
                    packageName = "com.github.kukuhyoniatmoko.test"

                    buildConfig("stringValue", "test")
                    buildConfig("intValue", 1)
                    buildConfig("longValue", 1L)
                    buildConfig("floatValue", 1f)
                    buildConfig("doubleValue", 1.0)
                    buildConfig("charValue", '1')
                    buildConfig("booleanValue", true)
                }
            }
        """.trimIndent()

        FileOutputStream(buildFile).bufferedWriter().use {
            it.write(buildGradle)
            it.flush()
        }
    }

    @Test
    fun generateTest() {
        val result = GradleRunner.create()
            .withPluginClasspath()
            .withProjectDir(testProjectDir.root)
            .withArguments("clean", "build")
            .build()

        result.tasks.filter { it is GenerateBuildConfigTask }.forEach {
            assert(it.outcome == TaskOutcome.SUCCESS)
        }
    }
}