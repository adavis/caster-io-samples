package info.adavis.plugin.tasks

import org.gradle.testfixtures.ProjectBuilder
import org.junit.Before
import org.junit.Test

import static org.junit.Assert.assertTrue;

/**
 * @author Annyce Davis on 2/16/16.
 */
@SuppressWarnings("GroovyUnusedDeclaration")
public class DisplayVersionTest {

    def project
    def task

    @Before
    void setUp() {
        project = ProjectBuilder.builder().build()
    }

    @Test
    void shouldBeAbleToCreateTask() {
        task = project.tasks.create('displayVersion', DisplayVersion)

        assertTrue(task instanceof DisplayVersion)
    }

}