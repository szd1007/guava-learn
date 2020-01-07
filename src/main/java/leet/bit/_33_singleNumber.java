package leet.bit;

import leet.ICodePoints;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 *
 * Example Questions Candidate Might Ask:
 * Q: Does the array contain both positive and negative integers? A: Yes.
 * Q: Could any element appear more than twice? A: No.
 *
 * 方法1 用map  存在删除  不存在添加  ，最后就剩下一个
 *
 */
public class _33_singleNumber {
    @ICodePoints("XOR")
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res^=num;
        }
        return res;
    }

}
