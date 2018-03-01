package com.github.kukuhyoniatmoko.buildconfigkotlin

import java.io.Serializable

class BuildConfigFieldBuilder<T : Any> : Serializable {

    /** Name of the [BuildConfigField] */
    lateinit var name: String

    /** Value of the [BuildConfigField] */
    lateinit var value: T
}