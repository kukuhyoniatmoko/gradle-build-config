# gradle-build-config
Generate build config constants as kotlin's object

[![CircleCI](https://circleci.com/gh/kukuhyoniatmoko/gradle-build-config/tree/master.svg?style=svg)](https://circleci.com/gh/kukuhyoniatmoko/gradle-build-config/tree/master)

### JVM

Example of build.gradle.kts for jvm:
```kotlin
plugins {
  kotlin("jvm")
  id("com.github.kukuhyoniatmoko.buildconfigkotlin") version "1.0.5"
}

java {
    sourceSets.create("debug")
}

buildConfigKotlin {
  sourceSet("main") {
    buildConfig(name = "stringConstant", value = "value")
    buildConfig(name = "intConstant", value = 1)
    buildConfig(name = "longConstant", value = 1L)
    buildConfig(name = "floatConstant", value = 1f)
    buildConfig(name = "doubleConstant", value = 1.0)
  }
  
  sourceSet("debug") {
    buildConfig(name = "stringConstant", value = "value")
    buildConfig(name = "intConstant", value = 1)
    buildConfig(name = "longConstant", value = 1L)
    buildConfig(name = "floatConstant", value = 1f)
    buildConfig(name = "doubleConstant", value = 1.0)
  }
}
```

### Android
on android you should add generated code into source set manually

Example of build.gradle.kts for android:
```kotlin
plugins {
  id("com.android.application")
  kotlin("android")
  id("com.github.kukuhyoniatmoko.buildconfigkotlin") version "1.0.5"
}

android {
    compileSdkVersion("$compileSdkVersion")

    defaultConfig {
        applicationId = "$applicationId"
        minSdkVersion("$minSdkVersion")
        targetSdkVersion("$targetSdkVersion")
        versionCode = "$versionCode"
        versionName = "$versionName"

        testInstrumentationRunner = "$testInstrumentationRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    sourceSets {
        getByName("main") {
            /* add generated code into source set */
            java.srcDir("build/generated/source/buildconfigkotlin/src/main")
        }
    }

    compileOptions {
        setSourceCompatibility(JavaVersion.VERSION_1_8)
        setTargetCompatibility(JavaVersion.VERSION_1_8)
    }
}

buildConfigKotlin {
  sourceSet("main") {
    buildConfig(name = "stringConstant", value = "value")
    buildConfig(name = "intConstant", value = 1)
    buildConfig(name = "longConstant", value = 1L)
    buildConfig(name = "floatConstant", value = 1f)
    buildConfig(name = "doubleConstant", value = 1.0)
  }
}
```

generated object:
```kotlin
object BuildConfig {

  const val stringConstant: String = "value"
  
  const val intConstant: Int = 1
  
  const val longConstant: Long = 1L
  
  const val floatConstant: Float = 1f
  
  const val doubleConstant: Float = 1.0
}
```
