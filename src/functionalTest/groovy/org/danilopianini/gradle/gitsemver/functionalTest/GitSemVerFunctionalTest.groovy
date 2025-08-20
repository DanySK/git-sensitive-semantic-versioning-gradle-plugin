package org.danilopianini.gradle.gitsemver.functionalTest

import org.danilopianini.gradle.gitsemver.functionalTest.extension.ProcessExtensions
import org.danilopianini.gradle.gitsemver.functionalTest.extension.StringExtensions
import org.danilopianini.gradle.gitsemver.functionalTest.specification.GradleBuildFunctionalTest
import spock.util.mop.Use

import java.util.regex.Pattern

@Use([StringExtensions, ProcessExtensions])
class GitSemVerFunctionalTest extends GradleBuildFunctionalTest {

    static final Pattern ARCHEO_TIME = ~/0\.1\.0-archeo\+[0-9]+/
    static final Pattern ARCHEO_HASH = ~/0\.1\.0-archeo\+[0-9a-f]{7}/
    static final Pattern DEV_HASH = ~/0\.1\.1-dev01\+[0-9a-f]{7}/

    def setup() {
        buildFile << '''\
            plugins {
                id("org.danilopianini.git-sensitive-semantic-versioning")
            }

            gitSemVer {
                enforceSemanticVersioning = false
            }

            tasks.register("printVersion") {
                doLast {
                    println(project.version)
                }
            }
            '''.stripIndent()
    }

    def cleanup() {
        println '''
            >>> Repository status after test interruption:
            '''.stripIndent()

        println(git('log', '--decorate=full').output)
    }

    def 'how the plugin implementation should work'() {
        given:
        buildFile << """
            gitSemVer {
                ${configuration}
            }
            """.stripIndent()

        when: 'the current version of the project is printed'
        gradle.build('printVersion')

        then: 'the version printed is compliant with: "Archeo" versions for the development before initializing git, in the form of `0.1.0-archeo+time`'
        gradle.buildResult.output.lineMatches(expectedArcheoVersion)

        when: 'git is initialized'
        git('init')

        and: 'the current version of the project is printed'
        gradle.build('printVersion')

        then: 'the version printed is compliant with: "Archeo" versions for the development before initializing git, in the form of `0.1.0-archeo+time`'
        gradle.buildResult.output.lineMatches(expectedArcheoVersion)

        when: 'git has some commits'
        git('commit', '--allow-empty', '--message=initial commit')

        and: 'the current version of the project is printed'
        gradle.build('printVersion')

        then: 'the version printed is compliant with: "Pre-development" versions for the development before marking the first release, in the form of `0.1.0-archeo+hash`'
        gradle.buildResult.output.lineMatches(expectedPreDevelopmentVersion)

        when: 'the last commit is tagged'
        git('tag', gitTag)

        and: 'the current version of the project is printed'
        gradle.build('printVersion')

        then: 'the version printed is compliant with: "Stable" versions if a compatible tag is present, in the form `0.1.0`'
        gradle.buildResult.output.lineMatches(expectedStableVersion)

        when: 'a new commit has been added'
        git('commit', '--allow-empty', '--message=some change added')

        and: 'the current version of the project is printed'
        gradle.build('printVersion')

        then: 'the version printed is compliant with: "Development" versions for changes over a compatible tag, in the form `0.1.1-dev01+hash`, with the number after `dev` counting the distance in commits since the last tag'
        gradle.buildResult.output.lineMatches(expectedDevelopmentVersion)

        where:
        configuration                        | gitTag   || expectedArcheoVersion         | expectedPreDevelopmentVersion      | expectedStableVersion          | expectedDevelopmentVersion
        ''                                   | '0.1.0'  || ARCHEO_TIME                   | ARCHEO_HASH                        | ~/0\.1\.0/                     | DEV_HASH
        ''                                   | 'v0.1.0' || ARCHEO_TIME                   | ARCHEO_HASH                        | ARCHEO_HASH                    | ARCHEO_HASH
        'minimumVersion = "0.2.0"'           | '0.1.0'  || ~/0\.2\.0-archeo\+[0-9]+/     | ~/0\.2\.0-archeo\+[0-9a-f]{7}/     | ~/0\.1\.0/                     | ~/0\.2\.0-dev01\+[0-9a-f]{7}/
        'minimumVersion = "0.2.0"'           | '0.2.0'  || ~/0\.2\.0-archeo\+[0-9]+/     | ~/0\.2\.0-archeo\+[0-9a-f]{7}/     | ~/0\.2\.0/                     | ~/0\.2\.1-dev01\+[0-9a-f]{7}/
        'developmentIdentifier = "ownDevId"' | '0.1.0'  || ARCHEO_TIME                   | ARCHEO_HASH                        | ~/0\.1\.0/                     | ~/0\.1\.1-ownDevId01\+[0-9a-f]{7}/
        'noTagIdentifier = "ownNoTagId"'     | '0.1.0'  || ~/0\.1\.0-ownNoTagId\+[0-9]+/ | ~/0\.1\.0-ownNoTagId\+[0-9a-f]{7}/ | ~/0\.1\.0/                     | DEV_HASH
        'fullHash = true'                    | '0.1.0'  || ARCHEO_TIME                   | ~/0\.1\.0-archeo\+[0-9a-f]{40}/    | ~/0\.1\.0/                     | ~/0\.1\.1-dev01\+[0-9a-f]{40}/
        'maxVersionLength = 15'              | '0.1.0'  || ~/0\.1\.0-archeo\+[0-9]{2}/   | ~/0\.1\.0-archeo\+[0-9a-f]{2}/     | ~/0\.1\.0/                     | ~/0\.1\.1-dev01\+[0-9a-f]{3}/
        'developmentCounterLength = 4'       | '0.1.0'  || ARCHEO_TIME                   | ARCHEO_HASH                        | ~/0\.1\.0/                     | ~/0\.1\.1-dev0001\+[0-9a-f]{7}/
        'computeReleaseVersion = true'       | '0.1.0'  || ~/0\.1\.0/                    | ~/0\.1\.0/                         | ~/0\.1\.0/                     | ~/0\.1\.1/
        'preReleaseSeparator = "#"'          | '0.1.0'  || ~/0\.1\.0#archeo\+[0-9]+/     | ~/0\.1\.0#archeo\+[0-9a-f]{7}/     | ~/0\.1\.0/                     | ~/0\.1\.1#dev01\+[0-9a-f]{7}/
        'buildMetadataSeparator = "@"'       | '0.1.0'  || ~/0\.1\.0-archeo@[0-9]+/      | ~/0\.1\.0-archeo@[0-9a-f]{7}/      | ~/0\.1\.0/                     | ~/0\.1\.1-dev01@[0-9a-f]{7}/
        'distanceCounterRadix = 2'           | '0.1.0'  || ARCHEO_TIME                   | ARCHEO_HASH                        | ~/0\.1\.0/                     | DEV_HASH
        'versionPrefix = "v"'                | '0.1.0'  || ARCHEO_TIME                   | ARCHEO_HASH                        | ~/0\.1\.0-archeo\+[0-9a-f]{7}/ | ~/0\.1\.0-archeo\+[0-9a-f]{7}/
        'versionPrefix = "v"'                | 'v0.1.0' || ARCHEO_TIME                   | ARCHEO_HASH                        | ~/0\.1\.0/                     | ~/0\.1\.1-dev01\+[0-9a-f]{7}/
    }
}
