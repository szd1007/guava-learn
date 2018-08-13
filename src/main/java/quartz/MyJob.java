package quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import util.TimeUtil;

/**
 * @author shangzhidong@zhuanzhuan.com
 * @date 2018-08-08 21:17
 */
public class MyJob implements Job{

    private int a = 1;

    public MyJob() {
        a++;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("run job "+ TimeUtil.getTime());
        System.out.println(a);
    }
}
