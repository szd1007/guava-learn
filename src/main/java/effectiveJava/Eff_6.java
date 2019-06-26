package effectiveJava;

import java.util.regex.Pattern;

/**
 * 6. 避免创建不必要的对象[]
 */
public class Eff_6 {

    @EfLanguagePoints("Pattern 本身是线程安全的，并且创建该对象非常耗时。避免多次创建" +
            " 2 代码同时也清晰了")
    private static final Pattern ROMAN = Pattern.compile("^hello");
    static boolean isMatch(String s){
        return ROMAN.matcher(s).matches();
    }

    @DonotDoThis
    static boolean isMatch2(String s){
        Pattern ROMAN = Pattern.compile("^hello");
        return ROMAN.matcher(s).matches();
    }


    ////////////////////////////////////////////////////

    @EfLanguagePoints("防止不必要的自动装箱")
    private static long sum(){
        @EfLanguagePoints("要优先使用基本类型而不是装箱基本类型")
//        Long sum = 0L;
        long sum =0;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum+=i;
        }
        System.out.println(sum);
        return sum;
    }


    public static void main(String[] args) {
        sum();
    }
}
