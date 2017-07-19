package util;

import book.concurrencyInPractice.ThreadPoolThrowRunException;

import java.util.concurrent.*;

/**
 * Created by shangzhidong on 2017/7/12.
 */
public class Test {
    static int add(int a, int b) {
        System.out.println(a+b);
        return a+b;
    }
    static ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {
//        int a=3;
//        System.out.println("res"+add(a=4,1));
//        System.out.println("a "+a);


       final Future<Object>future = executorService.submit(new Callable<Object>() {
            public Object call() throws Exception {
                Thread.sleep(3000);
                return null;
            }
        });
        for(int i=0;i<10;i++){
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    try {
                        System.out.println("thread " + "start get");
                        future.get(2000, TimeUnit.MILLISECONDS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }
    }
}
