package info.adavis.plugin

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

@SuppressWarnings("GroovyUnusedDeclaration")
public class DisplayVersion extends DefaultTask {

    def versionName

    DisplayVersion() {
        group = 'plugin v2'
    }

    @TaskAction
    def display() {
        description = 'Prints out the current version number'

        println "**** My Version: ${versionName} ****"
    }

}