package leet.arrayString;

import java.util.HashMap;

/**
 * 已经知道数组有序
 * 给定一个数组，查找两个数等于一个具体sum
   假定每个输出只有一个结果
===================================
 方案1 二分查找
 时间 nlogn  空间o1
 ===================================
 方案2   向内部靠拢方法
 时间on  空间o1

 Ai +Aj >target 减少j使结果变小
 Ai +Aj < target 增大i
 Ai + Aj = target

 */
public class _2_twoSum_arraySorted {

//===================================
//    方案1 二分查找
//    时间 nlogn  空间o1
    public static int[] twoSum(int [] numbers, int target){
        HashMap<Integer, Integer> map  = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int j = biSearch(numbers, target - numbers[i]);
            if (j >= 0) {
                return new int[]{i,j};
            }
        }
        throw new IllegalArgumentException("No two sum find");

    }

    //二分查找
    private static int biSearch(int[] numbers, int target) {

        int i =0,j=numbers.length-1,mid=-1;
        while (i < j) {
            mid = (i+j)/2;
            if (numbers[mid] > target) {
                i = mid +1;
            }else if(numbers[mid]<target){
                j = mid-1;
            }else {
                return mid;
            }
        }
        return (i==j && numbers[i]==target)? i:-1;
    }




// ===================================
//    方案2   向内部靠拢方法
//    时间on  空间o1

    public static int[] twoSum2(int [] numbers, int target) {
        int i=0,j= numbers.length-1;
        while (i < j) {
            if (numbers[i] + numbers[j] > target) {
                j --;
            }
            if (numbers[i] + numbers[j] < target) {
                i ++;
            }
            if (numbers[i] + numbers[j] == target) {
                return new int[]{i, j};
            }
        }
        throw new IllegalArgumentException("not sum found");
    }


    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 5, 7};
//        int [] res =  twoSum(array, 5);
        int [] res =  twoSum2(array, 7);

        for (int re : res) {
            System.out.println(re);
        }
    }
}
