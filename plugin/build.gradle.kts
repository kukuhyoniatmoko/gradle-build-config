import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        gradlePluginPortal()
    }
}

plugins {
    `kotlin-dsl`
    id("java-gradle-plugin")
    id("com.gradle.plugin-publish") version "0.10.0"
}

group = "com.github.kukuhyoniatmoko"
version = "1.0.4"

pluginBundle {
    website = "https://github.com/kukuhyoniatmoko/gradle-build-config"
    vcsUrl = "https://github.com/kukuhyoniatmoko/gradle-build-config"

    plugins {
        create("buildConfigKotlin") {
            id = "com.github.kukuhyoniatmoko.buildconfigkotlin"
            displayName = "Gradle Build Config for Kotlin"
            description = "Generate constants with kotlin's object"
            tags = setOf("gradle", "kotlin", "build config")
            version = "1.0.4"
        }
    }
}

val kotlinVersion = "1.2.71"

repositories {
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8", kotlinVersion))
    compileOnly(kotlin("gradle-plugin", kotlinVersion))

    implementation("com.squareup:kotlinpoet:1.0.0-RC2")
    implementation(gradleApi())

    testImplementation("junit:junit:4.12")
    testImplementation(gradleTestKit())
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
