import java.math.BigDecimal;

/**
 * Created by zm on 2017/11/25.
 */
public class Test {
    volatile long defaultVaule ;

    static void f1(int a) {
        System.out.println(a);
    }
//    public static void main(String[] args) {
//
////        Object a = null;
////
////        String b = (String) a;
////        System.out.println(b);
////        //System.out.println(new Test().defaultVaule);
////        System.out.println("ddd");
//////        Integer a = null;
//////        f1(a);
//
////        String a = null;
//        String a = "sss";
//        if (a instanceof String) {
//            System.out.println("sss");
//        }
//    }

    public static void main(String[] args) {
        long one = 1000;
        long fee = new BigDecimal(one).multiply(new BigDecimal(5)).divide(new BigDecimal(100), 0, BigDecimal.ROUND_HALF_UP)
                                                 .longValue();
        System.out.println(fee);
    }
}
