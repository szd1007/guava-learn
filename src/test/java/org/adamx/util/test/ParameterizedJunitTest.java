package org.adamx.util.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedJunitTest {
    private int in;
    private int out;

    @Parameterized.Parameters
    public static Collection data(){
        return Arrays.asList(new Object[][]{
            {1,2},
            {2,3},
            {0,0}
        });
    }

    public ParameterizedJunitTest(int input , int expect){
        this.in = input;
        this.out = expect;
    }

    @Test
    public void normalTest(){
        assertEquals(in+1, out)

        ;

    }



    public String minWindow(String s, String t) {

        Map<Character, Integer> charMap = new HashMap<>();
        Map<Character, Integer> curMap = new HashMap<>();
        for(int i=0; i<t.length(); i++){
            charMap.put(t.charAt(i), 0);
        }
        int valid = t.length();

        int left=0, right=0;
        int start=-Integer.MAX_VALUE, end=0;
        while(right < s.length()){
            char c = s.charAt(right);
            right++;
            //具体逻辑
            if(charMap.containsKey(c)){
                curMap.put(c, curMap.getOrDefault(c, 0));
            }

            //判断是否到了收缩求最优解的时候
            while(needShrink(curMap, charMap)){
                char d = s.charAt(left);
                // 更新结果
                if((right - left)<(end-start)){
                    end = right;
                    left = left;
                }

                left++;

            }
        }
        if(left>=0){
            return s.substring(left, right);
        }
        return "";
    }
    private boolean needShrink(Map<Character, Integer> curMap, Map<Character, Integer> charMap){
        for(Map.Entry<Character, Integer> entry: charMap.entrySet()){
            char c = entry.getKey();
            int count = entry.getValue();
            if(!curMap.containsKey(c) || curMap.get(c)<count){
                return false;
            }
        }
        return true;
    }

    private  void sort(){
        int [][] a = new int[2][2];
        Arrays.sort(a, (int[] x, int[] y) -> x[1]-y[1]);
    }
}
