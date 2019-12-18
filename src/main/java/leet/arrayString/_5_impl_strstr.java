package leet.arrayString;

import effectiveJava.EfLanguagePoints;
import leet.ICodeAlgorithm;
import leet.ICodePoints;

/**
 * 实现java  indexOf
 * 查找不到返回-1
 *
 * 方案一
 * onm  o1 space 暴力破解
 *Have you considered these scenarios?
 * i. needle or haystack is empty. If needle is empty, always return 0. If haystack is empty,
 * then there will always be no match (return –1) unless needle is also empty which 0 is returned.
 *
 * ii. needle’s length is greater than haystack’s length. Should always return –1.
 *
 * iii. needle is located at the end of haystack. For example, “aaaba” and “ba”. Catch
 * possible off-by-one errors.
 *
 * iv. needle occur multiple times in haystack. For example, “mississippi” and
 * “issi”. It should return index 2 as the first match of “issi”.
 *
 * v. Imagine two very long strings of equal lengths = n, haystack = “aaa...aa” and needle = “aaa...ab”.
 * You should not do more than n character comparisons, or else your code will get Time Limit Exceeded in OJ.
 *
 * 、
 *
 */
@ICodeAlgorithm("todo// KMP算法")
public class _5_impl_strstr {
    @ICodePoints("暴力遍历法")
    public static int strstr(String str, String needle) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; ; j++) {
                if(j == needle.length()) return i;
                if (str.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                //如果走到这个分支，说明后面的不用比较了，都会失败。
                //因为剩下的都不够needle的长度了
                if (i + j == str.length()) {
                    return -1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strstr("sldfjslkjfdjw2eesss","kjf"));
    }
}
