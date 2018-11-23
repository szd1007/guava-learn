package thecompletereferenc;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * @author shangzhidong@zhuanzhuan.com
 * @date 2018-11-23 09:55
 */
public class SystemTest {
    static byte a[] = { 65, 66, 67, 68, 69 };
    static byte b[] = { 77, 77, 77, 77, 77 };
    /**
     * 重定向
     */
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream p = new PrintStream(new File("out.txt"));
        System.setOut(p);
        System.out.println("hello world");

    }

    @Test
    public void useArrayCopyTest() {
        System.out.println("a = " + new String(a));
        System.out.println("b = " + new String(b));
        /*
           shallow copy 基本类型复制值， 对象复制引用(数组存放的就是对象引用）
         */
        System.arraycopy(a, 0, b, 0, a.length);
        b[0] = 77;
        System.out.println("a = " + new String(a));
        System.out.println("b = " + new String(b));
        System.arraycopy(a, 0, a, 1, a.length - 1);
        System.arraycopy(b, 1, b, 0, b.length - 1);
        System.out.println("a = " + new String(a));
        System.out.println("b = " + new String(b));
    }
}
