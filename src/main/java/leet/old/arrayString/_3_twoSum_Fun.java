package leet.old.arrayString;

import java.util.HashMap;
import java.util.Map;

/**
 *  设计一个类，
 *  有add 和find操作
 *  分析复杂度
 *  add o1  find on     space on
 *  存储用hash表 和方法一一致
 *
 */
public class _3_twoSum_Fun {

    private HashMap<Integer, Integer> map  = new HashMap<>();
    public _3_twoSum_Fun add(int a){
        int count = map.getOrDefault(a, 0);
        map.put(a, count+1);
        return this;
    }
    public boolean find(int target){
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer k = entry.getKey();
            Integer count = entry.getValue();
            int remain = target - k;
            //@EfLanguagePoints("处理重复值的情况")
            if (remain == k ) {
                if (count > 1) {
                    return true;
                }
            } else if (map.containsKey(target - k)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        _3_twoSum_Fun  fun = new _3_twoSum_Fun();
        fun.add(1).add(3).add(6).add(7);
        System.out.println(fun.find(1));
    }
}
