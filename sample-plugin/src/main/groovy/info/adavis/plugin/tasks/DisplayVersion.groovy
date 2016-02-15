package info.adavis.plugin.tasks

import info.adavis.plugin.BumpReadMeVersionPlugin
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

public class DisplayVersion extends DefaultTask {

    def versionName

    DisplayVersion() {
        group = BumpReadMeVersionPlugin.PLUGIN_GROUP
    }

    @TaskAction
    def display() {
        description = 'Prints out the current version number'

        println "**** My Version: ${versionName} ****"
    }

}