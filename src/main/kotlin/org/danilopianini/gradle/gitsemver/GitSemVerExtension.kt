package org.danilopianini.gradle.gitsemver

import org.gradle.api.Project
import org.gradle.api.provider.Property

open class GitSemVerExtension @JvmOverloads constructor(
    private val project: Project,
    val minimumVersion: Property<String> = project.propertyWithDefault("0.1.0"),
    val developmentIdentifier: Property<String> = project.propertyWithDefault("dev"),
    val noTagIdentifier: Property<String> = project.propertyWithDefault("archeo"),
    val fullHash: Property<Boolean> = project.propertyWithDefault(false),
    val maxVersionLength: Property<Int> = project.propertyWithDefault(Int.MAX_VALUE),
    val developmentCounterLength: Property<Int> = project.propertyWithDefault(2)
) {
    companion object {
        const val extensionName = "gitSemVer"
        inline fun <reified T> Project.propertyWithDefault(default: T): Property<T> =
            objects.property(T::class.java).apply { convention(default) }
    }
}
