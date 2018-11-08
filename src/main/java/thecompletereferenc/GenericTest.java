package thecompletereferenc;

/**
 * @author shangzhidong@zhuanzhuan.com
 * @date 2018-11-08 13:29
 */
public class GenericTest implements Runnable{

    @Override
    public void run() {

    }

    public static void main(String[] args) {
        GenTest<GenericTest> gg = new GenTest<>();
    }
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


        System.out.println(si.sameAvg(ss));

        //编译出错，必须是同类型
       // System.out.println(si.sameAvgerr(ss));
    }
}















