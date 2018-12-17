package thecompletereferenc;

import java.util.ResourceBundle;

/**
 * @author shangzhidong@zhuanzhuan.com
 * @date 2018-12-17 13:42
 */
public class ResourceBundleTest {

    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("sun.security.util.AuthResources");

        System.out.println(bundle.getString("invalid.null.input.value"));

    }

}
