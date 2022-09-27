package leet.old.arrayString;

import leet.ICodeAlgorithm;
import leet.ICodePoints;

/**
 * 回文验证
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * 时间on 空间o1
 */
@ICodeAlgorithm("//todo 在一个字符串中找多个回文串")
@ICodePoints("设置i 范围0，n-1 ,以i为中心向两侧查找回文 时间onm  空间o1")

public class _4_validPalindrome {


    public static boolean isValidPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;

    }

    public static void main(String[] args) {
      //  System.out.println(isValidPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isValidPalindrome("race a car"));
    }
}
