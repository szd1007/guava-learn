package leet.old.arrayString;


import java.util.Objects;

public class _13_LongestPalindromicSubstring {

    private static String findLongestPalindromicSubString(String t) {
        if (Objects.isNull(t) || t.length() == 0) {
            return "";
        }
        int l=0,r=0;
        for (int i = 0; i < t.length(); i++) {
            int tmp = findLongSub(t, i, i);
            int tmp2 = findLongSub(t, i, i+1);
            int len = Math.max(tmp, tmp2);
            if (len > (r - l )) {
                //@ICodePoints("长度1 或者2时，开始坐标不会改变")
                l = i -(len-1)/2;
                //@ICodePoints("长度1 终止坐标不会改变")
                r = i + len/2;
            }
        }
        return t.substring(l,r+1);
    }

    private static int findLongSub(String t, int s, int e) {
        int len = 0;
//        @ICodePoints("执行1次，相差2")
        while (s >= 0 && e < t.length() && t.charAt(s)==t.charAt(e)) {
            s--;
            e++;
        }
        return e-s-1;
     }

    public static void main(String[] args) {
        String s= "";
        System.out.println(findLongestPalindromicSubString(s));
    }
}
