package org.danilopianini.gradle.gitsemver.source

import org.gradle.api.provider.ListProperty
import org.gradle.api.provider.Property
import org.gradle.api.provider.ValueSource
import org.gradle.api.provider.ValueSourceParameters
import org.gradle.process.ExecOperations
import java.io.ByteArrayOutputStream
import java.io.File
import java.nio.charset.Charset
import javax.inject.Inject

/**
 * Value source for reading results of external git commands.
 */
abstract class GitCommandValueSource : ValueSource<String, Parameters> {
    /**
     * Execution operations instance to execute external process.
     */
    @get:Inject
    abstract val execOperations: ExecOperations

    override fun obtain(): String {
        val output = ByteArrayOutputStream()

        execOperations.exec {
            it.apply {
                commandLine = parameters.commands.get()
                workingDir = parameters.directory.get()
                standardOutput = output
                isIgnoreExitValue = true
            }
        }
        return String(output.toByteArray(), Charset.defaultCharset())
    }
}

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
