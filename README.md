# gradle-build-config
Generate build config constants as kotlin's object

[![CircleCI](https://circleci.com/gh/kukuhyoniatmoko/gradle-build-config/tree/master.svg?style=svg)](https://circleci.com/gh/kukuhyoniatmoko/gradle-build-config/tree/master)

build.gradle.kts:
```kotlin
plugins {
  kotlin("jvm")
  id(""com.github.kukuhyoniatmoko.buildconfigkotlin") version "1.0.1"
}

buildConfigKotlin {
  sourceSet("main") {
    buildConfig(name = "stringConstants", value = "value")
    buildConfig(name = "intConstants", value = 1)
    buildConfig(name = "longConstants", value = 1L)
    buildConfig(name = "floatConstants", value = 1f)
    buildConfig(name = "doubleConstants", value = 1.0)
  }
}
```

generated object:
```kotlin
object BuildConfig {

  const val stringConstants: String = "value"
  
  const val intConstants: Int = 1
  
  const val longConstants: Long = 1L
  
  const val floatConstants: Float = 1f
  
  const val doubleConstants: Float = 1.0
}
```
