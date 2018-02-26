package com.github.kukuhyoniatmoko.buildconfigkotlin

import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Project

open class BuildConfigKotlinExtension(project: Project) {

    val sourceSets: NamedDomainObjectContainer<BuildConfigKotlinSourceSet> =
            project.container(BuildConfigKotlinSourceSet::class.java, ::BuildConfigKotlinSourceSet)

    fun sourceSets(configuration: NamedDomainObjectContainer<BuildConfigKotlinSourceSet>.() -> Unit) {
        sourceSets.configuration()
    }
}