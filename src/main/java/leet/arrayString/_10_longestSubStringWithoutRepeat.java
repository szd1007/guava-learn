package leet.arrayString;

import java.util.Arrays;

/**
 * 求解 最长不重复子串
 * ====
 * 面试提问，这个表包含的字符串是啥。
 */
public class _10_longestSubStringWithoutRepeat {

    //"abcabcbb"
    public static int lengthOfLongestSubString(String s){
        boolean [] exists = new boolean[256];
        int i = 0;
        int max=0;
        for (int j = 0; j < s.length(); j++) {
            while (exists[s.charAt(j)]) {
                exists[s.charAt(i)]=false;
                i++;
            }
            if (max < j - i + 1) {
                max = j - i + 1;
            }
            exists[s.charAt(j)]=true;
        }
        return max;
    }
    public static int lengthOfLongestSubString2(String s){
        int [] exists = new int [256];
        Arrays.fill(exists, -1);
        int max=0;
        int last = 0;
        for (int j = 0; j < s.length(); j++) {
            if(exists[s.charAt(j)]>=last){
                last = exists[s.charAt(j)]+1;
            }
            exists[s.charAt(j)]=j;
            max = Math.max(max, j- last +1);

        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubString2("abcabcbb"));
    }
}
