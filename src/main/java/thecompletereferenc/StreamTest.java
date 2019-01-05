package thecompletereferenc;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author shangzhidong@zhuanzhuan.com
 * @date 2019-01-04 13:25
 */
public class StreamTest {

    public static void main(String[] args) {
        int a[] = { 1, 3, 2 };
        //IntStream DoubleStream LongStream 都是适用于基本数据类型
        System.out.println(IntStream.of(a).sum());

        //也是基本类型
//        OptionalInt.of();

    }

    @Test
    public void testBasic() {
        ArrayList<Integer> myList = Lists.newArrayList(7, 18, 10, 24, 17, 5);
        System.out.println("Original list: " + myList);

        //Obtain a Stream to the array list.
        Stream<Integer> myStream = myList.stream();

        //Obtain the minimum value by use of min().
        //max(), isPresent(), and get().
        Optional<Integer> minVal = myStream.min(Integer::compare);

        minVal.ifPresent(integer -> System.out.println("Minimum value: " + integer));

        //Must obtain a new stream because previous call to min()
        //is a terminal operation that consumed the stream.
        myStream = myList.stream();
        Optional<Integer> maxVal = myStream.max(Integer::compare);
        maxVal.ifPresent(x -> System.out.println("Maximum value: " + maxVal.get()));

        //Sort the stream by use of sorted().
        Stream<Integer> sortedStream = myList.stream().sorted();

        //Display the sorted stream by use of forEach().
        System.out.println("Sorted stream: ");
        sortedStream.forEach(x -> System.out.print(x + " "));
        System.out.println();

        //Display only the odd values by use of filter().
        Stream<Integer> oddVals = myList.stream().sorted().filter(x -> x % 2 == 1);
        System.out.println("Odd values: ");
        oddVals.forEach(x -> System.out.print(x + " "));
        System.out.println();

        //Display only the odd values that are greater than 5. Notice that
        //two filter operations are pipelined.

        oddVals = myList.stream().filter(x -> x % 2 == 1).filter(x -> x > 5);
        System.out.println("Odd values greater than 5: ");
        oddVals.forEach(x -> System.out.print(x + " "));
        System.out.println();

    }

    @Test
    public void testReduce() {
        ArrayList<Integer> myList = Lists.newArrayList(7, 18, 10, 24, 17, 5);

        //Two ways to obtain the integer product of the elements
        //in myList by use of reduce(). 函数中两个值第一个代表结果，第二个代表下一个元素
        Optional<Integer> productObj = myList.stream().reduce((r, n) -> r * n);
        productObj.ifPresent(x -> System.out.println("results: " + x));

        int p = myList.stream().reduce(1, (a, b) -> a * b);
        System.out.println("res: " + p);
    }
}
