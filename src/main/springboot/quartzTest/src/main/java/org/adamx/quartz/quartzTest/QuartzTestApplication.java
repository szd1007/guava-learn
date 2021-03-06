package org.adamx.quartz.quartzTest;

import org.adamx.quartz.quartzTest.conf.ThirdPartConf;
import org.adamx.quartz.quartzTest.service.HelloWorldService;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.annotation.Validated;

import javax.annotation.PreDestroy;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class QuartzTestApplication implements CommandLineRunner{

	@Autowired
    private HelloWorldService helloWorldService;

	@Autowired
	private ExitCodeGenerator codeGenerator;

	@Autowired
    private ThirdPartConf thirdPartConf;

	public static void main(String[] args) {
		SpringApplication.run(QuartzTestApplication.class, args);
//        System.exit(SpringApplication.exit(SpringApplication.run(QuartzTestApplication.class, args)));
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

    @Bean
    public ExitCodeGenerator exitCodeGenerator() {
        return () -> 101;
    }

    @ConfigurationProperties(prefix = "another")
    @Bean
    @Validated
    public ThirdPartConf getThirdPartConf(){
	    return new ThirdPartConf();
    }


    //shutdown hook函数。 相同功能  DisposableBean
    @PreDestroy
    public void preDestroyDemo() {

        System.out.println("run before exit");
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>>>> input args...." + (args.length > 0 ? args[0] : "null"));
        System.out.println(helloWorldService.getHelloMessage());
        TimeUnit.SECONDS.sleep(1);

        System.out.println(">>>>>>>>>>>>>>>>>>> run success");

        System.out.println("third conf" + thirdPartConf);

        //执行退出
//        System.exit(codeGenerator.getExitCode());
    }
}
