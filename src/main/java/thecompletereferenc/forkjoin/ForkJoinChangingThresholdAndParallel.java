package thecompletereferenc.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * A simple program that lets you experiment with the effects of
 * changing the threshold and parallelism of a ForkJoinTask.
 *
 * @author szd1007@github.com
 * @date 2019-01-03 13:21
 */
public class ForkJoinChangingThresholdAndParallel {

    public static void main(String[] args) {
        int pLevel;
        int threshold;
        System.out.println("availableProcessors: " + Runtime.getRuntime().availableProcessors());

        pLevel=1;
        threshold = 500;

        //These variables are used to time the task.
        long beginT, endT;

        //Create a task pool. Notice that the parallelism level is set.
        ForkJoinPool fjp = new ForkJoinPool(pLevel);
        double[] nums = new double[100000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (double)i;
        }
        TransformTP task = new TransformTP(nums, 0, nums.length, threshold);
        //Start timing.
        beginT = System.nanoTime();

        //Start the main ForkJoinTask.
        fjp.invoke(task);

        //End timing.
        endT = System.nanoTime();

        System.out.println("Level of parallelism: " + pLevel);
        System.out.println("Sequential threshold: " + threshold);
        System.out.println("Elapsed time: " + (endT - beginT) + " ns");
        System.out.println();

        /*
          打印forkJoinPool状态
         */
//        fjp.execute(task);
//        while (!task.isDone()) {
//            System.out.println(fjp);
//        }
    }
}

//A ForkJoinTask(via RecursiveAction) that perform a
//transform on the elements of an array of doubles.
class TransformTP extends RecursiveAction {

    //Sequential threshold, which is set by the constructor.
    int seqThreshold;

    //Array to be accessed
    double [] data;

    //Determine what part of data to process.
    int start, end;

    TransformTP(double[] vals, int s, int e, int t) {
        data = vals;
        start = s;
        end = e;
        seqThreshold = t;
    }

    //This is the method in which parallel computation will occur.

    @Override
    protected void compute() {
        //If number of elements is below the sequential threshold,
        //then process sequentially.
        if ((end - start) < seqThreshold) {
            //The following code assigns an elements at an even index the
            //square root of its original value. An element at an odd
            //index is assigned its cube root. This code is designed
            //to simply consume CPU time so that the effects of concurrent
            //execution are more readily observable.
            for (int i = start; i <end; i++) {
                if ((data[i] % 2) == 0) {
                    data[i] = Math.sqrt(data[i]);
                } else {
                    data[i] = Math.cbrt(data[i]);
                }
            }
        }else {
            //Otherwise, continue to break the data into smaller pieces.
            //Find the midpoint.
            int middle = (start + end) / 2;

        }
    }
}

