package effectiveJava;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.math.BigDecimal;
import java.util.TreeSet;

/**
 * 14. 考虑实现comparable接口
 * @see thecompletereferenc.CompareMethodRed
 * @see thecompletereferenc.MapTest
 *
//key取第二个字符，字典排序倒序
Comparator<String> cmp = Comparator.comparingInt(String::length)
.thenComparing(x -> x.substring(1,2)
,String.CASE_INSENSITIVE_ORDER.reversed());
TreeMap<String, Double> tcm = new TreeMap<>(Comparator.nullsFirst(cmp));


 */

@EfLanguagePoints("排序集合使用compareTo   普通集合使用equals  导致差异")
public class Eff_14 {



    @EfLanguagePoints("compareTo b1 b2 相等 所以就存了一个元素到treeSet")
    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal("1.0");
        BigDecimal b2 = new BigDecimal(("1.00"));
        System.out.println(b1.equals(b2));
        System.out.println(b1.compareTo(b2));
        System.out.println(Sets.newHashSet(b1, b2).size());
        TreeSet treeSet = Sets.newTreeSet();
        treeSet.addAll(Lists.newArrayList(b1, b2));
        System.out.println(treeSet.size());
    }
}
