package thecompletereferenc;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
            System.out.println("exception error found:" + e.getMessage());
        });

        Thread t = new Thread(() -> {
            int a = 2 / 0;
        });

        t.start();
        TimeUnit.SECONDS.sleep(2);
    }

    @Test
    public void testThreadGroup() {
        //demonstrate thread groups.
        ThreadGroup groupA = new ThreadGroup("Group A");
        ThreadGroup groupB = new ThreadGroup("Group B");

        NewThreadTest ob1 = new NewThreadTest("One", groupA);
        NewThreadTest ob2 = new NewThreadTest("Two", groupA);
        NewThreadTest ob3 = new NewThreadTest("Three", groupB);
        NewThreadTest ob4 = new NewThreadTest("Four", groupB);

        ob1.start();ob2.start();ob3.start();ob4.start();

        System.out.println("\nHere is output from list():");
        groupA.list();
        groupB.list();
        System.out.println();

        System.out.println("Suspending Group A");
        Thread tga[] = new Thread[groupA.activeCount()];
        groupA.enumerate(tga);// get threads in group
        for (int i = 0; i < tga.length; i++) {
            ((NewThreadTest)tga[i]).mysuspend(); //suspend each thread
        }

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        System.out.println("Resuming Group A");
        for (int i = 0; i < tga.length; i++) {
            ((NewThreadTest)tga[i]).myresume();//resume thread in group
        }

        //wait for threads to finish
        try {
            System.out.println("Waiting for threads to finish.");
            ob1.join();
            ob2.join();
            ob3.join();
            ob4.join();
        } catch (Exception e) {
            System.out.println("Exception in Main thread");
        }

        System.out.println("Main thread exiting.");
    }
}

class NewThreadTest extends Thread {
    boolean suspendFlag;

    NewThreadTest(String threadName, ThreadGroup tgOb) {
        super(tgOb, threadName);
        System.out.println("New thread: " + this);
        suspendFlag = false;
    }

    //This is the entry point for thread.
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(getName() + ": " + i);
                Thread.sleep(1000);
                synchronized (this) {
                    while (suspendFlag) {
                        wait();
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("ExceptionTest in " + getName());
        }

        System.out.println(getName() + " existing.");
    }
    synchronized void mysuspend() {
        suspendFlag = true;
    }
    synchronized  void myresume() {
        suspendFlag = false;
        notify();
    }
}
