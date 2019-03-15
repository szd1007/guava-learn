/**
 * Created by zm on 2017/11/25.
 */
public class Test {
    volatile long defaultVaule ;

    static void f1(int a) {
        System.out.println(a);
    }
    public static void main(String[] args) {

//        Object a = null;
//
//        String b = (String) a;
//        System.out.println(b);
//        //System.out.println(new Test().defaultVaule);
//        System.out.println("ddd");
////        Integer a = null;
////        f1(a);

//        String a = null;
        String a = "sss";
        if (a instanceof String) {
            System.out.println("sss");
        }
    }
}
