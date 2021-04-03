package demo

import javaposse.jobdsl.dsl.Job

class JobBuilder {
    private Job job

    JobBuilder(Job job) {
        this.job = job
    }

    void setDescription(String s) {
        job.with {
            description(s)
        }
    }

    void setConcurrentBuild(boolean allowConcurrentBuild) {
        job.with {
            concurrentBuild(allowConcurrentBuild)
        }
    }
}
