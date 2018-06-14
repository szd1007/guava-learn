package book.concurrencyInPractice;

import java.util.concurrent.locks.LockSupport;

/**
 * AbstractQueuedSynchronizer 依赖类LockSupport阻塞线程
 * 底层hotspot实现在linux下是mutex互斥量
 *
 * Reentranlock 响应中断实现的底层机制是因为  {@link LockSupport#park()}
 * @author shangzhidong@zhuanzhuan.com
 * @date 2018-06-14 12:05
 */
public class LockSupportTest {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("start park");
                LockSupport.park();
                System.out.println("after park");
            }
        });
        t1.start();
        Thread.sleep(2000);
        System.out.println("begin interrupt");
        t1.interrupt();
        Thread.sleep(5000);
    }
}
