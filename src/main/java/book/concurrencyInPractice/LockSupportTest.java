package book.concurrencyInPractice;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

/**
 * AbstractQueuedSynchronizer 依赖类LockSupport阻塞线程
 * 底层hotspot实现在linux下是mutex互斥量
 *
 * Reentranlock 响应中断实现的底层机制是因为  {@link LockSupport#park()}
 * @author szd1007@github.com
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

        Thread t2 = new Thread(()->{
            System.out.println("t2 park before");
            LockSupport.park();
            System.out.println("t2 park after");
        });
        Thread t3 = new Thread(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t3 park before");
            LockSupport.park();
            System.out.println("t3 park after");
        });
        Thread t4 = new Thread(()->{
            System.out.println("t4 unpark t3");
            LockSupport.unpark(t3);

        });
//        t1.start();
//        Thread.sleep(2000);
//        System.out.println("begin interrupt");
//        t1.interrupt();
//        Thread.sleep(5000);

        //***LockSupport  hotspot 实现
        // 每个线程 有一个Parker类实例。里面用mutex和condition保护了一个_counter的变量（只能是0 1）。
        // 每个线程内的park 和unpark 调用不要求顺序。 如果unpark先于park那么，调用park会直接返回(unpark后 _counter变为1）
        //mutext 保证 改代码段同时只有一个线程可执行。 condition则是判断符合某一条件的线程进行阻塞，唤醒
        //condition 的优点是wait后阻塞调用线程，并且释放自己的锁。等到唤醒时再进行锁获取（mutex）
        System.out.println("t2 start");
        t2.start();
        Thread.sleep(1000);
        System.out.println("t3 start");
        t3.start();
        Thread.sleep(1000);
        t4.start();

        Thread.sleep(1000);
        System.out.println("unpark t2");
        LockSupport.unpark(t2);

        Thread.sleep(5000);
    }
}
