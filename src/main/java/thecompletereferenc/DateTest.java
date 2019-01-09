package thecompletereferenc;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

    @Test
    public void testDateFormat() {
        Date date = new Date();

        DateFormat df;

        df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.CHINA);
        System.out.println("China: " + df.format(date));

        df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.KOREA);
        System.out.println("Korea: " + df.format(date));

        df = DateFormat.getDateInstance(DateFormat.LONG, Locale.UK);
        System.out.println("United Kingdom: " + df.format(date));

        df = DateFormat.getDateInstance(DateFormat.FULL, Locale.US);
        System.out.println("United States: " + df.format(date));

    }

    @Test
    public void testTimeFormat() {
        Date date = new Date();
        DateFormat df;

        df = DateFormat.getTimeInstance(DateFormat.FULL, Locale.CHINA);
        System.out.println("China: " + df.format(date));

        df = DateFormat.getTimeInstance(DateFormat.LONG, Locale.UK);
        System.out.println("United kingdom: " + df.format(date));

        df = DateFormat.getTimeInstance(DateFormat.FULL, Locale.CANADA);
        System.out.println("Canada: " + df.format(date));
    }

    @Test
    public void testSimpleDateFormat() {
        Date date = new Date();
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat("hh:mm:ss");
        System.out.println(sdf.format(date));

        /**
         * MMM 重复三次 显示text
         * MM 两次显示2为数字
         * M 显示一位数字（如果小于10)
         */
        sdf = new SimpleDateFormat("dd MMM yyyy hh:mm:ss zzz");
        System.out.println(sdf.format(date));

        sdf = new SimpleDateFormat("E MM dd yyyy");
        System.out.println(sdf.format(date));

    }
}
