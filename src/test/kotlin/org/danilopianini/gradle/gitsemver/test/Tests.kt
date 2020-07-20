package org.danilopianini.gradle.gitsemver.test

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
import org.gradle.internal.impldep.org.junit.rules.TemporaryFolder
import org.gradle.testkit.runner.GradleRunner
import java.io.File
import java.util.concurrent.TimeUnit

class Tests : StringSpec({
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
    fun TemporaryFolder.runCommand(command: String, wait: Long = 10) = runCommand(*command.split(" ").toTypedArray(), wait = wait)
    val pluginClasspathResource = ClassLoader.getSystemClassLoader()
        .getResource("plugin-classpath.txt")
        ?: throw IllegalStateException("Did not find plugin classpath resource, run \"testClasses\" build task.")
    val classpath = pluginClasspathResource.openStream().bufferedReader().use { reader ->
        reader.readLines().map { File(it) }
    }
    "minimal configuration" {
        val workingDirectory = folder {
            file("settings.gradle") { "rootProject.name = 'testproject'" }
            file("build.gradle.kts") {
                """
                plugins {
                    id("org.danilopianini.git-semver")
                }
                gitSemVer {
                    version = computeGitSemVer()
                }
                """.trimIndent()
            }
        }
        val result = GradleRunner.create()
            .withProjectDir(workingDirectory.root)
            .withPluginClasspath(classpath)
            .withArguments("printGitSemVer")
            .build()
        println(result.output)
        result.output shouldContain "0.1.0-archeo+"
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
                    version = computeGitSemVer()
                }
                """.trimIndent()
            }
        }
        val result = GradleRunner.create()
            .withProjectDir(workingDirectory.root)
            .withPluginClasspath(classpath)
            .withArguments("printGitSemVer")
            .build()
        println(result.output)
        result.output shouldContain "0.1.0-foo+"
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
                    version = computeGitSemVer()
                }
                """.trimIndent()
            }
            runCommand("git init")
            runCommand("git add .")
            runCommand("git", "commit", "-m", "\"Test commit\"")
        }
        val result = GradleRunner.create()
            .withProjectDir(workingDirectory.root)
            .withPluginClasspath(classpath)
            .withArguments("printGitSemVer")
            .build()
        println(result.output)
        result.output shouldContain "0.1.0-foo+"
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
                    version = computeGitSemVer()
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
        val result = GradleRunner.create()
            .withProjectDir(workingDirectory.root)
            .withPluginClasspath(classpath)
            .withArguments("printGitSemVer")
            .build()
        println(result.output)
        result.output.lines().any { it matches Regex(""".*1\.2\.3$""") } shouldBe true
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
                    version = computeGitSemVer()
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
        val result = GradleRunner.create()
            .withProjectDir(workingDirectory.root)
            .withPluginClasspath(classpath)
            .withArguments("printGitSemVer")
            .build()
        println(result.output)
        result.output shouldContain "1.2.3-foodev01+"
    }
})
