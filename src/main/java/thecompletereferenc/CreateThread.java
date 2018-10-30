package thecompletereferenc;


public class CreateThread {
    public static void main(String[] args) {
        NewThread newThread = new NewThread();

        NewThread t2 = new NewThread();
        t2.t.start();
        newThread.t.start();

        try{
            //等待线程执行完
            newThread.t.join();
            t2.t.join();

            System.out.println("t is alive:"+newThread.t.isAlive());

            for (int i = 5; i > 0; i--) {
                System.out.println("Main Thread: " + i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println("Main thread interrupted ");
        }
        System.out.println("Main Thread exiting");
    }
}
class NewThread implements Runnable{
    Thread t ;

    public NewThread(){
        // Create a new , second thread
        t = new Thread(this, "Demo Thread");
        System.out.println("Child thread: " + t);
    }

    //This is the entry point for the second thread.
    @Override
    public void run() {
        try {
            for (int i = 5; i > 0 ; i--) {
                System.out.println("Child Thread: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Child interrupted. ");
        }
        System.out.println("Exiting child thread. ");
    }
}

class NewtThread2 extends Thread {
    NewtThread2() {
        //Create a new , second thread
        super("Demo Thread");
        System.out.println("Child thread: " + this);
    }

    //This is the entry point for the second thread.
    @Override
    public void run(){}
}

