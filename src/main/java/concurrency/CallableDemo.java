package concurrency;

import java.util.concurrent.*;

public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);

        Future<String> stringFuture = service.submit(() -> "A");
        Future<Integer> integerFuture = service.submit(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 10;
        });


        String a = stringFuture.get();
        Integer b = integerFuture.get();

        System.out.println("get result:" + a + b);
        //不shutdown 会导致线程一直运行。主进程不会停掉
        service.shutdown();

    }
}
