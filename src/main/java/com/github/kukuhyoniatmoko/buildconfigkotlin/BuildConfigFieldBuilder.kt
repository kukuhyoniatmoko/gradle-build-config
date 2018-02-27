package com.github.kukuhyoniatmoko.buildconfigkotlin

import java.io.Serializable

class BuildConfigFieldBuilder<T : Any> : Serializable {

    lateinit var name: String

    lateinit var value: T
}