package thecompletereferenc;

import org.junit.Test;
import util.TimeUtil;

import javax.annotation.processing.SupportedAnnotationTypes;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
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

    /**
     * 新版本 time  date时间处理函数 ,jdk 1.8提供
     */

    @Test
    public void testLocalDateTime() {
        LocalDateTime dateTime  = LocalDateTime.now();
        System.out.println(dateTime);
        //DateTimeFormatter thread safe+

        //使用预先提供的样式,可能会因为时区问题出错， dateTime不包含时区
//        System.out.println(dateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.FULL)));
        System.out.println(dateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG, FormatStyle.LONG)));
        //ISO 定义的formater
        System.out.println("iso 预定义");
        System.out.println("iso>>> " + dateTime.format(DateTimeFormatter.ISO_DATE_TIME));
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        //使用预先提供的样式,可能会因为时区问题出错， dateTime不包含时区
        System.out.println(zonedDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.FULL)));

        //自定义方式 单引号内部原样输出。bestPractice  非匹配字符都添加单引号。防止后续版本添加字段影响已有逻辑
        System.out.println(dateTime.format(DateTimeFormatter.ofPattern("YYYY'-'MM  HH':'MM':M'SS MMMM")));

    }

    @Test
    public void testBaseNew() {
        System.out.println(LocalDate.now());
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
        System.out.println(LocalDate.now().format(DateTimeFormatter.ISO_DATE));
        System.out.println(LocalTime.now());
        System.out.println(LocalTime.now().format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)));
    }

    @Test
    public void testTimeParse() {
//        DateTimeFormatter threadSafeFormatter = DateTimeFormatter.ofPattern("M d',' yyyy hh':'mm a");
        DateTimeFormatter threadSafeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime curDateTime = LocalDateTime.parse("2017-12-01 18:22:00",threadSafeFormatter);
        System.out.println(curDateTime);
        //使用默认时区和TimeUtil转换的一样 东8时区
        System.out.println(curDateTime.atZone(ZoneOffset.ofHours(8)).toInstant().toEpochMilli());
        System.out.println(TimeUtil.getTime("2017-12-01 18:22:00"));
        //revert
        curDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(1512123720000L), ZoneOffset.ofHours(8));
        System.out.println("default zone " + threadSafeFormatter.format(curDateTime));

        System.out.println(">>>>>>>>>>>>\r\n");
        System.out.println(">>>>>>current:");
        //revert
        curDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()), ZoneOffset.ofHours(8));
        System.out.println(" zone " + threadSafeFormatter.format(curDateTime));
        System.out.println(TimeUtil.getTime(System.currentTimeMillis()));

    }

    @Test
    public void testTimeZone() {
        System.out.println(ZoneOffset.UTC);
        System.out.println(ZoneId.systemDefault());
        System.out.println(ZoneOffset.ofHours(8));

        System.out.println("###>>>>");
        System.out.println(System.currentTimeMillis());
        System.out.println(LocalDateTime.now().toInstant(ZoneOffset.ofHours(8)).toEpochMilli());
        //获取东一区现在的时间，然后转换时按照东8区去转换，所以会出错
        System.out.println(LocalDateTime.now(ZoneOffset.ofHours(1)).toInstant(ZoneOffset.ofHours(1)).toEpochMilli());

        System.out.println(LocalDateTime.now(ZoneOffset.ofHours(1)).toInstant(ZoneOffset.ofHours(8)).toEpochMilli());

        //        System.out.println(LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli());

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>\r\n");
        System.out.println(Instant.now(Clock.system(ZoneOffset.ofHours(2))).toEpochMilli());
        System.out.println(Instant.now(Clock.system(ZoneOffset.ofHours(2))).atZone(ZoneOffset.ofHours(2)));
        System.out.println(Instant.now(Clock.system(ZoneOffset.ofHours(8))).toEpochMilli());
        System.out.println(Instant.now(Clock.system(ZoneOffset.ofHours(8))).atZone(ZoneOffset.ofHours(8)));
        System.out.println(Instant.now(Clock.system(ZoneOffset.ofHours(2))).atZone(ZoneOffset.ofHours(8)));
        //todo ???
        //获取东一区现在的时间，然后转换时按照东8区去转换，所以会出错
        System.out.println("error trans");
        LocalDateTime time = LocalDateTime.now(ZoneOffset.ofHours(1));
        System.out.println("东1区时间：" + time);
//        System.out.println("时间戳: "+time);
        System.out.println(" 转成东1区: "+time.toInstant(ZoneOffset.ofHours(1)));
        System.out.println("转换成东８区: " + time.toInstant(ZoneOffset.ofHours(8)));
    }
    @Test
    public void testDuration() {
        Duration duration = Duration.parse("PT1.345S");
        System.out.println(duration.toMillis());

    }

    @Test
    public void normalUse(){
        LocalDateTime localDateTime  = LocalDateTime.now();
        //本月最后一天
        LocalDateTime lastDay = localDateTime.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastDay);

        System.out.println(localDateTime.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println("本月第2天");
        System.out.println(localDateTime.withDayOfMonth(2));
    }



}
