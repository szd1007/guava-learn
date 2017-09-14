package book.concurrencyInPractice;


/**
 * Created by shangzhidong on 2017/9/14.
 */
public class ObjectLockTest {
    static int flag = 0;

    public static void main(String[] args) throws InterruptedException {
        final Object a = new Object();

        Thread t1 = new Thread(new Runnable() {
            public void run() {

                synchronized (a) { //中断响应不友好，如果当前线程没有获取锁那么他不会相应中断，重入锁即使没有获取也会响应
                    System.out.println(" get lock");//
                    while (flag == 0) {
                        try {
                            System.out.println("jude flag false thread wait");
                            a.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("judge flag true" );
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {

                synchronized (a) {
                    System.out.println(" t2 get lock");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(" t2 release lock" );
                }
            }
        });
//        t1.start();
//        t2.start();
//
//        Thread.sleep(1000);
//        System.out.println("interrupt while t1 is waiting ");
//        t1.interrupt();
//        Thread.sleep(3000);
//
//        flag =1;
//        synchronized (a){
//            System.out.println("notify t1 , so t1 can throw exception ");
//            a.notify();
//        }
        t2.start();
        Thread.sleep(100);
        t1.start();
        Thread.sleep(100);
        t1.interrupt();
        Thread.sleep(1000);
        t1.interrupt();
    }
}
