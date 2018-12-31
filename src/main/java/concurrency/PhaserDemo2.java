package concurrency;

import java.util.concurrent.Phaser;

public class PhaserDemo2 {
    public static void main(String[] args) {
        MyPhaser myPhaser = new MyPhaser(1, 4);
        System.out.println("Starting\n");
        new Thread(new MyThreadPhaseDemo2(myPhaser, "A")).start();
        new Thread(new MyThreadPhaseDemo2(myPhaser, "B")).start();
        new Thread(new MyThreadPhaseDemo2(myPhaser, "C")).start();

        //Wait for the specified number of phases to complete.
        while (!myPhaser.isTerminated()) {
            myPhaser.arriveAndAwaitAdvance();
        }
        System.out.println("The Phaser is terminated");
    }
}

class MyPhaser extends Phaser {
    int numPhases;

    MyPhaser(int parties, int phaseCount) {
        super(parties);
        numPhases = phaseCount - 1;
    }

    //Override onAdvance() to execute the specified number of phases.
    protected boolean onAdvance(int p, int regParties) {
        //This println() statement is for illustration only.
        //Normally, onAdvance() will not display output.
        System.out.println("Phase " + p + " completed.\n");

        //If all phases have completed, return true
        if (p == numPhases || regParties == 0) {
            return true;
        }
        //Otherwise, return false.
        return false;
    }
}

//A thread of execution that uses a Phaser.
class MyThreadPhaseDemo2 implements Runnable {

    Phaser phaser;
    String name;

    MyThreadPhaseDemo2(Phaser p, String name) {
        phaser = p;
        this.name = name;
        p.register();
    }
    @Override
    public void run() {
        while (!phaser.isTerminated()) {
            System.out.println("Thread " + name + " Beginning Phase " + phaser.getPhase());
            phaser.arriveAndAwaitAdvance();
            //Pause a bit to prevent jumbled output. This is for illustration
            //only, It is not required for the proper operation of the phaser.
            try {
                Thread.sleep(100);

            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}