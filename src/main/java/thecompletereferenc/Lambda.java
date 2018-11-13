package thecompletereferenc;

public class Lambda {
    public static void main(String[] args) {
//        () -> 122.3;
//        () -> Math.random() * 100;
//        (n) -> (n % 2) == 0;
        //functional interface 的一个接口实现；一句话搞定一个类
        //赋值的时候，会创建类实例对象
        MyNumber myNumber = () -> 122.3;

        System.out.println(myNumber.getValue());

        myNumber = () -> Math.random() * 100;

        System.out.println(myNumber.getValue());

        //error
//        myNumber = () -> "122";

    }
}

@FunctionalInterface
 interface MyNumber {
    double getValue();
}
@FunctionalInterface
interface NumericTest {
    boolean test(int n);
}

class LambdaDemo2 {

    public static void main(String[] args) {
        // A lambda expression that tests if a number is even.
        NumericTest isEven = (n) -> (n % 2) == 0;

        if(isEven.test(10))
            System.out.println("10 is even");
        if (!isEven.test(9)) {
            System.out.println("9 is not even");
        }

        //Now, use a lambda expression that tests if a number is non-negative.
        NumericTest isNonNeg = n -> n >= 0;
        if(isNonNeg.test(1))
            System.out.println("1 is non-negative");
        if (!isNonNeg.test(-1)) {
            System.out.println("-1 is negative");
        }
    }
}
@FunctionalInterface
interface NumericTest2 {
    boolean test(int n, int d);
}

class LambdaDemo3 {
    public static void main(String[] args) {
        //This lambda expression determines if one number is
        // a factor of another
        NumericTest2 isFactor = (n, d) -> (n % d) == 0;

        if (isFactor.test(10, 2)) {
            System.out.println("2 is a factor of 10");
        }

        if (!isFactor.test(10, 3)) {
            System.out.println("3 is not a factor of 10");
        }
    }
}