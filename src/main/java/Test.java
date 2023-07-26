import book.concurrencyInPractice.A;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import freemarker.core.JSONOutputFormat;

import javax.crypto.spec.PSource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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


        StringBuilder sb = new StringBuilder();
        sb.substring(0, sb.length()-1);
        List<Integer> integers = new ArrayList<>();
        Iterator iterator =integers.iterator();
        while (iterator.hasNext()) {
            iterator.remove();
        }
        System.out.println(integers);
//
//        AtomicInteger ai = new AtomicInteger(0);
//        System.out.println(ai.getAndIncrement());
//        System.out.println(ai);
//
//
//        Object o =null;
//        System.out.println(o instanceof  String);
//        long one = 1000;
//        long fee = new BigDecimal(one).multiply(new BigDecimal(5)).divide(new BigDecimal(100), 0, BigDecimal.ROUND_HALF_UP)
//                                                 .longValue();
//        System.out.println(fee);
        System.out.println(String.valueOf(true));
    }
}
