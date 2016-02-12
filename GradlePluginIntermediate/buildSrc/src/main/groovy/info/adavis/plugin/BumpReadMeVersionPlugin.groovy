package info.adavis.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

@SuppressWarnings("GroovyUnusedDeclaration")
public class BumpReadMeVersionPlugin implements Plugin<Project> {

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