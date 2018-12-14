package thecompletereferenc;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author shangzhidong@zhuanzhuan.com
 * @date 2018-12-14 11:23
 */
public class TimerTaskTest {

    public static void main(String[] args) throws InterruptedException {
        MyTimerTask myTimerTask = new MyTimerTask();
        Timer myTimer = new Timer();

        /*
            set an initial delay of 1 second,
            then repeat every half second.
         */
        myTimer.schedule(myTimerTask, 1000, 500);

        Thread.sleep(5000);
        myTimer.cancel();
    }
}


class MyTimerTask extends TimerTask {

    @Override
    public void run() {
        System.out.println("Timer task executed.");
    }
}
