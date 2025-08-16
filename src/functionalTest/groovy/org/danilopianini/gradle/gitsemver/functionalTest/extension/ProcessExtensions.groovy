package org.danilopianini.gradle.gitsemver.functionalTest.extension

import groovy.transform.CompileStatic

@CompileStatic
class ProcessExtensions {
    static String getOutput(Process self) {
        return self.text
    }
}
