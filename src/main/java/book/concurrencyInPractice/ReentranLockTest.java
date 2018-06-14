package book.concurrencyInPractice;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by shangzhidong on 2017/9/14.
 */
public class ReentranLockTest {

    static int flag = 0;
    static ReentrantLock lock = new ReentrantLock();

    static Thread t1 = new Thread(new Runnable() {

        @Override
        public void run() {
            System.out.println("t1 before get lock ");

            try {
                lock.lockInterruptibly();
                System.out.println(" get lock 1 ");
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
            try {
                Thread.sleep(800000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            System.out.println("judge flag true 1");
            lock.unlock();
            System.out.println("t1 after get lock ");
        }

    });
    static Thread t2 = new Thread(new Runnable() {

        @Override
        public void run() {
            System.out.println("t2 before get lock ");
            try {
                lock.lockInterruptibly();
                System.out.println(" get lock 2");
//                try {
//                    Thread.sleep(8000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                                float a = 0;
                                while (true) {
                //                    System.out.println(a);
                                    a ++;
                                    a%=10000;
                                    if (a == 1000) {
                //                        System.out.println(a);
                                    }
                                    if (a > 2000000) {
                                        break;
                                    }
                                }

                System.out.println("judge flag true 2");
                lock.unlock();
                System.out.println("t2 after get lock ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    });

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(1000);
        t2.start();
        Thread.sleep(5000);
        System.out.println("interrupt t2");
        t2.interrupt();

    }
}
