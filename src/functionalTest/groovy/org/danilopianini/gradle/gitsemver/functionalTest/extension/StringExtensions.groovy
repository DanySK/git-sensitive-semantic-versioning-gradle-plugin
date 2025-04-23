package org.danilopianini.gradle.gitsemver.functionalTest.extension

import groovy.transform.CompileStatic

import java.util.regex.Pattern

@CompileStatic
class StringExtensions {
    static boolean lineMatches(CharSequence self, String regex) {
        return self.readLines().find { it.matches(regex) }
    }

    static boolean lineMatches(CharSequence self, Pattern regex) {
        return self.readLines().find { it.matches(regex) }
    }
}
