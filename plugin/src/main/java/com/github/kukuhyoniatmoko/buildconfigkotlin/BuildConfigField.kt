package com.github.kukuhyoniatmoko.buildconfigkotlin

import java.io.Serializable

internal data class BuildConfigField internal constructor(
    internal val name: String,
    internal val value: Any
) : Serializable