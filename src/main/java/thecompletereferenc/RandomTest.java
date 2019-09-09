package thecompletereferenc;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

/**
 * @author szd1007@github.com
 * @date 2018-12-14 09:35
 */
public class RandomTest {

    public static void main(String[] args) {
        Random r = new Random();
        double val;
        double sum = 0;
        int bell[] = new int[10];

        for (int i = 0; i < 100; i++) {
            val = r.nextGaussian();
            sum += val;
            double t = -2;

            for (int j = 0; j < 10; j++, t += 0.5) {
                if (val < t) {
                    bell[j]++;
                    break;
                }
            }
        }
        System.out.println("Average of values: " + (sum / 100));

        //display bell curve, sideways
        for (int i = 0; i < 10; i++) {
            for (int j = bell[i]; j > 0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    @Test
    public void testRandomStream() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        IntStream intStream = random.ints();
        intStream = intStream.limit(10);
        System.out.println("count " + intStream.count());

//        intStream.forEach(x->{
//            System.out.println(x);
//            if (x % 10 > 5) {
//            }
//
//        });
    }

}
