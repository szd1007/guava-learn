package concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(3, () -> System.out.println("Barrier reached"));
        System.out.println("Starting");

        new Thread(new MyThreadCyclic(cb, "A")).start();
        new Thread(new MyThreadCyclic(cb, "B")).start();
        new Thread(new MyThreadCyclic(cb, "C")).start();

        //reuse the cyclicBarrier
        new Thread(new MyThreadCyclic(cb, "X")).start();
        new Thread(new MyThreadCyclic(cb, "Y")).start();
        new Thread(new MyThreadCyclic(cb, "Z")).start();
    }
}


//A thread of execution that use a CyclicBarrier
class MyThreadCyclic implements Runnable {
    CyclicBarrier cbar;
    String name;

    MyThreadCyclic(CyclicBarrier c, String name) {
        cbar = c;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name);
        try {
            cbar.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}