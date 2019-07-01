package thecompletereferenc;

import effectiveJava.EfLanguagePoints;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

/**
 * lambda  传递方法引用， 只要能匹配对应functionalInterface的context（入参出参数）就行
 * 不用非要是接口实现
 */

class MethodRefDemo {


    static String stringOp(StringFunc sf, String s) {
        System.out.println("sf:" + sf);
        return sf.func(s);
    }


    public static void main(String[] args) {
        String inStr = "Lambda add power to Java";
        String outStr;

        //传递的并不是接口的实现。而是一个普普通通的静态方法
        //但是 有着和interface相同的出入参。
        //每次调用生成一个新的实例对象
        outStr = stringOp(MyStringOps::strReverse, inStr);
        outStr = stringOp(MyStringOps::strReverse, inStr);
        System.out.println("===============");
        // 方法引用， 执行时生成对应functionalInterface实例

        System.out.println("reversed " + outStr);

        MyStringOps stringOps = new MyStringOps();

        //每次调用生成一个新的实例对象
        outStr = stringOp(stringOps::strReverseInstance, inStr);
        outStr = stringOp(stringOps::strReverseInstance, inStr);

        System.out.println("=============");
        StringFunc test = MyStringOps::strReverse;
        //test 是一个相同实例对象
        outStr = stringOp(test, inStr);
        outStr = stringOp(test, inStr);

        //这样使用报错，
//        outStr = stringOp(MyStringOps::strReverseInstance, inStr);

        System.out.println("reversed " + outStr);

    }
}

interface MyFuncMethodRef<T> {

    boolean func(T v1, T v2);
}

class HighTemp {
    private int hTemp;

    HighTemp(int hTemp) {
        this.hTemp = hTemp;
    }

    boolean sameTemp(HighTemp ht2) {
        return hTemp == ht2.hTemp;
    }

    boolean lessThanTem(HighTemp ht2) {
        return hTemp < ht2.hTemp;
    }
}

class InstanceMethWithObjectRefDemo {
    //

    static <T> int counter(T[] vals, MyFuncMethodRef<T> f, T v) {
        int count = 0;
        for (int i = 0; i < vals.length; i++) {
            if (f.func(vals[i], v)) {
                count ++;
            }
        }
        return count;
    }

    static <T> boolean match(T t1, T t2) {
        return t1 == t2;
    }

    static <T extends Number> void myMatch(MyFuncMethodRef<T> f, T t1, T t2) {
        f.func(t1, t2);
    }
    public static void main(String[] args) {
        int count ;
        HighTemp[] weekDayHighs = {new HighTemp(89), new HighTemp(82),
                                    new HighTemp(90), new HighTemp(89),
                                    new HighTemp(84), new HighTemp(83)};

        //boolean func(T v1, T v2);
        // v1 v2 类型相同， 将v1映射成了lessThanTem方法的调用者，v2映射成了具体参数
        count = counter(weekDayHighs, HighTemp::lessThanTem, new HighTemp(89));

        //传递参数，带泛型
        myMatch(InstanceMethWithObjectRefDemo::<Integer>match, 1, 1);
        //自动关联类型为Integer
        myMatch(InstanceMethWithObjectRefDemo::match, 1, 1);

        //error 泛型匹配出错
        //myMatch(InstanceMethWithObjectRefDemo::match, "Strin", 1);

    }
}


class MyIntClass {
    private int val;

    MyIntClass(int val) {
        this.val = val;
    }
    int getVal(){
        return val;
    }
}
class CompareMethodRed {

    //定义一个兼容comparator<T> 接口的方法
    @EfLanguagePoints("所有的基本类型都已经有了对应的compare方法，直接使用")
    static int compareMC(MyIntClass a, MyIntClass b) {
        return Integer.compare(a.getVal(),b.getVal());
    }

    public static void main(String[] args) {
        List<MyIntClass> a1 = new ArrayList<>();

        a1.add(new MyIntClass(1));
        a1.add(new MyIntClass(-4));
        a1.add(new MyIntClass(5));

        MyIntClass max = Collections.max(a1, CompareMethodRed::compareMC);
        MyIntClass max2 = Collections.max(a1, (c1, c2) -> c1.getVal() - c2.getVal());
        MyIntClass max3 = Collections.max(a1, Comparator.comparingInt(MyIntClass::getVal));
        System.out.println(max.getVal());
    }
}
