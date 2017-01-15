package concurrency;


import com.google.common.util.concurrent.*;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

/**
 * Created by shangzhidong on 2017/1/13.
 * https://github.com/google/guava/wiki/ListenableFutureExplained
 */
public class ListenableFutureExplainedTest {
/**
    static ListeningExecutorService service = MoreExecutors.listeningDecorator(
            Executors.newFixedThreadPool(2));

    static ListenableFuture<Explosion>  explosionListenableFuture = service.submit(new Callable<Explosion>() {
        @Override
        public Explosion call() throws Exception {

            //push button
            return null;
        }
    });

    public static void main(String[] args) {
        Futures.addCallback(explosionListenableFuture, new FutureCallback<Explosion>() {
            @Override
            public void onSuccess(Explosion result) {
                System.out.println("push button success");
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("push button error");
            }
        });
    }

*/
    static class Explosion {

    }
}
