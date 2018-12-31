package concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(5);

        System.out.println("Starting");
        new Thread(new MyThread(cdl)).start();

        new Thread(()->{
            System.out.println("Sub Thread waiting ");
            try {
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Sub Thread stop ");
        }).start();
        System.out.println("Main Thread waiting end ");
        cdl.await();
        System.out.println("Main Thread stop");


    }
}

class MyThread implements Runnable{
    CountDownLatch latch;

    MyThread(CountDownLatch countDownLatch) {
        latch = countDownLatch;
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            latch.countDown();//decrement count
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}