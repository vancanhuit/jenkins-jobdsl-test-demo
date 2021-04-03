import demo.JobBuilder

def job = freeStyleJob('SampleJob')
JobBuilder builder = new JobBuilder(job)
builder.setDescription('SampleJob')
builder.setConcurrentBuild(true)
