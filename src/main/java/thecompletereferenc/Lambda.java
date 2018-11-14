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

interface NumericFunc {

    int func(int n);
}

class BlockLambdaDemo {

    public static void main(String[] args) {
        //This block lambda computes the factorial of an int value.
        //int result =1;
        //外部定义的变量要是final的才可以
        NumericFunc factorial = (n -> {
            int result = 1;

            for (int i = 1; i <= n; i++) {
                result *= i;
            }
            return result;
        });

        System.out.println("The factorial of 3 is " + factorial.func(3));
        System.out.println("The factorial of 5 is " + factorial.func(5));
    }
}

//a block lambda that reverses the characters in a string.
interface StringFunc {

    String func(String string);
}

class BlockLambdaDemo2 {

    public static void main(String[] args) {
        //This block lambda reverses the characters in a string .
        StringFunc reverse = (str -> {
            String result = "";
            int i ;
            for(i = str.length()-1; i >= 0; i--) {
                result += str.charAt(i);
            }
            return result;
        });
        System.out.println("Lambda reversed is " + reverse.func("Lambda"));
        System.out.println("Expression reversed is " + reverse.func("Expression"));
    }
}

//Use a generic functional interface with lambda expressions.

//A generic functional interface.
interface SomeFunc<T> {

    T func(T t);
}

class GenericFunctionalInterfaceDemo {

    public static void main(String[] args) {
        //Use a String-based version of SomeFunc.
        SomeFunc<String> reverse = (str) -> {
            String res = "";
            int i;

            for (int j = str.length() - 1; j >= 0; j--) {
                res += str.charAt(j);
            }
            return res;
        };

        System.out.println("Lambda reversed is " + reverse.func("Lambda"));
        System.out.println("Expression reversed is " + reverse.func("Expression"));

        //Now, use an Integer-based version of SomeFunc.
        SomeFunc<Integer> factorial = (n) -> {
            int res = 1;
            for (int i = 1; i <= n; i++) {
                res *= i;
            }
            return res;
        };

        System.out.println("The factorial of 3 is " + factorial.func(3));
        System.out.println("The factorial of 5 is " + factorial.func(5));


    }
}


//lambda当作参数进行传递
class LambdaAsArgumentsDemo {

    static String stringOp(SomeFunc<String> fun, String string) {
        return fun.func(string);
    }

    public static void main(String[] args) {
        System.out.println(stringOp(String::toUpperCase, "hello world"));

        String outStr = stringOp((str) -> {
            String res = "";
            int i;
            for (int j = str.length() - 1; j >= 0; j--) {
                res += str.charAt(j);
            }
            return res;
        }, "xxx123");

        System.out.println(outStr);
    }
}


interface DoubleNumericArrayFunc {
    //lambda抛出的检查异常需要是在functionalInterface中显示声明的异常
    double func(double [] n) throws EmptyArrayException;
}

class LambdaExceptionDemo {

    public static void main(String[] args) throws EmptyArrayException {
        double[] values = { 1.0, 2.0, 3.0, 4.0 };

        //This block lambda computes the average of an array of doubles.
        DoubleNumericArrayFunc average = (n) -> {
            double sum = 0;
            if (n.length == 0) {
                throw new EmptyArrayException();
            }
            for (int i = 0; i < n.length; i++) {
                sum += n[i];
            }
            return sum / n.length;
        };
        System.out.println("The average is " + average.func(values));
        System.out.println("The average is " + average.func(new double[0]));

    }
}

class VarCapture {

    //成员变量可以改
    private int a;

    void test() {
        int enclosingLocal = 10;
        SomeFunc<Integer> func = (n) -> {
            a = n + enclosingLocal;
            a++;
            // lambda的封装范围的局部变量必须是 effect final（创建后不能更改)
            //            enclosingLocal ++;
            return a;
        };

        //这样也不行 导致变量不是effect final
//        enclosingLocal ++;
    }
}

//Method reference
class MyStringOps{
    //static method
    static String strReverse(String str) {
        String res = "";
        int i;
        for (int j = str.length() - 1; j >= 0; j--) {
            res += str.charAt(j);
        }
        return res;
    }

    String strReverseInstance(String str) {
        String res = "";
        int i;
        for (int j = str.length() - 1; j >= 0; j--) {
            res += str.charAt(j);
        }
        return res;
    }
}


class MethodRefDemo {


    static String stringOp(StringFunc sf, String s) {
        return sf.func(s);
    }


    public static void main(String[] args) {
        String inStr = "Lambda add power to Java";
        String outStr;

        //传递的并不是接口的实现。而是一个普普通通的静态方法
        //但是 有着和interface相同的出入参。
        outStr = stringOp(MyStringOps::strReverse, inStr);

        // 方法引用， 执行时生成对应functionalInterface实例
        StringFunc test = MyStringOps::strReverse;

        System.out.println("reversed " + outStr);

        MyStringOps stringOps = new MyStringOps();

        outStr = stringOp(stringOps::strReverseInstance, inStr);

        //这样使用报错，
//        outStr = stringOp(MyStringOps::strReverseInstance, inStr);

        System.out.println("reversed " + outStr);

    }
}
