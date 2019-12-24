package leet.arrayString;

import com.google.common.base.Strings;
import leet.ICodePoints;

/**
 * 字符串转换int
 * 有正负号 前后可能有空格。
 * <p>
 * 核心 处理溢出问题
 */
public class _8_String_to_int {

    public static int stringToInt(String s) {
        if (null==s ) {
            return 0;
        }
        @ICodePoints("如果适用long，那么在最后返回值的时候进行判断。但是也可能存在long溢出")
        int num = 0;
        int sin = 1;
        int i = 0;
        int maxDiv = Integer.MAX_VALUE/10;
//        @ICodePoints("还是边界问题")
        while (i<s.length() &&' ' == s.charAt(i)) i++;
        if (i<s.length() && '-' == s.charAt(i)){
            sin = -1;
            i++;
        }else if (i<s.length() && '+' == s.charAt(i)) {
            i++;
        }
        for (; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int digit = s.charAt(i) - '0';
                //@ICodePoints("标准解法")
                if (num > maxDiv || num == maxDiv && digit >= 8) {
                    return sin==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
                }
                num = 10 * num + digit;
//                @ICodePoints("(不用long的情况)整数溢出判断 num>maxDiv10 || num == maxDiv10 && digit >= 8) {")
//                @ICodePoints("maxDiv10=Integer.MAX_VALUE 如果num比前边大 乘10肯定溢出")
//                @ICodePoints("maxDiv10==num 此时num等于2的28次方，digit>=8会导致num左移次数大于3.导致溢出")

            }else{
                break;
            }
        }
        return  num * sin;
    }

    public static void main(String[] args) {
        System.out.println(stringToInt("   -42"));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
