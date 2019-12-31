package leet.math;

import leet.ICodePoints;

/**
 * 回文数字
 * Determine whether an integer is a palindrome. Do this without extra space.
 * Example Questions Candidate Might Ask:
 * Q: Does negative integer such as –1 qualify as a palindrome?
 * A: For the purpose of discussion here, we define negative integers as non-palindrome.
 *
 */
public class _19_PalindromeNumber {

    public static boolean isPalindromeNumber(int x) {
        if (x < 0) {
            return false;
        }
        int div = 1;
        int i = x;
        while (i > 10) {
            div*=10;
            i/=10;
        }
        while (x > 0) {
            if ((x/div) != (x % 10)) {
                return false;
            }
            x%=div;
//            @ICodePoints("掐头去尾，进制位数一次少了两个，所以除100")
            div/=100;
            x/=10;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromeNumber(11));
    }
}
