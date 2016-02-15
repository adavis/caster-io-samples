package info.adavis.plugin.tasks

import info.adavis.plugin.BumpReadMeVersionPlugin
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class BumpVersion extends DefaultTask {

    def readMe
    def versionName
    def overrideContent

    File getReadMe() {
        project.file(readMe)
    }

    BumpVersion() {
        group = BumpReadMeVersionPlugin.PLUGIN_GROUP
    }

    @TaskAction
    def bump() {
        description = 'Updates ReadMe file with the latest version'

        File readMeFile = getReadMe()
        String contents = readMeFile.getText('UTF-8')
        contents = contents.replaceAll("${overrideContent}.*", "${overrideContent}${versionName}")
        readMeFile.write(contents, 'UTF-8')
    }

}