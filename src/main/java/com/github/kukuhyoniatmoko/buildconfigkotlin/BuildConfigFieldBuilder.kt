package com.github.kukuhyoniatmoko.buildconfigkotlin

import java.io.Serializable

data class BuildConfigFieldBuilder<T : Any>(var name: String = "") : Serializable {

    lateinit var value: T
}