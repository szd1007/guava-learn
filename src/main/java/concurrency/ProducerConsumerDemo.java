package concurrency;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerDemo {
    private static final Lock lock  = new ReentrantLock(true);
    private static final Condition full = lock.newCondition();
    private static final Condition empty = lock.newCondition();

    public static void main(String[] args) {
        LinkedList<Integer>queue = new LinkedList<>();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 3; i++) {
            executor.submit(new Producer(queue, 8));
        }
        for (int i = 0; i < 2; i++) {
            executor.submit(new Consumer(queue));
        }
    }

    static class Producer  implements Runnable{
        private LinkedList<Integer> queue;
        private int maxLen;
        public Producer(LinkedList<Integer> queue, int maxLen) {
            this.queue = queue;
            this.maxLen = maxLen;
        }

        @Override
        public void run() {
            while (true){
                try {
                    lock.lockInterruptibly();
                    while (queue.size() == maxLen) {
                        full.await();
                    }
                    TimeUnit.SECONDS.sleep(1);
                    queue.add(new Random().nextInt(100));
                    System.out.println(Thread.currentThread().getName()+ " produce "+ queue.getLast());
                    empty.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }
    }

    static class Consumer  implements Runnable{
        private LinkedList<Integer> queue;
         public Consumer(LinkedList<Integer> queue ) {
            this.queue = queue;
         }

        @Override
        public void run() {
            while (true){
                try {
                    lock.lockInterruptibly();
                    while (queue.size() == 0) {
                        empty.await();
                    }

                    System.out.println(Thread.currentThread().getName()+ " consume "+ queue.removeFirst());
                    full.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }
    }
}
