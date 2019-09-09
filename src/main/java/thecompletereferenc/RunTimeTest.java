package thecompletereferenc;

import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author szd1007@github.com
 * @date 2018-11-22 21:04
 */
public class RunTimeTest {

    public static void main(String[] args) throws InterruptedException, IOException {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("this is a hook fun execute before exit/terminate")));

        Thread.sleep(2000);

        System.out.println("system exit");
        //        Runtime.getRuntime().removeShutdownHook(null);

        Process p = Runtime.getRuntime().exec("gvim");
        int subExitCode = p.waitFor();
        System.out.println("subProcess exit:" + subExitCode);

        //非阻塞方法
        p.exitValue();

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

    @Test
    public void processBuilderTest() throws InterruptedException, IOException {
        ProcessBuilder proc = new ProcessBuilder("gvim", "test.txt");
        ProcessBuilder.Redirect redirect = proc.redirectInput();
        Process process = proc.start();

        process.getOutputStream().write(33);
        TimeUnit.SECONDS.sleep(3);
        process.getOutputStream().write(33);
        //        Files.append("test input", redirect.file(), Charsets.UTF_8);
        System.nanoTime();
    }

    @Test
    public void environmentGetTest() {
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("java.home"));
        System.out.println(System.getProperty("java.library.path"));
        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("file.separator"));
        System.out.println(System.getProperty("os.name"));
    }
}
