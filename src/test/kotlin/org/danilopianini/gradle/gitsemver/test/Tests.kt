package org.danilopianini.gradle.gitsemver.test

import io.kotlintest.matchers.string.shouldContain
import io.kotlintest.specs.StringSpec
import org.gradle.internal.impldep.org.junit.rules.TemporaryFolder
import org.gradle.testkit.runner.GradleRunner
import java.io.File

class Tests : StringSpec({
    fun folder(closure: TemporaryFolder.() -> Unit) = TemporaryFolder().apply {
        create()
        closure()
    }
    fun TemporaryFolder.file(name: String, content: () -> String) = newFile(name).writeText(content().trimIndent())
    val pluginClasspathResource = ClassLoader.getSystemClassLoader()
        .getResource("plugin-classpath.txt")
        ?: throw IllegalStateException("Did not find plugin classpath resource, run \"testClasses\" build task.")
    val classpath = pluginClasspathResource.openStream().bufferedReader().use { reader ->
        reader.readLines().map { File(it) }
    }
    "minimal configuration" {
        val workingDirectory = folder {
            file("settings.gradle") { "rootProject.name = 'testproject'" }
            file("build.gradle.kts") { """
                plugins {
                    id("org.danilopianini.git-semver")
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
            file("build.gradle.kts") { """
                plugins {
                    id("org.danilopianini.git-semver")
                }
                gitSemVer {
                    noTagIdentifier.set("foo")
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
})
