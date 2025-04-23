package org.danilopianini.gradle.gitsemver.functionalTest.driver

import groovy.transform.CompileStatic
import org.gradle.testkit.runner.BuildResult
import org.gradle.testkit.runner.GradleRunner

import javax.annotation.Nullable

@CompileStatic
class GradleBuildDriver {
    private final File projectDir
    private final List arguments = []
    private final Map<String, String> environmentVariables = [:]

    @Nullable
    private BuildResult buildResult

    GradleBuildDriver(File projectDir) {
        this.projectDir = projectDir

        assert projectDir && projectDir.directory \
            : 'project directory must be set and it must be a directory'

        arguments.addAll(
            '--build-cache',
            '--full-stacktrace',
            '--parallel',
        )
    }

    Map<String, String> getEnvironmentVariables() {
        return environmentVariables.asUnmodifiable()
    }

    GradleBuildDriver environmentVariables(Map<String, String> envVars) {
        envVars.each { name, value ->
            environmentVariable(name, value)
        }
        return this
    }

    GradleBuildDriver environmentVariable(String name, String value) {
        if (value == null) {
            environmentVariables.remove(name)
        } else {
            environmentVariables.put(name, value)
        }
        return this
    }

    BuildResult getBuildResult() {
        return buildResult
    }

    BuildResult build(def... arguments) {
        def runner = createGradleRunner(arguments)
        buildResult = runner.build()
        return buildResult
    }

    BuildResult buildAndFail(def... arguments) {
        def runner = createGradleRunner(arguments)
        buildResult = runner.buildAndFail()
        return buildResult
    }

    protected GradleRunner createGradleRunner(def ... arguments) {
        return createGradleRunner(arguments as List)
    }

    protected GradleRunner createGradleRunner(List arguments = []) {
        def runner = GradleRunner.create()
            .withProjectDir(projectDir)
            .withPluginClasspath()
            .withEnvironment(environmentVariables)
            .withArguments((this.arguments + arguments)*.toString() as String[])
            .forwardOutput()

        return runner
    }
}
