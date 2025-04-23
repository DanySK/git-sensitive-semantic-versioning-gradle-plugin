package org.danilopianini.gradle.gitsemver.functionalTest.driver

import groovy.transform.CompileStatic

@CompileStatic
class GitRepositoryDriver {
    private final List arguments = []
    private final Map<String, String> environmentVariables = [:]

    final File workTreeDir
    final File gitDir
    final File globalConfigDir
    final File globalIgnoreFile

    GitRepositoryDriver(File workTreeDir) {
        this.workTreeDir = workTreeDir
        this.gitDir = new File(this.workTreeDir, '.git/')
        this.globalConfigDir = new File(this.gitDir, '.home.d/')
        this.globalIgnoreFile = new File(this.globalConfigDir, '.gitignore')

        assert workTreeDir && workTreeDir.directory \
            : 'work tree directory must be set and it must be a directory'

        environmentVariables.HOME = workTreeDir.relativePath(globalConfigDir)
        environmentVariables.GIT_CONFIG_NOSYSTEM = '1'

        arguments.addAll(
            '-c', 'core.autocrlf=input',
            '-c', "core.excludesFile=${workTreeDir.relativePath(globalIgnoreFile)}",
            '-c', 'init.defaultBranch=master',
            '-c', 'user.name=Git Repository Driver',
            '-c', 'user.email=git-repository-driver@example.com',
        )

        globalIgnoreFile.tap { ggif ->
            ggif.parentFile.mkdirs()
            ggif.createNewFile()
        }
    }

    Map<String, String> getEnvironmentVariables() {
        return environmentVariables.asUnmodifiable()
    }

    GitRepositoryDriver environmentVariables(Map<String, String> envVars) {
        envVars.each { name, value ->
            environmentVariable(name, value)
        }
        return this
    }

    GitRepositoryDriver environmentVariable(String name, String value) {
        if (value == null) {
            environmentVariables.remove(name)
        } else {
            environmentVariables.put(name, value)
        }
        return this
    }

    Process git(def... arguments) {
        return execute(arguments)
    }

    Process execute(def... arguments) {
        def builder = createProcessBuilder(arguments)
        def process = builder.start()
        process.waitFor()

        return process
    }

    protected ProcessBuilder createProcessBuilder(def... arguments) {
        def commandLine = [
            'git',
            this.arguments*.toString(),
            arguments*.toString()
        ].flatten() as List<String>

        def builder = new ProcessBuilder()
            .directory(workTreeDir)
            .command(commandLine)
            .redirectErrorStream(true)

        builder.environment().tap { e ->
            e.clear()
            e.putAll(this.environmentVariables)
        }

        return builder
    }
}
