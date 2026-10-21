package org.danilopianini.gradle.gitsemver.source

import java.io.ByteArrayOutputStream
import java.nio.charset.Charset
import javax.inject.Inject
import org.gradle.api.provider.ValueSource
import org.gradle.process.ExecOperations

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
