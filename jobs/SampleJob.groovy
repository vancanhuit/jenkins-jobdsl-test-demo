import demo.JobBuilder

def job = freeStyleJob('SampleJob')
JobBuilder builder = new JobBuilder(job)
builder.addDescription('SampleJob')
