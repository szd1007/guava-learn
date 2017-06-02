package book.concurrencyInPractice;

import java.util.concurrent.*;

/**
 * Created by zm on 2017/6/2.
 */
public class ThreadPoolThrowRunException {



    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(1);

        Future future = pool.submit(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                throw new RuntimeException("throw runTimeExceptions test");
            }
        });
        try {
            future.get();
        } catch (InterruptedException e) {
            System.out.println("interrupt ");
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println("execException");
            e.printStackTrace();
        }

    }
}
