buildscript {
    repositories {
        gradlePluginPortal()
    }
}

plugins {
    kotlin("jvm") version "1.2.30"
    id("com.github.kukuhyoniatmoko.buildconfigkotlin").version("1.0.2")
}

java {
    this.sourceSets.create("debug")
}

buildConfigKotlin {
    sourceSet("main") {

        packageName = "consumer"

        buildConfig("stringValue", "main")
        buildConfig("intValue", 1)
        buildConfig("longValue", 1L)
        buildConfig("floatValue", 1f)
        buildConfig("doubleValue", 1.0)
        buildConfig("charValue", '1')
        buildConfig("booleanValue", true)
    }

    sourceSet("debug") {

        packageName = "consumer"

        buildConfig("stringValue", "debug")
        buildConfig("intValue", 2)
        buildConfig("longValue", 2L)
        buildConfig("floatValue", 2f)
        buildConfig("doubleValue", 2.0)
        buildConfig("charValue", '2')
        buildConfig("booleanValue", false)
    }
}