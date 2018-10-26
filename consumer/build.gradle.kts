buildscript {
    repositories {
        gradlePluginPortal()
    }
}

repositories {
    gradlePluginPortal()
    jcenter()
}

plugins {
    `java-gradle-plugin`
    kotlin("jvm") version "1.2.71"
    id("com.github.kukuhyoniatmoko.buildconfigkotlin").version("1.0.3")
}

java {
    sourceSets.create("debug")
}

buildConfigKotlin {
    sourceSet("main", Action {

        packageName = "consumer"

        buildConfig("stringValue", "main")
        buildConfig("intValue", 1)
        buildConfig("longValue", 1L)
        buildConfig("floatValue", 1f)
        buildConfig("doubleValue", 1.0)
        buildConfig("charValue", '1')
        buildConfig("booleanValue", true)
    })

    sourceSet("debug", Action {

        packageName = "consumer"

        buildConfig("stringValue", "debug")
        buildConfig("intValue", 2)
        buildConfig("longValue", 2L)
        buildConfig("floatValue", 2f)
        buildConfig("doubleValue", 2.0)
        buildConfig("charValue", '2')
        buildConfig("booleanValue", false)
    })
}

dependencies {
    testImplementation("junit:junit:4.12")
}
