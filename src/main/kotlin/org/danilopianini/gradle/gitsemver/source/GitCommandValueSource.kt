package org.danilopianini.gradle.gitsemver.source

import java.io.ByteArrayOutputStream
import java.nio.charset.Charset
import javax.inject.Inject
import org.gradle.api.provider.ValueSource
import org.gradle.process.ExecOperations

/**
 * Value source for reading results of external git commands.
 * Failures do not raise exceptions: they are reported as [GitCommandExecutionResult.Failure].
 * The output is trimmed.
 */
abstract class GitCommandValueSource : ValueSource<GitCommandExecutionResult, Parameters> {
    /**
     * Execution operations instance to execute external process.
     */
    @get:Inject
    abstract val execOperations: ExecOperations

    override fun obtain(): GitCommandExecutionResult {
        val output = ByteArrayOutputStream()
        val result = execOperations.exec {
            it.apply {
                commandLine = parameters.commands.get()
                workingDir = parameters.directory.get()
                standardOutput = output
                isIgnoreExitValue = true
            }
        }
        val text = String(output.toByteArray(), Charset.defaultCharset()).trim()
        return when (result.exitValue) {
            0 -> GitCommandExecutionResult.Success(text)
            else -> GitCommandExecutionResult.Failure(text, result.exitValue)
        }
    }
}
