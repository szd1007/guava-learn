package collections;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

/**
 * Created by zm on 17/1/10.
 */
public class NewCollectionTypesExplainedTest {

    public static void main(String[] args) {

        /**multiset test*/
        Multiset<String> multiset = HashMultiset.create();
        multiset.add("a");
        multiset.add("b");
        multiset.add("a");
        System.out.println(multiset.count("a"));
        System.out.println(multiset.elementSet());
        for(String s:multiset){
            System.out.println(s);
        }
        multiset.

    }
}
