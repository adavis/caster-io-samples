package info.adavis.plugin

import info.adavis.plugin.tasks.BumpVersion
import info.adavis.plugin.tasks.DisplayVersion
import org.gradle.api.Plugin
import org.gradle.api.Project

class BumpReadMeVersionPlugin implements Plugin<Project> {

    public static final String PLUGIN_GROUP = 'plugin v3'
    public static final String BUMP_VERSION_TASK = 'bumpVersion'
    public static final String DISPLAY_VERSION_TASK = 'displayVersion'

    @SuppressWarnings("GrUnresolvedAccess")
    @Override
    void apply(Project project) {

        project.extensions.create('bumpReadMeVersion', VersionPluginExtension)

        project.afterEvaluate {
            project.task(BUMP_VERSION_TASK, type: BumpVersion) {
                readMe = new File(project.rootDir.absolutePath + "/README.md")
                versionName = project?.bumpReadMeVersion?.versionName
                overrideContent = project?.bumpReadMeVersion?.overrideContent
            }

            project.task(DISPLAY_VERSION_TASK, type: DisplayVersion) {
                versionName = project?.bumpReadMeVersion?.versionName
            }
        }
    }
}