package leet.bit;

import leet.ICodePoints;

/**
 Question:
 Given an array of integers, every element appears three times except for one. Find that single one.
 Note:
 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

 int是32位， 每个数据位上1出现的次数 3 4 0 （我们要求的数据 %3 即可）
 *
 */
public class _34_singleNumber2 {
    @ICodePoints("XOR")
    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (((nums[j] >> i) & 1)>0) {
                    count++;
                }
            }
            res |= (count%3)<<i;
        }
        return res;
    }

    public static void main(String[] args) {
        int num[]=new int[]{2,2,3,2};
        System.out.println(singleNumber(num));
    }

}
