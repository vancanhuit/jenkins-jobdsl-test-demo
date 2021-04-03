package demo.jobs

import javaposse.jobdsl.dsl.DslScriptLoader
import javaposse.jobdsl.dsl.GeneratedItems
import javaposse.jobdsl.dsl.GeneratedJob
import javaposse.jobdsl.plugin.JenkinsJobManagement
import org.junit.ClassRule
import org.junit.rules.TemporaryFolder
import org.jvnet.hudson.test.JenkinsRule
import spock.lang.Shared
import spock.lang.Specification

class SampleJobSpec extends Specification {
    @Shared
    @ClassRule
    JenkinsRule jenkinsRule = new JenkinsRule()

    @Shared
    @ClassRule
    TemporaryFolder temporaryFolder = TemporaryFolder.builder().assureDeletion().build()

    void 'test sample job'() {
        given:
        JenkinsJobManagement jobManagement = new JenkinsJobManagement(System.out, [:], temporaryFolder.newFolder())
        String script = new File('jobs/SampleJob.groovy').getText('UTF-8')

        when:
        GeneratedItems items = new DslScriptLoader(jobManagement).runScript(script)

        then:
        noExceptionThrown()
        items.jobs.size() == 1
        GeneratedJob generatedJob = items.jobs.first()
        generatedJob != null
        generatedJob.jobName == 'SampleJob'
    }
}
