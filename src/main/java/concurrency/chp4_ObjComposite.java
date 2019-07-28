package concurrency;


import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 对象的组合
 */
public class chp4_ObjComposite {

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

