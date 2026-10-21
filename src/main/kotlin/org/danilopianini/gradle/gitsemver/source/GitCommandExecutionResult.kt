package org.danilopianini.gradle.gitsemver.source

import java.io.Serializable

/**
 * The result of running an external git command: its standard [output] and its [exitCode].
 * Serializable and comparable by value, as the configuration cache stores and compares it.
 */
sealed interface GitCommandExecutionResult : Serializable {

    /**
     * The (trimmed) standard output of the command.
     */
    val output: String

    /**
     * The exit code of the command.
     */
    val exitCode: Int

    /**
     * A command that terminated successfully, with exit code 0.
     */
    data class Success(override val output: String) : GitCommandExecutionResult {
        override val exitCode: Int = 0
    }

    /**
     * A command that failed, with a non-zero [exitCode].
     */
    data class Failure(override val output: String, override val exitCode: Int) : GitCommandExecutionResult {
        init {
            require(exitCode != 0) { "Exit code must be non-zero for a failure." }
        }
    }
}
