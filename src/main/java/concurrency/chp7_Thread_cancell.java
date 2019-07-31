package concurrency;

import java.io.IOException;
import java.math.BigInteger;
import java.net.Socket;
import java.util.Objects;
import java.util.concurrent.*;

/**
 * 第七章  取消与关闭
 *
 */
public class chp7_Thread_cancell {

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

}
@ConcurrentLanguagePoints("调用interrupt 并不会真正中断一个正运行非阻塞任务的线程，只是设置中断标志位，让程序在合适的时候中断自己")
@ConcurrentLanguagePoints("阻塞方法 会在通过检查中断状态提前返回， 【可能清除中断状态】并且抛出异常")
@ConcurrentLanguagePoints("非阻塞方法， 要自己处理检查中断状态")
class PrimeProduce extends Thread{
    private final BlockingQueue<BigInteger> queue;

    PrimeProduce(BlockingQueue<BigInteger> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            BigInteger p = BigInteger.ONE;
            while (!Thread.currentThread().isInterrupted()){
                queue.put(p = p.nextProbablePrime());
            }
        }catch (InterruptedException e){
            /**
             * 允许退出
             */
        }
    }

    public void  cancel(){interrupt();}
}


interface CancellableTask<T> extends Callable<T>{
    void cancel();
    default RunnableFuture<T> newTask(){
        return new FutureTask<T>(this) {
            @Override
            public boolean cancel(boolean mayInterruptIfRunning) {
                try {
                    CancellableTask.this.cancel();
                }finally {
                    return super.cancel(mayInterruptIfRunning);
                }
            }
        };
    }
}
class CancellingExecutor extends ThreadPoolExecutor {

    public CancellingExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        if(callable instanceof  CancellableTask)
            return ((CancellableTask<T>)callable).newTask();
        else
            return super.newTaskFor(callable);
    }
}

abstract class SocketUsingTask<T> implements CancellableTask<T>{

    private Socket socket;
    protected synchronized void setSocket(Socket socket){
        this.socket =  socket;
    }
    @Override
    @ConcurrentLanguagePoints("每个业务实现自己的cancel逻辑")
    public void cancel() {
        try {
            if(Objects.nonNull(socket)){
                socket.close();;
            }
        } catch (IOException e) {
            //忽略
        }
    }

}