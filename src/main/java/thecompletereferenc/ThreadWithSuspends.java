package thecompletereferenc;

/**
 * @author szd1007@github.com
 * @date 2018-10-30 13:17
 */

class NewThreadWithSuspend implements Runnable{

    String name;    // name of thread
    Thread t;
    boolean suspendFlag;

    NewThreadWithSuspend(String name) {
        this.name = name;
        t = new Thread(this, name);
        System.out.println("New thread: " + t);
        suspendFlag = false;
    }

    //this is the entry point for thread.
    @Override
    public void run() {
        try {
            for (int i = 0; i < 15; i++) {
                System.out.println(name + ":　" + i);
                Thread.sleep(200);
                synchronized (this) {
                    while (suspendFlag) {
                        //当前正在执行代码块的线程进行wait，wait对象是 this NewThreadWithSuspend
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println(name + " interrupted");
        }
        System.out.println(name + " exiting.");

    }

    synchronized void mysuspend(){
        suspendFlag = true;
    }

    synchronized void myresume(){
        suspendFlag = false;
        notify();
    }
}


public class ThreadWithSuspends {

    public static void main(String[] args) {
        NewThreadWithSuspend ob1 = new NewThreadWithSuspend("one");
        NewThreadWithSuspend ob2 = new NewThreadWithSuspend("two");

        ob1.t.start();
        ob2.t.start();

        try {
            Thread.sleep(1000);
            ob1.mysuspend();
            System.out.println("Suspending thread One");
            Thread.sleep(1000);
            ob1.myresume();
            System.out.println("Resuming thread One");
            ob2.mysuspend();
            System.out.println("Suspending thread Two");
            Thread.sleep(1000);
            ob2.myresume();
        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }

        //wait for threads to finish
        try {
            System.out.println("waiting for threads to finish");
            ob1.t.join();
            ob2.t.join();
        } catch (InterruptedException e) {
            System.out.println("Main Thread Interrupted");
        }
        System.out.println("Main thread exiting");
    }
}
