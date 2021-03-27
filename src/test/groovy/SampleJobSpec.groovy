import javaposse.jobdsl.dsl.DslScriptLoader
import javaposse.jobdsl.dsl.FileJobManagement
import spock.lang.Specification

class SampleJobSpec extends Specification {
    void 'test sample job'() {
        given:
        FileJobManagement fileJobManagement = new FileJobManagement(new File('.'))
        String script = '''job('SampleJob'){
description('Sample Job')
}'''
        when:
        new DslScriptLoader(fileJobManagement).runScript(script)

        then:
        noExceptionThrown()
    }
}
