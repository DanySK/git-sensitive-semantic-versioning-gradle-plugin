package org.danilopianini.gradle.gitsemver.test

import io.kotest.assertions.throwables.shouldThrowUnit
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.string.shouldContain
import io.kotest.matchers.string.shouldNotContain
import org.gradle.internal.impldep.org.junit.rules.TemporaryFolder
import org.gradle.testkit.runner.GradleRunner
import org.gradle.testkit.runner.UnexpectedBuildFailure
import java.util.concurrent.TimeUnit

internal class Tests : StringSpec(
    {
        "minimal configuration" {
            val result = configuredPlugin().runGradle()
            println(result)
            result shouldContain "0.1.0-archeo+"
        }
        "simple usage of extension" {
            val result = configuredPlugin("noTagIdentifier.set(\"foo\")").runGradle()
            println(result)
            result shouldContain "0.1.0-foo+"
        }
        "git single commit" {
            val result = configuredPlugin("noTagIdentifier.set(\"foo\")") {
                initGit()
            }.runGradle()
            println(result)
            result shouldContain "0.1.0-foo"
        }
        "git tagged commit" {
            val result = configuredPlugin("noTagIdentifier.set(\"foo\")") {
                initGitWithTag()
            }.runGradle()
            println(result)
            result.lines().any { it matches Regex(""".*1\.2\.3$""") } shouldBe true
        }
        "git tagged commit with prefix" {
            val result = configuredPlugin(
                """
                versionPrefix.set("v")
                """.trimIndent()
            ) {
                initGitWithPrefixedTag()
            }.runGradle()
            println(result)
            result.lines().any { it matches Regex(""".*1\.2\.3$""") } shouldBe true
        }
        "git tagged + development" {
            val workingDirectory = configuredPlugin("developmentIdentifier.set(\"foodev\")") {
                initGitWithTag()
                file("something") { "something" }
                runCommand("git add something")
                runCommand("git", "commit", "-m", "\"Test commit 2\"")
            }
            val result = workingDirectory.runGradle()
            println(result)
            val expectedVersion = "1.2.3-foodev01+"
            result shouldContain expectedVersion
            with(workingDirectory) {
                runCommand("git", "tag", "-a", "test", "-m", "test tag")
                val newResult = runGradle()
                println(newResult)
                newResult shouldContain expectedVersion
            }
            with(workingDirectory) {
                runCommand("git", "tag", "-a", "1.2.4", "-m", "\"test\"")
                val newResult = runGradle()
                println(newResult)
                newResult.lineSequence().find { it.matches(".*1.2.4$".toRegex()) } shouldNotBe null
            }
        }
        "manual assignment of version" {
            val workingDirectory = configuredPlugin("assignGitSemanticVersion()")
            val result = workingDirectory.runGradle()
            println(result)
            val expectedVersion = "0.1.0-archeo"
            result shouldContain expectedVersion
        }
        "regression for bug #2: https://github.com/DanySK/git-sensitive-semantic-versioning-gradle-plugin/issues/2" {
            val workingDirectory = configuredPlugin(
                """
                minimumVersion.set("0.1.0")
                developmentIdentifier.set("")    // <--- NOTICE THIS
                noTagIdentifier.set("")          // <--- NOTICE THIS
                developmentCounterLength.set(2) 
                """.trimIndent()
            )
            val result = workingDirectory.runGradle()
            val expectedVersion = "0.1.0+"
            result shouldContain expectedVersion
        }
        "support for lightweight tags (#323)" {
            val workingDirectory = configuredPlugin()
            with(workingDirectory) {
                initGit()
                runCommand("git", "tag", "1.2.3")
            }
            workingDirectory.runGradle() shouldContain "1.2.3"
        }
        "exclusion of lightweight tags (#323)" {
            val workingDirectory = configuredPlugin(
                """
                excludeLightweightTags() 
                """.trimIndent()
            )
            with(workingDirectory) {
                initGit()
                runCommand("git", "tag", "1.2.3")
            }
            workingDirectory.runGradle() shouldNotContain "1.2.3"
        }
        "force the version" {
            val result = configuredPlugin().runGradle("-PforceVersion=1.2.3", "printGitSemVer", "--stacktrace")
            print(result)
            result shouldContain "1.2.3"
        }
        "force the version with a non compliant version" {
            shouldThrowUnit<UnexpectedBuildFailure> {
                configuredPlugin().runGradle("-PforceVersion=a.b.c", "printGitSemVer", "--stacktrace")
            }
        }
        "force the version with a custom property" {
            val result = configuredPlugin(
                """
                forceVersionPropertyName.set("customVersion")
                """.trimIndent()
            ).runGradle("-PcustomVersion=1.2.3", "printGitSemVer", "--stacktrace")
            print(result)
            result shouldContain "1.2.3"
        }
    }
) {
    companion object {

        fun folder(closure: TemporaryFolder.() -> Unit) = TemporaryFolder().apply {
            create()
            closure()
        }

        fun TemporaryFolder.file(name: String, content: () -> String) = newFile(name).writeText(content().trimIndent())

        fun TemporaryFolder.runCommand(vararg command: String, wait: Long = 10) {
            val process = ProcessBuilder(*command)
                .directory(root)
                .redirectError(ProcessBuilder.Redirect.INHERIT)
                .redirectOutput(ProcessBuilder.Redirect.INHERIT)
                .start()
            process.waitFor(wait, TimeUnit.SECONDS)
            require(process.exitValue() == 0) {
                "command '${command.joinToString(" ")}' failed with exit value ${process.exitValue()}"
            }
        }

        fun TemporaryFolder.runCommand(command: String, wait: Long = 10) = runCommand(
            *command.split(" ").toTypedArray(),
            wait = wait
        )

        fun TemporaryFolder.initGit() {
            runCommand("git init")
            runCommand("git add .")
            runCommand("git config user.name gitsemver")
            runCommand("git config user.email none@test.com")
            runCommand("git config --global init.defaultBranch master")
            runCommand("git", "commit", "-m", "\"Test commit\"")
        }

        fun TemporaryFolder.initGitWithTag() {
            initGit()
            runCommand("git", "tag", "-a", "1.2.3", "-m", "\"test\"")
        }

        fun TemporaryFolder.initGitWithPrefixedTag() {
            initGit()
            runCommand("git", "tag", "-a", "v1.2.3", "-m", "\"test\"")
        }

        fun TemporaryFolder.runGradle(
            vararg arguments: String = arrayOf("printGitSemVer", "--stacktrace")
        ): String = GradleRunner
            .create()
            .withProjectDir(root)
            .withPluginClasspath()
            .withArguments(*arguments)
            .build().output

        fun configuredPlugin(
            pluginConfiguration: String = "",
            otherChecks: TemporaryFolder.() -> Unit = {},
        ): TemporaryFolder = folder {
            file("settings.gradle") { "rootProject.name = 'testproject'" }
            file("build.gradle.kts") {
                """
                plugins {
                    id("org.danilopianini.git-semver")
                }
                gitSemVer {
                    $pluginConfiguration
                }
                """.trimIndent()
            }
            otherChecks()
        }
    }
}
