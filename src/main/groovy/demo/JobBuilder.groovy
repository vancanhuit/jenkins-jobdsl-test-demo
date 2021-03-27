package demo

import javaposse.jobdsl.dsl.Job

class JobBuilder {
    private Job job

    private JobBuilder(Job job) {
        this.job = job
    }

    void addDescription(String s) {
        this.job.with {
            description(s)
        }
    }
}
