@file:Suppress("SuspiciousCollectionReassignment")

import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    `java-gradle-plugin`
    groovy
    alias(libs.plugins.dokka)
    alias(libs.plugins.gitSemVer)
    alias(libs.plugins.gradle.plugin.publish)
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.qa)
    alias(libs.plugins.publishOnCentral)
    alias(libs.plugins.multiJvmTesting)
    alias(libs.plugins.taskTree)
}

group = "org.danilopianini"

class ProjectInfo {
    val projectId = "$group.$name"
    val fullName = "Gradle Git-Sensitive Semantic Versioning Plugin"
    val projectDetails = "A Gradle plugin that forces semantic versioning and relies on git to detect the project state"
    val pluginImplementationClass = "org.danilopianini.gradle.gitsemver.GitSemVer"
    val websiteUrl = "https://github.com/DanySK/$name"
    val vcsUrl = "$websiteUrl.git"
    val scm = "scm:git:$websiteUrl.git"
    val tags = listOf("git", "semver", "semantic versioning", "vcs", "tag")
}
val info = ProjectInfo()

gitSemVer {
    maxVersionLength.set(20)
    buildMetadataSeparator.set("-")
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {}

        val functionalTest by registering(JvmTestSuite::class) {
            useSpock("2.3-groovy-4.0")

            dependencies {
                implementation(project())
            }

            targets {
                all {
                    testTask.configure {
                        shouldRunAfter(test)
                        project.providers
                            .systemPropertiesPrefixedBy("spock.")
                            .get()
                            .forEach { (key, value) ->
                                systemProperty(key, value)
                            }
                    }
                }
            }
        }
    }
}

multiJvm {
    jvmVersionForCompilation = 17
    maximumSupportedJvmVersion = latestJavaSupportedByGradle
}

dependencies {
    api(gradleApi())
    api(gradleKotlinDsl())
    implementation(kotlin("stdlib-jdk8"))
    testImplementation(gradleTestKit())
    testImplementation(kotlin("test"))
    testImplementation(libs.bundles.kotlin.testing)
}

kotlin {
    compilerOptions {
        allWarningsAsErrors = true
    }
}

publishOnCentral {
    projectDescription.set(info.projectDetails)
    projectLongName.set(info.fullName)
    projectUrl.set(info.websiteUrl)
    scmConnection.set(info.scm)
    repository("https://maven.pkg.github.com/DanySK/${rootProject.name}".lowercase(), name = "github") {
        user.set("danysk")
        password.set(System.getenv("GITHUB_TOKEN"))
    }
}

tasks {
    withType<Test> {
        useJUnitPlatform()
        testLogging {
            showCauses = true
            showStackTraces = true
            showStandardStreams = true
            events(*TestLogEvent.values())
        }
    }
}

if ("true" == System.getenv("CI")) {
    signing {
        val signingKey: String? by project
        val signingPassword: String? by project
        useInMemoryPgpKeys(signingKey, signingPassword)
    }
}

publishing {
    publications {
        withType<MavenPublication> {
            pom {
                developers {
                    developer {
                        name.set("Danilo Pianini")
                        email.set("danilo.pianini@gmail.com")
                        url.set("http://www.danilopianini.org/")
                    }
                }
                contributors {
                    contributor {
                        name = "Piotr Minkina"
                        url = "http://www.piotrminkina.pl"
                    }
                }
            }
        }
    }
}

gradlePlugin {
    plugins {
        website.set(info.websiteUrl)
        vcsUrl.set(info.vcsUrl)
        create("long") {
            id = info.projectId
            displayName = info.fullName
            description = info.projectDetails
            implementationClass = info.pluginImplementationClass
            tags.set(info.tags)
        }
        create("short") {
            id = "$group.git-sensitive-semantic-versioning"
            displayName = info.fullName
            description = info.projectDetails
            implementationClass = info.pluginImplementationClass
            tags.set(info.tags)
        }
        testSourceSets(
            sourceSets.test.get(),
            sourceSets.named("functionalTest").get(),
        )
    }
}
