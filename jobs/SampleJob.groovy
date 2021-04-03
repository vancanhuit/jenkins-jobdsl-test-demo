import javaposse.jobdsl.dsl.jobs.FreeStyleJob
import demo.builder.JobBuilder

FreeStyleJob job = freeStyleJob('SampleJob')
JobBuilder builder = new JobBuilder(job)
builder.setDescription('SampleJob')
builder.setConcurrentBuild(true)
