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
        }


    }

    public static void main(String[] args) throws InterruptedException {
        RunnableTest test = new RunnableTest();

        test.start();
        Thread.sleep(2000);
        System.out.println("status before  "+test.isInterrupted());

        test.interrupt();
        System.out.println("status before11  "+test.isInterrupted());

        Thread.sleep(2000);
        System.out.println("status after  "+test.isInterrupted());
    }

}
