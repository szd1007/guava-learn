package leet.binarySearch;

import leet.ICodePoints;

/**
 * 经典二分查找
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 */
public class _48_searchInsertPos {
    @ICodePoints("重点看特殊类型 1 2 3 4 ")
    public int searchInsert(int[] nums, int target) {
        int L=0, R= nums.length;
        while (L < R) {
            int mid = (L +R)/2;
            if (target> nums[mid]) {
                L = mid+1;
            }else {
                R = mid;
            }
        }
        return (nums[L] < target ? L + 1 : L);
    //
    }

    //二分查找
    @ICodePoints("自我验证过程|| 试一下元素个数0 1 2的情况")
    private static int biSearch(int[] numbers, int target) {

        int low =0,mid,high=numbers.length-1;
        while (low < high) {
            mid = (low+high)/2;
            if (target < numbers[mid]) {
                high = mid -1;
            }else if(target > numbers[mid]){
                low = mid+1;
            }else {
                return mid;
            }
        }
        return (low==high && numbers[low]==target)? low:-1;
    }


}
