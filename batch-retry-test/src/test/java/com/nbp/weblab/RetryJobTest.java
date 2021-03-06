package com.nbp.weblab;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations={"/launch-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class RetryJobTest {
	@Autowired
	private JobLauncher jobLauncher;
	@Autowired
	private Job job;
	
	@Test
	public void launchJob() throws Exception {
		JobParametersBuilder builder = new JobParametersBuilder();
		builder.addLong("commit.interval" , 3L);
		jobLauncher.run(job, builder.toJobParameters());
	}
}
