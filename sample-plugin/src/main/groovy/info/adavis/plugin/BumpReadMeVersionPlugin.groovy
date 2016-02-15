package info.adavis.plugin

import info.adavis.plugin.tasks.BumpVersion
import info.adavis.plugin.tasks.DisplayVersion
import org.gradle.api.Plugin
import org.gradle.api.Project

class BumpReadMeVersionPlugin implements Plugin<Project> {

    def static final PLUGIN_GROUP = 'plugin v3'

    @Override
    void apply(Project project) {

        project.extensions.create('bumpReadMeVersion', VersionPluginExtension)

        project.afterEvaluate {
            project.task('bumpVersion', type: BumpVersion) {
                readMe = new File(project.rootDir.absolutePath + "/README.md")
                versionName = project.android.defaultConfig.versionName
                overrideContent = project?.bumpReadMeVersion?.overrideContent
            }

            project.task('displayVersion', type: DisplayVersion) {
                versionName = project.android.defaultConfig.versionName
            }
        }
    }
}