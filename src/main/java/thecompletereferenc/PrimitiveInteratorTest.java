package thecompletereferenc;

import java.util.Arrays;
import java.util.PrimitiveIterator;
import java.util.stream.IntStream;

/**
 * @author shangzhidong@zhuanzhuan.com
 * @date 2018-12-03 13:22
 */
public class PrimitiveInteratorTest {

    public static void main(String[] args) {
        int a[] = { 1, 4, 2 };
        //原始类型枚举，去除无用的boxing  unboxing
        PrimitiveIterator.OfInt primitiveIterator = Arrays.stream(a).iterator();

        PrimitiveIterator.OfInt pp = IntStream.of(a).iterator();


        if (primitiveIterator.hasNext()) {
            System.out.println(primitiveIterator.next());

        }
    }
}
