package concurrency;


import java.util.concurrent.Phaser;

public class PhaserDemo {


    public static void main(String[] args) {
        //2 parties
//        Phaser phaser = new Phaser(4);
        Phaser phaser = new Phaser(1);
        int curPhase;
        System.out.println("Starting");
        new Thread(new MyThreadPhaser(phaser, "A")).start();
        new Thread(new MyThreadPhaser(phaser, "B")).start();
        new Thread(new MyThreadPhaser(phaser, "C")).start();

        //Wait for all threads to complete phase one.
        curPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + curPhase + "complete");
        //Wait for all threads to complete phase two.
        curPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + curPhase + "complete");

        curPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + curPhase + "complete");


        //Deregister the main thread.
        phaser.arriveAndDeregister();

        if (phaser.isTerminated()) {
            System.out.println("The Phaser is terminated");
        }
    }

}

//A thread of execution that use a Phaser.
class MyThreadPhaser implements Runnable {
    Phaser phaser;
    String name;

    public MyThreadPhaser(Phaser p, String name) {
        phaser = p;
        this.name = name;
        p.register();
    }

    @Override
    public void run() {
        System.out.println("Thread " + name + " Beginning Phase One");
        phaser.arriveAndAwaitAdvance();//Signal
//        phaser.arrive();

        //Pause a bit to prevent jumbled output. This is for illustration
        //Only. It is not required for the proper operation of the phaser.

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Thread " + name + " Beginning Phase Two");
        phaser.arriveAndAwaitAdvance();//Signal arrival

        //Pause a bit to prevent jumbled output. This is for illustration
        //Only. It is not required for the proper operation of the phaser.
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Thread " + name + " Beginning Phase Three");
        phaser.arriveAndDeregister(); //Signal arrival and deregister.
    }
}