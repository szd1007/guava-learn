import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

/**
 * Created by zm on 17/1/15.
 * https://github.com/google/guava/wiki/StringsExplained
 */
public class StringTest {

    public static void main(String[] args) {

        System.out.println("*****");
        String toBeSplit = ",a,,b  ,";
        String [] sp = toBeSplit.split(",");
        for(String s:sp){
            System.out.println("#"+s+"#");
        }

        Splitter splitter = Splitter.on(CharMatcher.anyOf(",:"))
                .trimResults()
                .omitEmptyStrings()
                ;
        for (String s : splitter.split(toBeSplit)) {
            System.out.println("@"+s+"@");
        }



        System.out.println("#################################");
//        Joiner joiner = Joiner.on(":").skipNulls();
        Joiner joiner = Joiner.on(":").useForNull("nullDefault");//null默认值

        String str2 = joiner.join("a", "b", null, "d");
        System.out.println(str2);

        System.out.println(Joiner.on("xx").skipNulls().join(Arrays.asList(1,2,3)));
        System.out.println("#################################");

        //简直完美啊  splitter trim结果 并且能够删除空结果
        List<String> readFromStr = Lists.newArrayList(splitter.split(toBeSplit));

    }
}
