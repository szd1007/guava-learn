package thecompletereferenc;

import org.junit.Test;

/**
 * @author shangzhidong@zhuanzhuan.com
 * @date 2018-11-22 21:04
 */
public class RunTimeTest {

    public static void main(String[] args) throws InterruptedException {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("this is a hook fun execute before exit/terminate")));

        Thread.sleep(2000);

        System.out.println("system exit");
        Runtime.getRuntime().removeShutdownHook(null);
    }

    @Test
    public void memoryDemo() {
        Runtime r = Runtime.getRuntime();
        long mem1, mem2;
        Integer someints[] = new Integer[1000];
//        int someints[] = new int[1000];
        System.out.println("Total memory is: " + r.totalMemory());

        mem1 = r.freeMemory();

        System.out.println("Initial free memory: " + mem1);

        r.gc();
        mem1 = r.freeMemory();
        System.out.println("Free memory after garbage collection: " + mem1);

        for (int i = 0; i < 1000; i++) {
            someints[i] = Integer.valueOf(i);// allocate integers
//            someints[i] = i;// allocate integers
        }
        mem2 = r.freeMemory();
        System.out.println("Free memory after allocation: " + mem2);
        System.out.println("Memory used by allocation: " + (mem1 - mem2));

        //discard integers
        for (int i = 0; i < 1000; i++) {
            someints[i] = null;
        }
        r.gc();//request garbage collection

        mem2 = r.freeMemory();
        System.out.println("Free memory after collecting" + "discard Integers: " + mem2);

    }
}
