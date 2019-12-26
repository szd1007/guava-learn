package leet.arrayString;
/*
Given two strings S and T, determine if they are both one edit distance apart.
1. 两个字符串的长度之差大于1，直接返回False。

2. 两个字符串的长度之差等于1，长的那个字符串去掉一个字符，剩下的应该和短的字符串相同。

3. 两个字符串的长度之差等于0，两个字符串对应位置的字符只能有一处不同。
 */

public class _14_oneEditDistance {

    public static boolean isOneEditDistance(String m, String n){
        int mLen =m.length();
        int nLen =n.length();
        if (mLen < nLen) {
            return isOneEditDistance(n,m);
        }
        if (mLen - nLen > 1) {
            return false;
        }
        if (mLen - nLen == 1) {
            return judge(0,m,n,0)||judge(1,m,n,0);
        }
        return judge(0,m,n,1);
    }


    private static boolean judge(int t, String m, String n, int diff) {
        int find=0;
        for (int i = 0; i < n.length(); i++) {
            if (m.charAt(t + i) != n.charAt(i)) {
                find++;
            }
        }
        return diff==find;
    }


    public static void main(String[] args) {
        System.out.println(isOneEditDistance("cab","ad"));
    }
}
