package thecompletereferenc;

import java.util.concurrent.TimeUnit;

/**
 * 死锁 简易版本
 */
public class DeadLock2 {


    private static final Object lockA = new Object();
    private static final Object lockB = new Object();

    public static void main(String[] args) {
        new Thread(new ThreadA()).start();
        new Thread(new ThreadB()).start();
    }

   static class ThreadA implements  Runnable{

        @Override
        public void run() {
            synchronized (lockA){
                System.out.println("get lockA in threadA");
                TimeUnit.SECONDS.toSeconds(3);
                synchronized (lockB){
                    System.out.printf("can't be here");
                }
            }
        }
    }
   static class ThreadB implements  Runnable{

        @Override
        public void run() {
            synchronized (lockB){
                System.out.println("get lockB in threadB");
                TimeUnit.SECONDS.toSeconds(3);
                synchronized (lockA){
                    System.out.printf("can't be here");
                }
            }
        }
    }
}
