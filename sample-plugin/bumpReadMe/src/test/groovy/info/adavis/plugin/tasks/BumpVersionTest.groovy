package info.adavis.plugin.tasks;

import org.gradle.testfixtures.ProjectBuilder;
import org.junit.Before;
import org.junit.Rule
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import static org.junit.Assert.*;

/**
 * @author Annyce Davis on 2/16/16.
 */
@SuppressWarnings("GroovyUnusedDeclaration")
public class BumpVersionTest {

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
    void shouldBeAbleToCreateTask() {
        task = project.tasks.create('bumpVersion', BumpVersion)

        assertTrue(task instanceof BumpVersion)
    }

    @Test
    public void shouldBeAbleToModifyReadMe() {
        def readMeFile = temporaryFolder.newFile('README.md')
        readMeFile.write('plugin:0.0')

        task = project.task('bumpVersion', type: BumpVersion) {
            readMe = readMeFile
            versionName = '1.1'
            overrideContent = 'plugin:'
        }

        task.bump()

        assertEquals("the file's contents are not equal", 'plugin:1.1', readMeFile.text)
    }
}