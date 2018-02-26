import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    var kotlinVersion: String by extra
    kotlinVersion = "1.2.21"

    repositories {
        gradlePluginPortal()
        jcenter()
    }

    dependencies {
        classpath(kotlin("gradle-plugin", kotlinVersion))
    }
}

group = "com.github.kukuhyoniatmoko"
version = "1.0-SNAPSHOT"

plugins {
    `kotlin-dsl` version "0.15.4"
    id("java-gradle-plugin")
    id("com.gradle.plugin-publish") version "0.9.10"
}

val kotlinVersion: String by extra

repositories {
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8", kotlinVersion))
    implementation(kotlin("gradle-plugin", kotlinVersion))
    implementation("com.squareup:kotlinpoet:0.7.0")
    implementation(gradleApi())

    testImplementation("junit:junit:4.12")
    testImplementation(gradleTestKit())
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}