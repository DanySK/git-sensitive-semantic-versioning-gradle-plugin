@file:Suppress("SuspiciousCollectionReassignment", "UnstableApiUsage")

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
    alias(libs.plugins.testkitJacoco)
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

val functionalTest = "functionalTest"
testing {
    suites {
        val test = getByName<JvmTestSuite>("test")
        register<JvmTestSuite>(functionalTest) {
            useSpock(libs.versions.spock)
            dependencies { implementation(project()) }
            targets {
                all {
                    testTask.configure {
                        shouldRunAfter(test)
                        project.providers.systemPropertiesPrefixedBy("spock.").get().forEach { (key, value) ->
                            systemProperty(key, value)
                        }
                    }
                }
            }
        }
    }
}

multiJvm {
    jvmVersionForCompilation = oldestJavaSupportedByGradle
    maximumSupportedJvmVersion = latestJavaSupportedByGradle
}

dependencies {
    api(gradleApi())
    api(gradleKotlinDsl())
    implementation(kotlin("stdlib"))
    implementation(libs.caffeine)
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
            events(*TestLogEvent.entries.toTypedArray())
        }
    }
    jacocoTestReport {
        // TestKit coverage from every test task is dumped into the execution data of `test`
        dependsOn(test, functionalTest)
    }
}

if ("true" == System.getenv("CI")) {
    signing {
        val signingKey = findProperty("signingKey")?.toString()
        val signingPassword = findProperty("signingPassword")?.toString()
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
            sourceSets.named(functionalTest).get(),
        )
    }
}
