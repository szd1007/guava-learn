package collections;

import com.google.common.base.Function;
import com.google.common.collect.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by zm on 17/1/10.
 * https://github.com/google/guava/wiki/NewCollectionTypesExplained
 */
public class NewCollectionTypesExplainedTest {

    public static void main(String[] args) {

        /**multiset test */
        Multiset<String> multiset = HashMultiset.create();
        multiset.add("a");
        multiset.add("b");
        multiset.add("a");
        System.out.println(multiset.count("a"));
        System.out.println(multiset.elementSet());
        System.out.println(multiset.entrySet());
        for(String s:multiset){
            System.out.println(s);
        }
        System.out.println(multiset.count("a"));
        multiset.remove(null);
        for(String s:Multisets.copyHighestCountFirst(multiset)){
            System.out.println("按元素出现次数降序输出 "+ s);
        }

        /**multiMap
         * better than:  Map<K,List<V>> (ArrayListMultimap)   Map<K,Set<V>>(HashMultimap)
         * 不用处理null的情况
         *
         */
        ArrayListMultimap<String,Integer> multimap =  ArrayListMultimap.create();
        List<Integer> key = multimap.get("n");
        multimap.put("a",1);
        multimap.put("b",1);
        multimap.put("a",2);
        System.out.println(key.size());
        //multimap.asMap();
        for(Map.Entry<String, Collection<Integer>> entry:multimap.asMap().entrySet()){
            entry.getKey();
            List<Integer>value = (List<Integer>) entry.getValue();
            System.out.println(value);
        }
        System.out.println("@@@@@@@@@@@@@");
        for(Map.Entry<String,Integer> entry :multimap.entries()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

        System.out.println("2222222222222");
        System.out.println(multimap.containsKey("a"));
        multimap.removeAll("a");
        System.out.println(multimap.containsKey("a"));



        /**
         * BiMap  一一对应  value值也必须唯一
         */
        System.out.println("**********BiMap********************");
        BiMap<String,String> bimap = HashBiMap.create();
        bimap.put("id1","a");
//        bimap.put("id2","a");//throw Exception
//        bimap.putIfAbsent("id2","a");
        bimap.put("id3","c");
        System.out.println(bimap.inverse().keySet());//inverse方法
        System.out.println("**********BiMap********************");


        ImmutableSet<String> digits = ImmutableSet.of("zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine");
        Function<String, Integer> lengthFunction = new Function<String, Integer>() {
            public Integer apply(String string) {
                return string.length();
            }
        };
        ImmutableListMultimap<Integer, String> digitsByLength = Multimaps.index(digits, lengthFunction);


    }
}
