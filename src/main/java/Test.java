/**
 * Created by zm on 2017/11/25.
 */
public class Test {
    volatile long defaultVaule ;

    static void f1(int a) {
        System.out.println(a);
    }
    public static void main(String[] args) {
        //System.out.println(new Test().defaultVaule);
        System.out.println("ddd");
        Integer a = null;
        f1(a);
    }
}
