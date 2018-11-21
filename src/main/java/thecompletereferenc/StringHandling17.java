package thecompletereferenc;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class StringHandling17 {

    public static void main(String[] args) {
        char[] c = { 'a', 'c' };

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
        System.out.println(re01.replace("a", "xx"));
        //正则匹配
        //        re01.replaceAll()

        //String.valueOf. char数组有专门的重载函数
        System.out.println(String.valueOf(s.toCharArray()));
        System.out.println(s.toCharArray());
        //普通int数组当作object来处理。toString方法
        int aa[] = { 1, 2, 3 };
        System.out.println("int array: " + String.valueOf(aa));
        System.out.println(aa);
    }

    static void getChars() {
        String s = "This is a demo of the getChars method.";
        int start = 10;
        int end = 14;
        char buf[] = new char[end - start];

        s.getChars(start, end, buf, 0);
        System.out.println(buf);

    }

    @Test
    public void toUpperLowerCase() {
        String a = "sdfFFF222I";
        System.out.println(a.toUpperCase());
        System.out.println(a.toLowerCase());
        //turkish i会没有点
        System.out.println(a.toLowerCase(Locale.TAIWAN));

    }

    // 字符串连接，
    @Test
    public void stringJoinTest() {
        String r = String.join(", ", "aa", "bb", "dd");
        System.out.println(r);
        List<String> stringList = Lists.newArrayList("aa", "dd");
        System.out.println(String.join(",", stringList));
    }

    @Test
    public void commaFunStr() {
        //emoj占两个字符（4字节）
        String mb4 = "\u8001将\uD83D\uDE4B出马";
        System.out.println(mb4.charAt(0));
        System.out.println(mb4.charAt(2));
        System.out.println(mb4);
        System.out.println(mb4.length());
        //输出char的unicode编码
        System.out.println(mb4.codePointAt(2));
        System.out.println(mb4.codePointAt(3)); //de4b
        System.out.println(mb4.codePointAt(0));
    }

    @Test
    public void testStringBuffer() {
        //此构造函数默认分配 传递字符串长度 + 16 char空间 (无参构造函数 直接分配16空间)
        StringBuffer stringBuffer = new StringBuffer("Hello");

        System.out.println(stringBuffer);
        System.out.println("length= " + stringBuffer.length());
        System.out.println("capacity= " + stringBuffer.capacity());

        //初始化之后手动设置capacity的值（实际分配值可能比设置的值大)
        stringBuffer.ensureCapacity(1024);
        System.out.println("capacity= " + stringBuffer.capacity());

        //setLength 使用来截断字符串长度 或者增加长度（多余的会添加null)
        stringBuffer.setLength(10);
        System.out.println("length= " + stringBuffer.length());
        System.out.println(stringBuffer.toString() + ":");
        stringBuffer.setLength(3);
        System.out.println("length= " + stringBuffer.length());
        System.out.println(stringBuffer + ":");

        //        stringBuffer.setCharAt(1, (char)340000000);
        //

        //append  (int) (obj) append是其String形式， 本质是调用String.valueOf
        //        String.valueOf(33);
        stringBuffer.append(31);
        stringBuffer.append("xx");

        //insert reverse

    }

    @Test
    public void testSbInsertReverse() {
        StringBuffer sb = new StringBuffer("I  java");
        sb.insert(2, "like");
        System.out.println(sb);

        System.out.println(sb.reverse());
        //other
//        sb.replace()
//        sb.delete();
    }

}

