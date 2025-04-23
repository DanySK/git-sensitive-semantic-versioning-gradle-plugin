package org.danilopianini.gradle.gitsemver.functionalTest.specification

import groovy.transform.CompileStatic
import org.danilopianini.gradle.gitsemver.functionalTest.driver.GitRepositoryDriver
import org.danilopianini.gradle.gitsemver.functionalTest.driver.GradleBuildDriver
import spock.lang.Specification
import spock.lang.TempDir

@CompileStatic
class GradleBuildFunctionalTest extends Specification {
    @TempDir
    File projectDir

    @Delegate(includes = 'git')
    GitRepositoryDriver git

    GradleBuildDriver gradle

    File buildFile
    File settingsFile

    def setup() {
        git = new GitRepositoryDriver(projectDir).tap {
            environmentVariables(
                PATH: System.getenv('PATH'),
                Path: System.getenv('Path'),
            )
            globalIgnoreFile << '''\
                /.gradle/
                build/
                '''.stripIndent()
        }
        gradle = new GradleBuildDriver(projectDir).tap {
            environmentVariables(git.environmentVariables)
        }

        buildFile = new File(projectDir, 'build.gradle.kts')
        settingsFile = new File(projectDir, 'settings.gradle.kts').tap {
            createNewFile()
        }
    }
}
