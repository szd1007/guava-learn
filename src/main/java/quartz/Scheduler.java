package quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author szd1007@github.com
 * @date 2018-08-08 21:19
 */
public class Scheduler {

    public void schedule() {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        org.quartz.Scheduler scheduler = null;

        try {
            scheduler = schedulerFactory.getScheduler();
            JobDetail job1 = JobBuilder.newJob(MyJob.class).withIdentity("job1", "group1").build();

            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("simpleTrigger", "triggerGroup")
                                            .withSchedule(CronScheduleBuilder.cronSchedule("0/1 * * * * ? *"))
                                            .startNow().build();
            scheduler.scheduleJob(job1, trigger);

            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Scheduler().schedule();
        System.out.println("started");
    }
}
