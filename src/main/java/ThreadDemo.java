import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadDemo implements Runnable {
        private static AtomicInteger currentCount = new AtomicInteger(0);

        private static final Integer MAX_COUNT = 30;

        private static String [] chars = {"a", "b", "c"};

        private String name;

        public ThreadDemo(String name) {
            this.name =  name;
        }

        @Override
        public void run() {
            while(currentCount.get()<MAX_COUNT){
                if(this.name.equals(chars[currentCount.get()%3])){
                    printAndPlusOne(this.name + "\t" + currentCount);
                }
            }
        }

        public void printAndPlusOne(String content){
            System.out.println(content);
            currentCount.getAndIncrement();
        }

        public static void main(String [] args){
//            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 20, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());
            Executor threadPoolExecutor = Executors.newFixedThreadPool(3);
            threadPoolExecutor.execute(new ThreadDemo("a"));
            threadPoolExecutor.execute(new ThreadDemo("b"));
            threadPoolExecutor.execute(new ThreadDemo("c"));
        }

}
