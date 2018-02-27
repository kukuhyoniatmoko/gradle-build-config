package com.github.kukuhyoniatmoko.buildconfigkotlin

import groovy.lang.Closure
import org.gradle.api.Action
import org.gradle.api.InvalidUserDataException
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Project
import org.gradle.util.Configurable

open class BuildConfigKotlinExtension(project: Project) : Configurable<NamedDomainObjectContainer<BuildConfigKotlinSourceSet>> {

    /** Generated objects configuration */
    val sourceSets: NamedDomainObjectContainer<BuildConfigKotlinSourceSet> =
            project.container(BuildConfigKotlinSourceSet::class.java, ::BuildConfigKotlinSourceSet)

    /**
     * Creates a new [BuildConfigKotlinSourceSet] with the given [name],
     * adding it to the [sourceSets], then configuring it with the given [configuration].
     *
     * @throws [InvalidUserDataException] if an [BuildConfigKotlinSourceSet] with the given name already exists in this
     * container.
     */
    @Throws(InvalidUserDataException::class)
    fun sourceSet(name: String, configuration: BuildConfigKotlinSourceSet.() -> Unit): BuildConfigKotlinSourceSet {
        return sourceSets.create(name, configuration)
    }

    /**
     * Creates a new [BuildConfigKotlinSourceSet] with the given [name],
     * adding it to the [sourceSets], then configuring it with the given [Action] configuration.
     *
     * @throws [InvalidUserDataException] if an [BuildConfigKotlinSourceSet] with the given name already exists in this
     * container.
     */
    @Throws(InvalidUserDataException::class)
    fun sourceSet(name: String, configuration: Action<BuildConfigKotlinSourceSet>): BuildConfigKotlinSourceSet {
        return sourceSets.create(name, configuration)
    }

    /**
     * Creates a new [BuildConfigKotlinSourceSet] with the given [name],
     * adding it to the [sourceSets], then configuring it with the given [Closure] configuration.
     *
     * @throws [InvalidUserDataException] if an [BuildConfigKotlinSourceSet] with the given name already exists in this
     * container.
     */
    @Throws(InvalidUserDataException::class)
    fun sourceSet(name: String, configuration: Closure<*>): BuildConfigKotlinSourceSet {
        return sourceSets.create(name, configuration)
    }

    /** Access [sourceSets] */
    operator fun invoke(): NamedDomainObjectContainer<BuildConfigKotlinSourceSet> {
        return sourceSets
    }

    /**
     * Allows the [sourceSets] to be configured, creating missing [BuildConfigKotlinSourceSet] as they are referenced
     */
    override fun configure(configuration: Closure<*>): NamedDomainObjectContainer<BuildConfigKotlinSourceSet> {
        return sourceSets.configure(configuration)
    }
}