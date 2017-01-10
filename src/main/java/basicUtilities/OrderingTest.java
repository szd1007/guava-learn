package basicUtilities;

import com.google.common.base.Function;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;

import java.util.*;

/**
 * Created by shangzhidong on 2017/1/10.
 * https://github.com/google/guava/wiki/OrderingExplained
 */
public class OrderingTest {


    public static void main(String[] args) {
        Ordering<String> byLengthOrdering = new Ordering<String>(){
            @Override
            public int compare(String left, String right) {
                return Ints.compare(left.length(),right.length());
            }
        };
        List<String> strList = new ArrayList<String>(Arrays.asList("1","33","111"));
        Collections.sort(strList,byLengthOrdering);
        System.out.println(strList);


        Ordering<Foo> nullableOrdering = Ordering.natural().nullsFirst()
                .onResultOf(new Function<Foo, Integer>() {
                    public Integer apply(Foo input) {
                        return input.nullableField;
                    }
                });

        //取前多少个
        System.out.println(byLengthOrdering.greatestOf(strList,2));
        System.out.println(byLengthOrdering.max(strList));
        System.out.println(byLengthOrdering.min(strList));
    }


    /***
     * 允许空字段的排序
     */
    class Foo{

        int nullableField;
    }

}
