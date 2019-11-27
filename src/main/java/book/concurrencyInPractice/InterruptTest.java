package book.concurrencyInPractice;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by zm on 2017/6/29.
 */
public class InterruptTest {
    private static BlockingQueue<String> queue = new ArrayBlockingQueue(10);

    static class RunnableTest extends Thread {

        @Override
        public void run(){
            while(!Thread.currentThread().isInterrupted()){
                try {
                    System.out.println("block get from queue");
                    queue.take();
//                    queue.wait(); //必须在持有锁的情况下进行调用，wait方法执行会释放当前锁对象，
// 唤醒前要重新竞争获取锁对象然后恢复； wait方法公认的使用方法必须在一个循环之内，防止其他因素唤醒线程
                } catch (InterruptedException e) {
                    System.err.println("intterupt  accept");
                    //queue阻塞任务相应中断，1 抛出异常 2 将中断标志位清空
                }
            }
            System.out.println("thread exit");
        }


    }

    static class RunT2 extends Thread{
        @Override
        public void run() {
            System.err.println("runT2 start");
            while (true);
//            System.err.println("runT2 exit");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        RunnableTest test = new RunnableTest();
        RunT2 runT2  = new RunT2();
        runT2.start();
        test.start();
        Thread.sleep(2000);
        System.out.println("status before  "+test.isInterrupted());
        System.err.println("t2 before " + runT2.isInterrupted());
        test.interrupt();
        runT2.interrupt();
        System.out.println("status before11  "+test.isInterrupted());
        System.err.println("t2 before11 " + runT2.isInterrupted());
        Thread.sleep(2000);
        System.out.println("status after  "+test.isInterrupted());
        System.err.println("t2 after " + runT2.isInterrupted());

    }

}
