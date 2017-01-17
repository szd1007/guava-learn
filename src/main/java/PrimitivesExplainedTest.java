import com.google.common.primitives.Doubles;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import com.google.common.primitives.UnsignedInts;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by zm on 17/1/16.
 *https://github.com/google/guava/wiki/PrimitivesExplained
 */
public class PrimitivesExplainedTest {
    public static void main(String[] args) {
        System.out.println(Ints.max(1, 2, 4));
        Collections.max(Arrays.asList(1,2,3));

        Ints.compare(1, 3);
        Doubles.compare(1,3);
        Longs.compare(1,3);

        byte[] longbyte = Longs.toByteArray(2);
        System.out.println(UnsignedInts.toString(7,3));
    }
}
