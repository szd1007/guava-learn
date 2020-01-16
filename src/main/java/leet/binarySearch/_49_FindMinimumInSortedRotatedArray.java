package leet.binarySearch;

import leet.ICodePoints;

/**
 *
 Question:
 Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 Find the minimum element.
 You may assume no duplicate exists in the array.
 http://www.adamx.org:9999/pics/java/116321579149129_.pic_hd.jpg

 如果存在等值的情况
 http://www.adamx.org:9999/pics/java/671579149543_.pic_hd.jpg
 */
public class _49_FindMinimumInSortedRotatedArray {
    public int findMin(int[] nums) {
        int L = 0 , R= nums.length-1,m;
//        @ICodePoints("特殊情况，数组没有反转")
        if (nums[L] < nums[R]) {
            return nums[0];
        }

        while (L < R) {
            m = (L+R)/2;
            if (nums[m] > nums[R]) {
                L = m+1;
            }else {
                R =m;
            }
        }
        return nums[L];
    }

}
