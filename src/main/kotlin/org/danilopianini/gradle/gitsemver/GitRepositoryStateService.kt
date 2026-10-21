package org.danilopianini.gradle.gitsemver

import com.github.benmanes.caffeine.cache.Caffeine
import com.github.benmanes.caffeine.cache.LoadingCache
import java.io.File
import javax.inject.Inject
import org.gradle.api.provider.ProviderFactory
import org.gradle.api.services.BuildService
import org.gradle.api.services.BuildServiceParameters

/**
 * Shares the state of git repositories across all the projects of a build,
 * so that projects in the same repository run each git command once.
 */
abstract class GitRepositoryStateService : BuildService<BuildServiceParameters.None> {

    /**
     * Used to run git through value sources, which the configuration cache tracks as build inputs.
     */
    @get:Inject
    abstract val providerFactory: ProviderFactory

    /**
     * Repository states, keyed by the root directory of the repository
     * (or by the project directory, for projects outside a repository).
     */
    private val states: LoadingCache<File, GitRepositoryState> = Caffeine.newBuilder().build { root ->
        GitRepositoryState(providerFactory, root)
    }

    /**
     * The state of the git repository containing [directory].
     */
    internal fun stateOf(directory: File): GitRepositoryState = states[repositoryRootOf(directory)]

    private companion object {
        /*
         * The closest directory containing `.git`, which is a directory in regular repositories,
         * and a file in submodules and linked worktrees. Falls back to [directory] outside repositories.
         */
        private fun repositoryRootOf(directory: File): File {
            val start = directory.absoluteFile.normalize()
            return generateSequence(start) { it.parentFile }.firstOrNull { File(it, ".git").exists() } ?: start
        }
    }
}
