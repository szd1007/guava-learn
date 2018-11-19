package thecompletereferenc;

import com.google.common.base.Charsets;

import java.nio.charset.Charset;

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

        //toCharArray
        char[] s_Array = s.toCharArray();

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
