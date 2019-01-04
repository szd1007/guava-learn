package thecompletereferenc.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * most common uses involve some type of array,collection, or grouping of data
 * 绝大多数的使用方式都会包含 数组、集合或者数据组这些类型
 *
 * 场景限制：
 * 1 不能使用线程同步（synchronized， semaphore等）
 * 2 避免由于io带来的线程阻塞（不适合io多的场景）。专注于计算，不依赖外部阻塞（io） 或者同步
 *
 * @author shangzhidong@zhuanzhuan.com
 * @date 2019-01-02 17:10
 */
public class ForkJoinTest {

    public static void main(String[] args) {
        //Create a task pool.
        ForkJoinPool fjp = new ForkJoinPool();

        double[] nums = new double[100000];
        //Given nums some values.
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (double)i;
        }
        System.out.println("A portion of the original sequence:");

        for (int i = 0; i < 10; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("\n");

        SqrtTransform task = new SqrtTransform(nums, 0, nums.length);

        //Start the main ForkJoinTask.
        fjp.invoke(task);

        System.out.println("A portion fo the transformed sequence" + " (to four decimal places):");
        for (int i = 0; i < 10; i++) {
            System.out.format("%.4f ", nums[i]);
        }
        System.out.println();
    }
}

//A ForkJoinTask(via RecursiveAction) that transforms
//the elements in an array of doubles into their square roots.
class SqrtTransform extends RecursiveAction {

    //The threshold value is arbitrarily set at 1,000 in this example.
    //In real-world code, its optimal value can be determined by
    //profiling and experimentation.
    final int seqThreshold = 1000;

    //Array to be accessed.
    double[] data;

    //Determine what part of data to process.
    int start, end;

    SqrtTransform(double[] vals, int s, int e) {
        data = vals;
        start = s;
        end = e;
    }

    //This is the method in which parallel computation will occur.
    @Override
    protected void compute() {
        //If number of elements is below the sequential threshold,
        //then process sequentially.
        if ((end - start) < seqThreshold) {
            //Transform each element into its square root.
            for (int i = start; i < end; i++) {
                data[i] = Math.sqrt(data[i]);
            }
        } else {
          //otherwise, continue to break the data into smaller pieces.

          // Find the midpoint.
            int middle = (start + end) / 2;
            //Invoke new tasks, using the subdivided data.
            invokeAll(new SqrtTransform(data, start, middle), new SqrtTransform(data, middle, end));
        }
    }
}
