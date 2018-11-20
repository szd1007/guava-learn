package thecompletereferenc;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

public class StringHandling17 {

    public static void main(String[] args) {
        char[] c = {'a', 'c'};

        String s = new String(c);
        String s1 = new String(c, 1, 1);

        byte[] ascii = { 22, 66, 67, 68, 69, 70 };

        String as1 = new String(ascii);
        System.out.println(as1);

        String as2 = new String(ascii, 2, 3);
        System.out.println(as2);

        //兼容ascii码，utf8
        String as3 = new String(ascii, Charsets.UTF_8);
        System.out.println(as3);

        //valueOf 重载函数在连接字符串时被调用
        String cont = "this is " + String.valueOf(9);
        String cont2 = "this is " + 9;

        //getChars
        getChars();

        //getBytes
        System.out.println(s.getBytes(Charsets.UTF_8));

        String ss3 = "Ac";
        System.out.println(s + " equalIgnoreCase " + ss3 + " -> " + s.equalsIgnoreCase(ss3));

        //toCharArray
        char[] s_Array = s.toCharArray();

        //regionMatches
        String re01 = "abcdefaa";
        String re02 = "bcd";
        Boolean flag = re01.regionMatches(1, re02, 0, re02.length());
        System.out.println("region match " + flag);
        flag = re01.regionMatches(0, re02, 0, re02.length());
        System.out.println("region match " + flag);

        //compareTo' compareToIgnoreCase, string自身实现了基于字典排序的算法（ascii码值）
        System.out.println("ab compareTo ac -> +" + "ab".compareTo("ac"));
        List<String> stringList = Lists.newArrayList("ab", "AA", "222", "1");
//        stringList.sort(String::compareTo);
        Collections.sort(stringList);
        System.out.println(stringList);

        //todo
        //replace 这个就可以替换所有的字符串
        System.out.println(re01.replace("a","xx"));
        //正则匹配
//        re01.replaceAll()

    }

    static void getChars() {
        String s = "This is a demo of the getChars method.";
        int start = 10;
        int end   = 14;
        char buf[] = new char[end - start];

        s.getChars(start, end, buf, 0);
        System.out.println(buf);


    }
}
