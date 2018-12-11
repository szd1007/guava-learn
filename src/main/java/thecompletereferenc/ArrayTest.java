package thecompletereferenc;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author shangzhidong@zhuanzhuan.com
 * @date 2018-12-11 09:42
 */
public class ArrayTest {

    private static int[] ia = new int[] { 3, 2, 5, 2, 22 };

    @Test
    //并发排序
    public void testParallelSort() {
        Arrays.parallelSort(ia);

        Arrays.stream(ia).forEach(System.out::println);
        System.out.println("xxxxx");
        //并发根据当前和前面元素值修改当前元素
        Arrays.parallelPrefix(ia, ArrayTest::add);
        Arrays.stream(ia).forEach(System.out::println);

        //这个叼
        System.out.println(Arrays.toString(ia));

        System.out.println(Arrays.hashCode(ia));

        //对象数组中包含arrays
//        System.out.println(Arrays.deepToString(ia));
//        System.out.println(Arrays.deepHashCode(ia));

        Arrays.fill(ia, 0, 2, -3);
        System.out.println(Arrays.toString(ia));
    }

    static int add(int x, int y) {
        return x + y;
    }
}
