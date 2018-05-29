package lambda;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {

        new Thread(() -> System.out.println("hello lambda world, new thread start")).start();
//      params) -> expression
//      (params) -> statement
//      (params) -> { statements }

        //顺便提一句，通常都会把lambda表达式内部变量的名字起得短一些。这样能使代码更简短，放在同一行。
        // 所以，在上述代码中，变量名选用a、b或者x、y会比even、odd要好。

        addTest(1, 2, (a, b) -> {
            System.out.println("sum:" + (a + b));
            System.out.println("...");
        });

        ((LambdaTest) (a, b) -> {
            System.out.println("s:" + (a + b));
        }).add(1, 2);



        List<String> langs = Lists.newArrayList("Java", "Scala", "C", "Lisp", "JJ");
        List<String>lanNew = Lists.newArrayList().stream().map(x->x+"^^").collect(Collectors.toList());
        System.out.println("lalalla " + lanNew);
//        langs.forEach(System.out::println);
        langs.forEach(Test::printTest);//双冒号 直接传递参数。 尽量将代码搞到一行
        System.out.println(" start with J");
        filter2(langs, str -> str.startsWith("J"));//predicate里只有一个接口方法  test 入参T 返回boolean

        //Predicate多个合并
        Predicate<String> startJ = n -> n.startsWith("J");
        Predicate<String> len4 = n -> n.length() == 4;
        System.out.println("start with j and length=4");
        langs.stream().filter(startJ.and(len4)).forEach(System.out::println);

        //Map Reduce
        //为每个订单加上12%的税
        List<Double> costBeforeTax = Arrays.asList(100d, 200d, 300d, 400d, 500d);
        costBeforeTax.forEach(n->{
            n = n + 0.12*n;
            System.out.print(n + " : ");
        });
        System.out.println("============");
        costBeforeTax.stream().map(n -> (n + n * 0.12)+" : ").forEach(System.out::print);

        System.out.println("sum ");
        double total = costBeforeTax.stream().map(n -> (n + n * 0.12)).reduce((sum, n) -> sum + n).get();
        System.out.println(total);
        System.out.println("min");
        System.out.println(costBeforeTax.stream().min((Double::compareTo)).get());

        //通过过滤创建一个新的string列表
        List<String> filteredList = langs.stream().filter(x -> x.length() > 2).collect(Collectors.toList());
        System.out.println(" length >2: " + filteredList);
        //对列表的每个元素应用函数
        // 将字符串换成大写并用逗号链接起来
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
        List<String> G1 = Arrays.asList();
        List<String> G2 = Arrays.asList("USA", "Japan");

        String gRes = G1.stream().map(String::toUpperCase).collect(Collectors.joining(","));
        System.out.println("G0 " + gRes);

        //复制不同的值，创建一个子列表
        // 用所有不同的数字创建一个正方形列表
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer>distinct = numbers.stream().map(x->x*x).distinct().collect(Collectors.toList());
        System.out.println("distinct" + distinct);
        System.out.println(numbers.stream().min((Comparator.naturalOrder())).orElse(0));
        //计算集合元素的最大值、最小值、总和以及平均值
        //获取数字的个数、最小值、最大值、总和以及平均值
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics statistics = primes.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println("max " + statistics.getMax());
        System.out.println("average " + statistics.getAverage());
    }

    private static void filter(List<String> names, Predicate<String> condition) {
        Preconditions.checkNotNull(names);
        names.forEach(name->{
            if (condition.test(name)) {
                System.out.println(name + " ");
            }
        });
    }
    private static void filter2(List<String> names, Predicate<String> condition) {
        Preconditions.checkNotNull(names);
        names.stream().filter(condition).forEach(name-> System.out.println(name+": "));
    }
    interface LambdaTest{

        void add(int a, int b);
    }

    private static void addTest(int a, int b, LambdaTest fun) {

        fun.add(a, b);
    }

    private static void printTest(String str) {
        System.out.println(">>>>>" + str);
    }

}
