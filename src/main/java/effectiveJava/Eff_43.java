package effectiveJava;

import java.util.HashMap;
import java.util.Map;

/**
 * 43. 方法引用优先于Lambda[方法引用更简洁时就用方法引用]
 */
public class Eff_43 {
    public static void main(String[] args) {
        Map<String, Integer> sum = new HashMap<>();
        //方法引用 一般都是static方法 否则会生成对象
        sum.merge("a", 1, Integer::sum);
        sum.merge("a", 2, Integer::sum);
        //lambda表达式
        sum.merge("a", 3, (x, y) -> x + y);
        System.out.println(sum);
    }
}
