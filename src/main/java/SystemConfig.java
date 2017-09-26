import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by shangzhidong on 2017/9/25.
 */
public class SystemConfig {
    private static boolean flag ;
    private static Properties properties;
    static {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().
            getResourceAsStream("system.conf");
        try {
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        flag = Boolean.parseBoolean(properties.getProperty("flag", "false"));
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println(flag);
    }
}
