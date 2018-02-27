package com.github.kukuhyoniatmoko.buildconfigkotlin

import groovy.lang.Closure
import org.gradle.api.Action
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Project
import org.gradle.util.Configurable

open class BuildConfigKotlinExtension(project: Project) : Configurable<NamedDomainObjectContainer<BuildConfigKotlinSourceSet>> {

    val sourceSets: NamedDomainObjectContainer<BuildConfigKotlinSourceSet> =
            project.container(BuildConfigKotlinSourceSet::class.java, ::BuildConfigKotlinSourceSet)

    fun sourceSet(name: String, configuration: BuildConfigKotlinSourceSet.() -> Unit): BuildConfigKotlinSourceSet {
        return sourceSets.create(name, configuration)
    }

    fun sourceSet(name: String, configuration: Action<BuildConfigKotlinSourceSet>): BuildConfigKotlinSourceSet {
        return sourceSets.create(name, configuration)
    }

    fun sourceSet(name: String, configuration: Closure<*>): BuildConfigKotlinSourceSet {
        return sourceSets.create(name, configuration)
    }

    override fun configure(configuration: Closure<*>): NamedDomainObjectContainer<BuildConfigKotlinSourceSet> {
        return sourceSets.configure(configuration)
    }
}