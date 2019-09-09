package thecompletereferenc;

import com.google.common.collect.Lists;

import java.io.ObjectStreamConstants;

/**
 * @author szd1007@github.com
 * @date 2018-11-08 13:29
 */
public class GenericTest implements Runnable{

    //泛型方法， 放在returnType之前
    //determine if an object is in an array
    //加了V 这样 T或者T的子类都可以判断,都使用T也可以，只要都满足T的定义也行
    static <T extends Comparable<T>, V extends T> boolean isIn(T x, V[] y) {
        for (V v : y) {
            if (x.equals(v)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Integer nums[] = { 1, 3 };
        if (isIn(1, nums)) {
            System.out.println("in");
        }

        String strs[] = { "122", "3" };
        if (isIn("3", strs)) {
            System.out.println();
        }

        geb[] bb = new geb[0];
        gea aa = new gea();
        geb b = new geb();
        //V定义指定 可以是gea 或者子类.r
        isIn(aa, bb);
        isIn(b, bb);

    }

    static class  gea implements Comparable {

        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }
    static class geb extends gea{

    }

    @Override
    public void run() {

    }

//    public static void main(String[] args) {
//        GenTest<GenericTest> gg = new GenTest<>();
//    }
}

/**
 *  泛型类型  继承一个类 和实现多个接口
 *  这个比直接使用父类和接口方式灵活，比较易懂
 * @param <T>
 */
class GenTest<T extends GenericTest & Runnable>{
    private T obj;


}

//using a wildcard
//使用通配符

class Stats<T extends Number>{

    T[]nums;    //array of Number or subclass

    // Pass the constructor a reference to
    // an array of type Number or subclass.

    Stats(T[] o){
        nums = o;
    }

    double average() {
        double sum = 0.0;

        for (int i =0 ; i < nums.length; i++){
            sum += nums[i].doubleValue();
        }
        return  sum / nums.length;
    }

    //使用通配符 ,此处代表任意的一个 t exteds number 对象， 类型限制看定义
    boolean sameAvg(Stats<?> ob) {
//    <X extends T>  boolean sameAvg(Stats<X> ob) {
        if (average() == ob.average()) {
            return true;
        }
        return false;
    }
    //这样使用只能是比较相同类型的值，因为T就是对象创建时的类型
    boolean sameAvgerr(Stats<T> ob) {
        if (average() == ob.average()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Stats<Integer> si = new Stats<Integer>(new Integer[]{1, 2});
        Stats<Double> ss = new Stats<Double>(new Double[]{1.0, 2.0});

        //raw type
        Stats xx = new Stats(null);

        System.out.println(si.sameAvg(ss));

        //编译出错，必须是同类型
       // System.out.println(si.sameAvgerr(ss));
    }
}

class Gga{
    int a;
    int b;

    public Gga(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

class Ggb extends  Gga{
    int c;

    public Ggb(int a, int b, int c) {
        super(a, b);
        this.c = c;
    }
}

class GCoordi <T extends Gga>{
    T[] ob;

    public GCoordi(T[] ob) {
        this.ob = ob;
    }

    public void printA(T obj) {
        System.out.println(obj.a + " : " + obj.b);
    }

    public void pp(GCoordi<?> gg) {
        System.out.println(gg.ob[0].a);
    }
    //T 限制类型， 通配符向上匹配，限制子类 上界通配符
    //通配符只能在引用参数中使用，不能直接<?>使用
    //代表的意思是 Ggb 或者 其子类
    public void printB(GCoordi<? extends Ggb> obj) {
        System.out.println(obj.ob[0].c);
    }

    //代表意思    Gga或者他的父类 下界通配符
    public void printSu(GCoordi<? super Gga> a) {

    }

    void test() {
        Gga a = new Gga(1, 2);
        GCoordi<Gga> gg = new GCoordi<>(new Gga[0]);
        //super  参数类本身
        printSu(gg);
        //传递的参数必须在声明类型中包含，
//        GCoordi<Object> ggcc = new GCoordi<>(new Object[0]);

        //error  要是ggb和子类
//        printB(gg);
        GCoordi<Ggb> ggb = new GCoordi<>(new Ggb[0]);
        printB(ggb);


        printSu(gg);

    }

}

class MyGenClass<T, V> {
    T t;
    V v;

    public MyGenClass(T t, V v) {
        this.t  = t;
        this.v = v;
    }

    boolean isSame(MyGenClass<T, V> o) {
        if (t == o.t && v == o.v) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        //类型推断用在类声明上
        MyGenClass<Integer, String> my1 = new MyGenClass<>(1, "11");
        MyGenClass<Integer, String> my2 = new MyGenClass<>(2, "22");

        //类型推断用在方法参数上
        my2.isSame(new MyGenClass<>(3, "33"));
    }
}











