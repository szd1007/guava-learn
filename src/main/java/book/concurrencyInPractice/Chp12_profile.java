package book.concurrencyInPractice;

import org.junit.Test;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Chp12_profile {

    @Test
    public void  testConcurrentLinkedQueue(){
        ConcurrentLinkedQueue<String> queue  = new ConcurrentLinkedQueue<>();
        if (queue.isEmpty()) {
            queue.poll();
        }
    }
}
