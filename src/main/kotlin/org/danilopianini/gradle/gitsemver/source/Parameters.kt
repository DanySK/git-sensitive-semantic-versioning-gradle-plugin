package org.danilopianini.gradle.gitsemver.source

import java.io.File
import org.gradle.api.provider.ListProperty
import org.gradle.api.provider.Property
import org.gradle.api.provider.ValueSourceParameters

/**
 * Parameters for passing down git command list.
 */
interface Parameters : ValueSourceParameters {
    /**
     * List of commands to execute in an external process.
     */
    val commands: ListProperty<String>

    /**
     * Working directory to execute external process in.
     */
    val directory: Property<File>
}
