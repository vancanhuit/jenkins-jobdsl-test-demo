package demo

import javaposse.jobdsl.dsl.DslScriptLoader
import javaposse.jobdsl.dsl.FileJobManagement
import spock.lang.Specification

class SampleJobSpec extends Specification {
    void 'test sample job'() {
        given:
        FileJobManagement fileJobManagement = new FileJobManagement(new File('.'))
        String script = '''import demo.JobBuilder
def job = freeStyleJob('SampleJob')
JobBuilder builder = new JobBuilder(job)
builder.addDescription('Sample Job')'''
        when:
        new DslScriptLoader(fileJobManagement).runScript(script)

        then:
        noExceptionThrown()
    }
}
