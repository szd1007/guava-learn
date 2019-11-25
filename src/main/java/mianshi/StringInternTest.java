package mianshi;

import org.junit.Test;

public class StringInternTest {

    @Test
    public void test1() {
        String s1 = new String("1") + new String("23");
        s1.intern();
        String s2 = "123";
        System.out.println(s1 == s2);
    }

    @Test
    public void test2() {
        String s1 = new String("1") + new String("23");
        String s2 = "123";
        s1 = s1.intern();
        System.out.println(s1 == s2);
    }
}
