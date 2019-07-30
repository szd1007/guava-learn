package concurrency;


import refactoring.RfUsingEventListeners;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 对象的组合
 */
public class chp4_ObjComposite {

    public static void main(String[] args) throws InterruptedException {
        Executor executor  = Executors.newFixedThreadPool(1);
        System.out.println("正常执行任务");
        for (int i = 0; i < 3; i++) {
            executor.execute(()->{
                System.out.println(Thread.currentThread().getName());
            });
        }
        TimeUnit.SECONDS.sleep(2);
        System.out.println("线程发生未捕获异常，当前线程结束");
        for (int i = 0; i < 3; i++) {
            executor.execute(()->{
                System.out.println(Thread.currentThread().getName());
                int a = 1/0;
            });
        }
        TimeUnit.SECONDS.sleep(2);
        System.out.println("捕获异常,并抛出。线程同样结束");
        for (int i = 0; i < 3; i++) {
            executor.execute(()->{
                System.out.println(Thread.currentThread().getName());
                try {
                    int a = 1/0;
                } catch (Exception e) {
                    throw new RuntimeException("catch exception");
                }
            });
        }

    }
    @ConcurrentLanguagePoints("java监视器模式")
    private static class PrivateLock{
        private final Object myLock = new Object();

        void doSomeThing(){
            synchronized (myLock){
                //do fun
            }
        }

    }

    void test(){
        ConcurrentLinkedQueue<Long> quues = new ConcurrentLinkedQueue<>();

    }
    void testInterrupt(){
        Thread.currentThread().interrupt();
        Thread.setDefaultUncaughtExceptionHandler(null);
    }
}

