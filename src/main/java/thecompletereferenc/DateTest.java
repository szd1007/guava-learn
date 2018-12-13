package thecompletereferenc;

import org.junit.Test;

import java.util.*;

/**
 * @author shangzhidong@zhuanzhuan.com
 * @date 2018-12-13 13:10
 */
public class DateTest {

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);

        long msec = date.getTime();
        System.out.println("Milliseconds since Jan. 1, 1970 GMT =" + msec);

    }

    @Test
    public void testGregorianCalendar() {
        Calendar calendar = new GregorianCalendar();



        TimeZone timeZone = TimeZone.getDefault();
        System.out.println(timeZone);
        System.out.println("id" + timeZone.getID());
        TimeZone simple = new SimpleTimeZone(timeZone.getRawOffset(), timeZone.getID());
        System.out.println("simple " + simple);
    }

    @Test
    public void testLocale() {
//        Locale locale = Locale.CHINA;
        Locale locale = Locale.getDefault();
        System.out.println(locale.getDisplayCountry());
        System.out.println(locale.getCountry());
        System.out.println(locale.getDisplayLanguage());
        System.out.println(locale.getDisplayName());

        System.out.println();
        System.out.println("languageTag " + locale.toLanguageTag());

    }
}
