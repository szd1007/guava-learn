package thecompletereferenc;

import java.util.function.Function;

/**
 * @author szd1007@github.com
 * @date 2018-11-14 13:36
 */
public class Lambda222 {

}

//Constructors References
// classname::new
@FunctionalInterface
interface MyFunc222{
    MyClass22 func(int n);
}
class MyClass22 {
    private int val;

    MyClass22(int val) {
        this.val = val;
    }
    MyClass22(){}
    int getVal(){
        return val;
    }
}
class ConstructorRefDemo {

    public static void main(String[] args) {
        MyFunc222 myFunc222 = MyClass22::new;

        //创建对象1。可以当作工厂方法来用
        MyClass22 obj1 = myFunc222.func(1);
        //创建对象2
        MyClass22 obj2 = myFunc222.func(2);

        System.out.println(obj1);
        System.out.println(obj2);
    }
}

interface MyFunc33<R, T> {
    R func(T n);
}
//A simple generic class.
class Myclass3<T> {
    private T val;

    Myclass3(T val) {
        this.val = val;
    }

    T getVal() {
        return val;
    }
}

class Myclass4 {
    String str;

    Myclass4(String s) {
        str = s;
    }

    String getVal() {
        return str;
    }
}

class ConstrucotrRefDemo3{

    //工厂方法创建类，所有满足 Myfunc33  R func(T n); 类型构造函数的类都可以这么创建
    static <R, T> R myClassFactory(MyFunc33<R, T> func33, T t) {
        return func33.func(t);
    }

    public static void main(String[] args) {
        MyFunc33<Myclass3<Double>, Double> doubleMyFunc33 = Myclass3<Double>::new;
        Myclass3<Double> my1 = myClassFactory(doubleMyFunc33, 1.0);

        MyFunc33<Myclass4, String> yyFunc44 = Myclass4::new;
        Myclass4 myclass4 = myClassFactory(yyFunc44, "sdfs");

        System.out.println(my1.getVal());

        System.out.println(myclass4.getVal());
    }
}


/*
  java  预定义functional interface
    function<t,r>
    Predicate<T>

 */

class UseFunctionInterfaceDemo {
    public static void main(String[] args) {
        Function<Integer, Integer> factorial = (x)->{
            int res = 1;
        for (int i = 1; i <= x; i++) {
            res *= i;
        }
        return res;
        };

        System.out.println("the factorial of 3 " + factorial.apply(3));

    }
}