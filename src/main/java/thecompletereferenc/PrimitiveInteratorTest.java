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



        if (primitiveIterator.hasNext()) {
            int p = primitiveIterator.next();
            System.out.println(p);
            //不能删除对象， 但是也没有报错??????
            if (p == 2) {
                primitiveIterator.remove();
            }
        }
        System.out.println("after modified");
        System.out.println("len" + a.length);
        for (int i = 0; i < 3; i++) {
            System.out.println(a[i]);
        }

    }
}
