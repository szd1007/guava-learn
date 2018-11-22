package thecompletereferenc;

import org.junit.Test;

/**
 * 类型包装器
 * @author shangzhidong@zhuanzhuan.com
 * @date 2018-11-21 13:32
 */
public class javaLangTypeWrappers {


    @Test
    public void demoIsInfiniteAndIsNaN() {
        //valueOf 是jdk9之后推荐写法
        Double d1 = Double.valueOf(1 / 0.);

        Double d2 = Double.valueOf(0 / 0.);

        System.out.println(d1 + ":" + d1.isInfinite() + "," + d1.isNaN());
        System.out.println(d2 + ":" + d2.isInfinite() + "," + d2.isNaN());

    }

    @Test
    public void testStringConversion() {
        int num = 1024;
        System.out.println(num + " in binary: " + Integer.toBinaryString(num));
        System.out.println(num + " in octal: " + Integer.toOctalString(num));
        System.out.println(num + " in hexadecimal: " + Integer.toHexString(num));

        String str = "1024";

        //返回是int 原生类型
        num = Integer.parseInt(str);

        //先调用parseInt  然后再调用valueOf（int） 。返回值是Integer
        num = Integer.valueOf(str);

    }
}


