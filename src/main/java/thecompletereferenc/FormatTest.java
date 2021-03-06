package thecompletereferenc;


import org.junit.Test;

import java.text.Normalizer;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;

public class FormatTest {
    private static final Formatter fsmt = new Formatter(System.out);
    public static void main(String[] args) {
        Formatter fmt = new Formatter();

        fmt.format("Fomatting %s is easy %d %.2f", "with Java", 10, 98.6);

        System.out.println(fmt);
        fmt.close();
    }

    @Test
    public void testOutput() {
        /* 设置stdout 格式化输出
         */
        Formatter formatter = new Formatter(System.out);
        formatter.format(" out %s", "hehe");
//        formatter.flush();
    }

    @Test
    public void testFormatFloat() {
        Formatter fmt = new Formatter();

        for (double i=1.23; i < 1.0e+6; i *= 100) {
            System.out.println("====");
            fmt.format("%f || %e ->>", i, i);
            System.out.println(fmt);
        }
        fmt.close();
    }

    @Test
    public void testFormatTimeAndDate() {
//        Date date = new Date();
//        Formatter fmt = new Formatter();
//        fmt.format("%tr", date);
//        fmt.format("|%tM|", date.getTime());
//        System.out.println(fmt);
        Formatter fmt = new Formatter(System.out);
        Calendar cal = Calendar.getInstance();
        //display standard 12-hour time format.
        fmt.format("%tr\n", cal);

        //display just hour and minute.
        fmt.format("%tl:%tM\n", cal, cal);

        //display month by name and number.
        fmt.format("%tB %tb %tm\n", cal, cal, cal);
    }

    @Test
    public void testSkipFormat() {
        Formatter fmt = new Formatter(System.out);
        fmt.format("Copying file%nTransfer is %d%% complete", 88);
    }

    @Test
    public void testMinimumFiledWidth() {
        Formatter fmt = new Formatter(System.out);
        fmt.format(" |%f|%n|%12f|%n|%012.3f|",
                10.12345, 10.12345, 10.12345);
    }

    @Test
    public void testFieldWidthDemo() {
        Formatter fmt = new Formatter(System.out);
        for (int i = 1; i < 10; i++) {
            fmt.format("%4d %4d %4d%n", i, i*i, i*i*i);
        }
    }

    @Test
    public void testPrecisionDemo() {
        Formatter fmt = new Formatter(System.out);
        //format 4 decimal places.
        fmt.format("%.4f%n", 123.1234567);

        //format to 2 decimal places in a 16 character field
        fmt.format("%16.2e%n", 123.1234567);

        //display at most 15 characters in a string .
        fmt.format("%.15s%n", "Formatting with Java is now easy.");

    }

    @Test
    public void testLeftJustify() {

        //right justify default
        fsmt.format("|%10.2f|\n", 123.123);

        //now left justify
        fsmt.format("|%-10.2f|\n", 123.123);

        //cause a + flag to be shown before a positive number
        fsmt.format("|%-10.2f|\n", 123.123);
    }

    @Test
    public void testSpace() {
        fsmt.format("% d\n", 100);
        fsmt.format("% d\n", -200);
        fsmt.format("%+d\n", 300);
        fsmt.format("%d", -400);
    }

    @Test
    public void testCommaFlag() {
        fsmt.format("%,d\n", 123456789);
        fsmt.format("%,.2f\n", 42342355252.23424);

        fsmt.format("%#X\n", 250);
        fsmt.format("%X\n", 250);
        fsmt.format("%x\n", 250);

        //指定参数位置 1$ 指定是第一个参数
        fsmt.format("%d in hex is %1$x\n", 255);
    }

    @Test
    public void testRelativeIndex() {
        //< 表示前面用到过的参数
        Calendar cal = Calendar.getInstance();
        fsmt.format("Today is day %te of %<tB, %<tY", cal);
    }

    @Test
    public void testTryWithResource() {
        try (Formatter fmt = new Formatter()) {
            fmt.format("auto close %s is easy ", "Java");
            System.out.println(fmt);
        }
    }

    @Test
    public void testPrintf() {
        System.out.println("Here are some numeric values in different formats. \n");
        System.out.printf("Various integer formats: ");
        System.out.printf("%d %(d %+d %05d\n", 3, -3, 3, 3);
        System.out.println();
        System.out.printf("%+,.2f\n%+,.2f\n", 1234567.123, -1234567.123);
        System.out.println();
        System.out.printf("% ,.2f\n% ,.2f\n", 1234567.123, -1234567.123);

    }

}
