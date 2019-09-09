package thecompletereferenc;

import java.util.StringTokenizer;

/**
 * @author szd1007@github.com
 * @date 2018-12-12 13:25
 */
public class StringTokenizerTest {

    static String in = "title=Java: The Complete Reference;"
            + "author= Schildt;"
            + "publisher=Oracle Press;"
            + "copyright=2018";

    public static void main(String[] args) {
        StringTokenizer st = new StringTokenizer(in, "=;");
        while (st.hasMoreTokens()) {
            String key = st.nextToken();
            String value = st.nextToken();
            System.out.println(key + "\t" + value);
        }

    }
}
