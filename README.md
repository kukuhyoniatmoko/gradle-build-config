# gradle-build-config
Generate build config constants as kotlin's object

[![CircleCI](https://circleci.com/gh/kukuhyoniatmoko/gradle-build-config/tree/master.svg?style=svg)](https://circleci.com/gh/kukuhyoniatmoko/gradle-build-config/tree/master)

build.gradle.kts:
```groovy
plugins {
  kotlin("jvm")
  id("com.github.kukuhyoniatmoko.buildconfigkotlin") version "1.0.1"
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
