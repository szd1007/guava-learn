package concurrency;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author szd1007@github.com
 * @date 2019-05-31 15:49
 */
public class LockDemo {

    private static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Thread.sleep(10);
            Thread t = new Thread(() -> {
                lock.lock();
                try {
                    Thread.sleep(1000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

            });
            t.start();
        }
        System.out.println("init done");
    }
}
