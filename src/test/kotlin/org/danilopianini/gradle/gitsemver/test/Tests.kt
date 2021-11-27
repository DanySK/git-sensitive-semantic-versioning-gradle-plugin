package org.danilopianini.gradle.gitsemver.test

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.string.shouldContain
import org.gradle.internal.impldep.org.junit.rules.TemporaryFolder
import org.gradle.testkit.runner.GradleRunner
import java.io.File
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
                runCommand("git init")
                runCommand("git add .")
                runCommand("git", "commit", "-m", "\"Test commit\"")
            }.runGradle()
            println(result)
            result shouldContain "0.1.0-foo+"
        }
        "git tagged commit" {
            val result = configuredPlugin("noTagIdentifier.set(\"foo\")") {
                initGit()
            }.runGradle()
            println(result)
            result.lines().any { it matches Regex(""".*1\.2\.3$""") } shouldBe true
        }
        "git tagged + development" {
            val workingDirectory = configuredPlugin("developmentIdentifier.set(\"foodev\")") {
                initGit()
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
                runCommand("git", "tag", "-a", "1.2.4", "-m", "stable")
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
            println(result)
            val expectedVersion = "0.1.0+"
            result shouldContain expectedVersion
        }
    }
) {
    companion object {

        val pluginClasspathResource = ClassLoader.getSystemClassLoader()
            .getResource("plugin-classpath.txt")
            ?: throw IllegalStateException("Did not find plugin classpath resource, run \"testClasses\" build task.")

        val classpath = pluginClasspathResource.openStream().bufferedReader().use { reader ->
            reader.readLines().map { File(it) }
        }

        fun folder(closure: TemporaryFolder.() -> Unit) = TemporaryFolder().apply {
            create()
            closure()
        }

        fun TemporaryFolder.file(name: String, content: () -> String) = newFile(name).writeText(content().trimIndent())

        fun TemporaryFolder.runCommand(vararg command: String, wait: Long = 10) = ProcessBuilder(*command)
            .directory(root)
            .redirectError(ProcessBuilder.Redirect.INHERIT)
            .redirectOutput(ProcessBuilder.Redirect.INHERIT)
            .start()
            .waitFor(wait, TimeUnit.SECONDS)

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
            runCommand("git", "tag", "-a", "1.2.3", "-m", "\"test\"")
        }

        fun TemporaryFolder.runGradle(
            vararg arguments: String = arrayOf("printGitSemVer", "--stacktrace")
        ): String = GradleRunner
            .create()
            .withProjectDir(root)
            .withPluginClasspath(classpath)
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
