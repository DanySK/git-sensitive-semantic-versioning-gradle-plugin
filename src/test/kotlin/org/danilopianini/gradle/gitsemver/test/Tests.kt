package org.danilopianini.gradle.gitsemver.test

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.string.shouldContain
import org.gradle.internal.impldep.org.junit.rules.TemporaryFolder
import org.gradle.testkit.runner.GradleRunner
import java.io.File
import java.util.concurrent.TimeUnit

class Tests : StringSpec(
    {
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
        val pluginClasspathResource = ClassLoader.getSystemClassLoader()
            .getResource("plugin-classpath.txt")
            ?: throw IllegalStateException("Did not find plugin classpath resource, run \"testClasses\" build task.")
        val classpath = pluginClasspathResource.openStream().bufferedReader().use { reader ->
            reader.readLines().map { File(it) }
        }
        fun TemporaryFolder.runGradle(vararg arguments: String = arrayOf("printGitSemVer")): String = GradleRunner
            .create()
            .withProjectDir(root)
            .withPluginClasspath(classpath)
            .withArguments(*arguments)
            .build().output
        "minimal configuration" {
            val workingDirectory = folder {
                file("settings.gradle") { "rootProject.name = 'testproject'" }
                file("build.gradle.kts") {
                    """
                    plugins {
                        id("org.danilopianini.git-semver")
                    }
                    """.trimIndent()
                }
            }
            val result = workingDirectory.runGradle()
            println(result)
            result shouldContain "0.1.0-archeo+"
        }
        "simple usage of extension" {
            val workingDirectory = folder {
                file("settings.gradle") { "rootProject.name = 'testproject'" }
                file("build.gradle.kts") {
                    """
                    plugins {
                        id("org.danilopianini.git-semver")
                    }
                    gitSemVer {
                        noTagIdentifier.set("foo")
                    }
                    """.trimIndent()
                }
            }
            val result = workingDirectory.runGradle()
            println(result)
            result shouldContain "0.1.0-foo+"
        }
        "git single commit" {
            val workingDirectory = folder {
                file("settings.gradle") { "rootProject.name = 'testproject'" }
                file("build.gradle.kts") {
                    """
                    plugins {
                        id("org.danilopianini.git-semver")
                    }
                    gitSemVer {
                        noTagIdentifier.set("foo")
                    }
                    """.trimIndent()
                }
                runCommand("git init")
                runCommand("git add .")
                runCommand("git", "commit", "-m", "\"Test commit\"")
            }
            val result = workingDirectory.runGradle()
            println(result)
            result shouldContain "0.1.0-foo+"
        }
        "git tagged commit" {
            val workingDirectory = folder {
                file("settings.gradle") { "rootProject.name = 'testproject'" }
                file("build.gradle.kts") {
                    """
                    plugins {
                        id("org.danilopianini.git-semver")
                    }
                    gitSemVer {
                        noTagIdentifier.set("foo")
                    }
                    """.trimIndent()
                }
                runCommand("git init")
                runCommand("git add .")
                runCommand("git config user.name gitsemver")
                runCommand("git config user.email none@test.com")
                runCommand("git", "commit", "-m", "\"Test commit\"")
                runCommand("git", "tag", "-a", "1.2.3", "-m", "\"test\"")
            }
            val result = workingDirectory.runGradle()
            println(result)
            result.lines().any { it matches Regex(""".*1\.2\.3$""") } shouldBe true
        }
        "git tagged + development" {
            val workingDirectory = folder {
                file("settings.gradle") { "rootProject.name = 'testproject'" }
                file("build.gradle.kts") {
                    """
                    plugins {
                        id("org.danilopianini.git-semver")
                    }
                    gitSemVer {
                        developmentIdentifier.set("foodev")
                    }
                    """.trimIndent()
                }
                runCommand("git init")
                runCommand("git add .")
                runCommand("git config user.name gitsemver")
                runCommand("git config user.email none@test.com")
                runCommand("git", "commit", "-m", "\"Test commit\"")
                runCommand("git", "tag", "-a", "1.2.3", "-m", "\"test\"")
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
    }
)
