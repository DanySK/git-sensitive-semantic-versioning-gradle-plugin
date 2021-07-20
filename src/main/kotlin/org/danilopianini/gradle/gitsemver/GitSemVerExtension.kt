package org.danilopianini.gradle.gitsemver

import org.danilopianini.gradle.gitsemver.GitSemVerExtension.Companion.propertyWithDefault
import org.gradle.api.Project
import org.gradle.api.provider.Property

open class GitSemVerExtension @JvmOverloads constructor(
    private val project: Project,
//    internal var gitSemVer: () -> String = {
//        throw IllegalStateException(
//            "Version computation called before configuration"
//        )
//    },
    val minimumVersion: Property<String> = project.propertyWithDefault("0.1.0"),
    val developmentIdentifier: Property<String> = project.propertyWithDefault("dev"),
    val noTagIdentifier: Property<String> = project.propertyWithDefault("archeo"),
    val fullHash: Property<Boolean> = project.propertyWithDefault(false),
    val maxVersionLength: Property<Int> = project.propertyWithDefault(Int.MAX_VALUE),
    val developmentCounterLength: Property<Int> = project.propertyWithDefault(2),
    val enforceSemanticVersioning: Property<Boolean> = project.propertyWithDefault(true),
    val preReleaseSeparator: Property<String> = project.propertyWithDefault("-"),
    val buildMetadataSeparator: Property<String> = project.propertyWithDefault("+"),
    val distanceCounterRadix: Property<Int> = project.propertyWithDefault(36),
) {
//    fun computeGitSemVer() = gitSemVer()
    companion object {
        const val extensionName = "gitSemVer"
        inline fun <reified T> Project.propertyWithDefault(default: T): Property<T> =
            objects.property(T::class.java).apply { convention(default) }
    }
}
