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

        System.out.println("sum: " + myList.stream().reduce((a, b) -> a + b));

        Optional<Integer> evenSum = myList.stream().reduce((a, b) -> {
            if (b % 2 == 0) {
                return a + b;
            }
            return a;
        });
        evenSum.ifPresent(x -> System.out.println("evenSum: " + evenSum.get()));
    }

    @Test
    public void testStreamParallel() {
        List<Double> list = Lists.newArrayList(7.0, 18.0, 10.0, 24.0, 17.0, 5.0);

        //效果是每个元素开根号 然后相乘。 此处要定义并发执行的各个部分结果组合方式为相乘。（两者不一样)
        double productOfSqrRoots = list.parallelStream().reduce(
                1.0,
                (a,b)->a*Math.sqrt(b),
                (a,b)->a*b
        );
        System.out.println("Product of square roots: " + productOfSqrRoots);

    }

    @Test
    public void testMap() {
        List<Double> list = Lists.newArrayList(7.0, 18.0, 10.0, 24.0, 17.0, 5.0);
        //Map the square root of the elements in myList to a new stream.
        Stream<Double> sqrtRootStrm = list.stream().map(Math::sqrt);

        //Find the product of the square roots.
        double r = sqrtRootStrm.reduce(1.0, (a, b) -> a * b);

        System.out.println("r" + r);
    }

    @Test
    public void testMapConvert() {
        List<NamePhoneEmail> myList = new ArrayList<>();
        myList.add(new NamePhoneEmail("Larry", "555-5555", "Larry@HerbSchildt.com"));
        myList.add(new NamePhoneEmail("James", "555-4444", "James@HerbSchildt.com"));
        myList.add(new NamePhoneEmail("Marry", "555-3333", "Marry@HerbSchildt.com"));

        myList.stream().forEach((a)-> System.out.println(a.name + " " + a.phone + " " + a.email));

        //Map just the names and phone numbers to a new stream.
        Stream<NamePhone> namePhoneStream = myList.stream().map((a) -> new NamePhone(a.name, a.phone));
        System.out.println("List of names and phone numbers: ");
        namePhoneStream.forEach((a)->{
            System.out.println(a.name+" " +a.phonenum);
        });


        System.out.println("filter Msg ++++");

        //Filter msg
        myList.stream().filter(x -> x.name.equals("James")).map(y -> new NamePhone(y.name, y.phone)).forEach((a)->{
            System.out.println(a.name+" " +a.phonenum);
        });
    }

    @Test
    public void testMapToIntPrimitive() {
        List<Double> list = Lists.newArrayList(1.1, 3.6, 9.2, 4.7, 12.1, 5.0);
        System.out.println("Original values in myList: ");
        list.forEach(x -> System.out.print(x + " "));
        System.out.println();

        //Map the ceiling of the elements im list to an IntStream.
        IntStream cStrm = list.stream().mapToInt((a) -> (int) Math.ceil(a));

        System.out.println("The ceilings of the values in list: ");
        cStrm.forEach((a) -> System.out.print(a + " "));
    }
}




class NamePhoneEmail{
    String name;
    String phone;
    String email;

    NamePhoneEmail(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
}

class NamePhone {
    String name;
    String phonenum;

    NamePhone(String name, String phonenum) {
        this.name = name;
        this.phonenum = phonenum;
    }
}

