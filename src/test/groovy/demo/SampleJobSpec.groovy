package demo

import javaposse.jobdsl.dsl.DslScriptLoader
import javaposse.jobdsl.plugin.JenkinsJobManagement
import org.junit.Rule
import org.jvnet.hudson.test.JenkinsRule
import spock.lang.Specification

class SampleJobSpec extends Specification {
    @Rule
    JenkinsRule jenkinsRule = new JenkinsRule()

    void 'test sample job'() {
        given:
        JenkinsJobManagement jobManagement = new JenkinsJobManagement(System.out, [:], new File('.'))
        String script = '''import demo.JobBuilder
def job = freeStyleJob('SampleJob')
JobBuilder builder = new JobBuilder(job)
builder.addDescription('Sample Job')'''
        when:
        new DslScriptLoader(jobManagement).runScript(script)

        then:
        noExceptionThrown()
    }
}
