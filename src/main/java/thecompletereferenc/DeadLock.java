package thecompletereferenc;

/**
 * an example of deadlock
 *
 * @author shangzhidong@zhuanzhuan.com
 * @date 2018-10-30 09:49
 */
public class DeadLock implements Runnable{
    DeA deA = new DeA();
    Deb deb = new Deb();
    Thread t;

    DeadLock() {
        Thread.currentThread().setName("Main thread");
        t = new Thread(this, "RacingThread");
    }

    void deadlockStart(){
        t.start();
        //get lock on DeA in this thread(Main thread).
        deA.foo(deb);
        System.out.println("Back in the main thread");
    }

    @Override
    public void run() {
        //get lock on Deb in other thread(Racing Thread)
        deb.foo(deA);
        System.out.println("Back in racing thread");
    }

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        deadLock.deadlockStart();
    }
}

class DeA {

    synchronized void foo(Deb b) {
        String name = Thread.currentThread().getName();

        System.out.println(name + " entered A.foo");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("A interrupted");
        }
        System.out.println(name + " trying to call B.last");
        b.last();
    }

    synchronized void last() {
        System.out.println("Inside A.last()");
    }
}

class Deb {

    synchronized void foo(DeA a) {
        String name = Thread.currentThread().getName();

        System.out.println(name + " entered B.foo");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("B interrupted");
        }
        System.out.println(name + "trying to call A.last");
        a.last();
    }

    synchronized void last() {
        System.out.println("Inside B.last()");
    }

}
