package concurrency;

import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

public class LongAdderTest {

    public static void main(String[] args) {
        LongAdder longAdder = new LongAdder();
        longAdder.increment();
        System.out.println(longAdder);
        longAdder.add(4);
        System.out.println(longAdder);


//        LongAccumulator accumulator = new LongAccumulator();

    }
}
