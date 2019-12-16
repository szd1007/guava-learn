package concurrency;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo {
    public static void demo1(String[] args) throws InterruptedException {
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
        System.out.println("Main Thread waiting  ");
        cdl.await();
        System.out.println("Main Thread stop");


    }

    private static final CountDownLatch startLatch = new CountDownLatch(1);
    private static final CountDownLatch endLatch = new CountDownLatch(5);
    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                try {
                    startLatch.await();
                    System.out.println("线程" + Thread.currentThread().getName() + " 开始执行");
                    executeRandom();
                    endLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        startLatch.countDown();
        System.out.println(" start recording ...");
        long cur = System.currentTimeMillis();
        endLatch.await();
        System.out.println("end recording ... total use :"+ (System.currentTimeMillis()-cur)+"ms");

    }

    private static void executeRandom() throws InterruptedException {

        int random = new Random().nextInt(4);
        TimeUnit.SECONDS.sleep(random);
        System.out.println(Thread.currentThread().getName() + "use " + random + "s");
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