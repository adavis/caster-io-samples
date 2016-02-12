package info.adavis.plugin

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

@SuppressWarnings("GroovyUnusedDeclaration")
public class BumpVersion extends DefaultTask {

    def readMe
    def versionName
    def overrideContent

    File getReadMe() {
        project.file(readMe)
    }

    BumpVersion() {
        group = 'plugin v2'
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