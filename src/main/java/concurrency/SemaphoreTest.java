package concurrency;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);

        new Thread(new IncThread(sem, "A")).start();
        new Thread(new IncThread(sem, "B")).start();
    }
}

//A shared resource.
class Shared {
    static int count = 0;
}

//A thread of execution that increments counts.
class IncThread implements Runnable {
    String name;
    Semaphore sem;

    IncThread(Semaphore sem, String name) {
        this.name = name;
        this.sem = sem;
    }

    @Override
    public void run() {
        System.out.println("Starting " + name);

        try{
            //First, get a permit.
            System.out.println(name + " is waiting for a permit. ");
            sem.acquire();
            System.out.println(name + " gets a permit. ");
            //Now, access shared resources.
            for (int i = 0; i < 5; i++) {
                Shared.count++;
                System.out.println(name + ": " + Shared.count);

                //Now, allow a context switch -- if possible.
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        //Release the permit.
        System.out.println(name + " releases the permit.");
        sem.release();
    }
}