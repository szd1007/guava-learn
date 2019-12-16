package leet.arrayString;

import java.util.HashMap;
/**
 * 给定一个数组，查找两个数等于一个具体sum
   假定每个输出只有一个结果

    1 暴力破解， 时间onn  o1空间

     2 hash表   时间on 空间on
 */
public class _1_twoSum {


    public static int[] twoSum(int [] numbers, int target){
        HashMap<Integer, Integer> map  = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{map.get(target-numbers[i]), i};
            }
            map.put(numbers[i], i);
        }
        throw new IllegalArgumentException("No two sum find");

    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 5, 2, 3, 7};
        int [] res =  twoSum(array, 5);
        for (int re : res) {
            System.out.println(re);
        }
    }
}
