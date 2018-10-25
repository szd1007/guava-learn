package org.adamx.quartz.quartzTest;

import org.quartz.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class QuartzTestApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(QuartzTestApplication.class, args);
	}

	@Bean
	public JobDetail sampleJobDetail() {
		return JobBuilder.newJob(SampleJob.class).withIdentity("sampleJob")
                         .usingJobData("name", "World").storeDurably().build();
	}

	@Bean
	public Trigger sampleJobTrigger() {
		SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                                                                     .withIntervalInSeconds(2).repeatForever();

		return TriggerBuilder.newTrigger().forJob(sampleJobDetail())
                             .withIdentity("sampleTrigger").withSchedule(scheduleBuilder).build();
	}

    @Override
    public void run(String... args) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>>>> input args...." + (args.length > 0 ? args[0] : "null"));
        TimeUnit.SECONDS.sleep(6);
        System.out.println(">>>>>>>>>>>>>>>>>>> run success");

    }
}
