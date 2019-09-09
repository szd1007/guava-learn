package thecompletereferenc;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.DoubleSummaryStatistics;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author szd1007@github.com
 * @date 2018-12-17 13:42
 */
public class ResourceBundleTest {

    public static void main(String[] args) {
        /* 方式1  ListResourceBundle
         *国际化放到配置类中，通过类名的后缀(_language_country)来确定具体的本地化配置类
         * 文案配置做到国际化，这种方式就可以。
         *
         */
        //        ResourceBundle bundle = ResourceBundle.getBundle("sun.security.util.AuthResources");
        //        ResourceBundle bundle = ResourceBundle.getBundle("sun.security.util.AuthResources", Locale.CHINA);
        ResourceBundle bundle = ResourceBundle.getBundle("sun.security.util.AuthResources", Locale.GERMAN);

        System.out.println(bundle.getString("invalid.null.input.value"));

        ResourceBundle rd = ResourceBundle.getBundle("thecompletereferenc.SampleRB", Locale.ENGLISH);
        System.out.println("English version");
        System.out.println("title " + rd.getString("title"));
        System.out.println("Stop " + rd.getString("StopText"));
        System.out.println("Start " +rd.getString("StartText"));

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>\n");
        rd = ResourceBundle.getBundle("thecompletereferenc.SampleRB", Locale.CHINA);
        System.out.println("中文版本 ");
        System.out.println("title " + rd.getString("title"));
        System.out.println("Stop " + rd.getString("StopText"));
        System.out.println("Start " +rd.getString("StartText"));

    }

    /**
     * 方式2 通过配置文件的方式， 实现国际化。 spring国际化配置
     */
    @Test
    public void testByProperties() throws UnsupportedEncodingException {
//        ResourceBundle bundle = ResourceBundle.getBundle("i18ntest", Locale.ENGLISH);
        ResourceBundle bundle = ResourceBundle.getBundle("i18ntest", Locale.CHINA);
        //中文乱码解决， 使用unicode替代中文
        String name = bundle.getString("name");
        System.out.println(name);

        //中文乱码   读取过程中转换成具体编码
        String encodeName = new String(bundle.getString("encodeName").getBytes("ISO-8859-1"), "UTF-8");
        System.out.println(encodeName);
    }

}
