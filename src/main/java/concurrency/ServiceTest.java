package concurrency;

import com.google.common.util.concurrent.AbstractExecutionThreadService;

import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by zm on 17/1/15.
 *https://github.com/google/guava/wiki/ServiceExplained
 */
public class ServiceTest {

    static class ExecutionThreadServiceTest extends AbstractExecutionThreadService{
        @Override
        protected void run() throws Exception {
            while (true) {
                System.out.println(" out in service"+this.getClass().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {
        ExecutionThreadServiceTest threadServiceTest = new ExecutionThreadServiceTest();
        threadServiceTest.startAsync();
        int i=0;
        while (true) {
            System.out.println("out in main" + ServiceTest.class.getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(++i>3){
                threadServiceTest.stopAsync();
                System.out.println("stop");
            }
        }
    }

}
