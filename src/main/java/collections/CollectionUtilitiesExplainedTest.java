package collections;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Created by shangzhidong on 2017/1/11.
 * http://docs.oracle.com/javase/7/docs/api/java/util/Collections.html
 * https://github.com/google/guava/wiki/CollectionUtilitiesExplained
 */
public class CollectionUtilitiesExplainedTest {

    public static void main(String[] args) {


//        List<String> stringList = Lists.newArrayListWithExpectedSize(100);
        List<String> stringList = Lists.newArrayListWithCapacity(100);

        stringList.add("a");
        stringList.add("b");
        stringList.add("a");

        System.out.println(stringList);

        Collections.replaceAll(stringList, "a", "rep");

        System.out.println(stringList);

        /**expect/0.75 + 1*/
        Set<String> sets = Sets.newHashSetWithExpectedSize(100);

        System.out.println("##############################");

        List<String> stringList1 = Lists.newArrayList();
        stringList1.add("X");

        Iterable<String> x =Iterables.concat(stringList, stringList1);
        for(String s:x){
            System.out.println(s);
        }
        System.out.println(Iterables.frequency(stringList, "b"));
        System.out.println(Iterables.partition(stringList,1));
        System.out.println(Iterables.getFirst(stringList,"default value"));
        Iterables.getLast(stringList);
//        Iterables.limit()

        System.out.println("###########################");
        Iterables.addAll(stringList, stringList1);
        System.out.println(stringList);
        System.out.println(Iterables.size(stringList));
        /**  Lists*/
        System.out.println("############");
        System.out.println(stringList);
        List<String> reverseList =Lists.reverse(stringList);
        System.out.println(reverseList);
        stringList.set(0,"set");
        System.out.println(stringList);
        System.out.println(reverseList);

        /***Sets */
        System.out.println("################");
        Set<String>aset = Sets.newHashSet();
        Set<String>bset = Sets.newConcurrentHashSet();
        aset.add("a");
        bset.add("b");
        for (String str : Iterables.concat(aset, bset)) {
            System.out.println("set  "+str);
        }
        Sets.SetView<String>  setView =Sets.union(aset, bset);

        /**MultiSets*/


    }
}
