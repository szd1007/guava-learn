package concurrency;

//A simple lock example.

import java.util.concurrent.locks.ReentrantLock;

public class LockDemoTest {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        new Thread(new LockThread(lock, "A")).start();
        new Thread(new LockThread(lock, "B")).start();
    }
}

//A shared resource.
class SharedLock {
    static int count = 0;
}

//A thread of execution that increments count.
class LockThread implements Runnable {

    String name;
    ReentrantLock lock;

    LockThread(ReentrantLock lk, String name) {
        lock = lk;
        this.name = name;
    }
    @Override
    public void run() {
        System.out.println("Starting " + name);
        try {
            //First, lock count.
            System.out.println(name + " is waiting to lock count.");
            lock.lock();
            System.out.println(name + " is locking count.");
            SharedLock.count++;
            System.out.println(name + ": " + SharedLock.count);

            //Now, allow a context switch -- if possible.
            System.out.println(name + " is sleeping");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //Unlock
            System.out.println(name +" is unlocking count.");
            lock.unlock();
        }
    }
}