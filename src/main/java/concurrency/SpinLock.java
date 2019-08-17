package concurrency;

import java.util.concurrent.atomic.AtomicReference;

public class SpinLock {
    private AtomicReference<Thread> sign = new AtomicReference<>();

    public void lock() {
        while (!sign.compareAndSet(null, Thread.currentThread())) {
        }
    }

    public void unLock(){
        sign.compareAndSet(Thread.currentThread(), null);
    }



}
