import demo.JobBuilder
import javaposse.jobdsl.dsl.jobs.FreeStyleJob

FreeStyleJob job = freeStyleJob('SampleJob')
JobBuilder builder = new JobBuilder(job)
builder.setDescription('SampleJob')
builder.setConcurrentBuild(true)
