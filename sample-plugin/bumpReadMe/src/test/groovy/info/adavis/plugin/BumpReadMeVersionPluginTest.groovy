package info.adavis.plugin

import org.gradle.testfixtures.ProjectBuilder
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder

import static org.junit.Assert.assertNotNull
import static org.junit.Assert.assertEquals

/**
 * @author Annyce Davis on 2/17/16.
 */
public class BumpReadMeVersionPluginTest {

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder()

    def projectDir
    def project
    def task

    @Before
    void setUp() {
        projectDir = temporaryFolder.root
        projectDir.mkdirs()

        project = ProjectBuilder.builder().withProjectDir(projectDir).build()
    }

    @Test
    public void pluginShouldBeApplied() {
        project.apply plugin: BumpReadMeVersionPlugin

        project.evaluate()

        assertNotNull(project.tasks.findByName(BumpReadMeVersionPlugin.BUMP_VERSION_TASK))
        assertNotNull(project.tasks.findByName(BumpReadMeVersionPlugin.DISPLAY_VERSION_TASK))
    }

    @Test
    public void pluginShouldHandleExtensionVersionInfo() {
        project.apply plugin: BumpReadMeVersionPlugin
        project.bumpReadMeVersion {
            versionName = '1.1'
        }

        project.evaluate()

        assertEquals('1.1', project.tasks[BumpReadMeVersionPlugin.DISPLAY_VERSION_TASK].versionName)
    }

}