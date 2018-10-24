package thecompletereferenc;

/**
 * @author shangzhidong@zhuanzhuan.com
 * @date 2018-10-24 13:35
 *
 *    Throwable
 *    |       \
 *   |         \
 *  |           \
 * Exception    Error
 * |
 * |
 * RuntimeException
 *
 * {@code RuntimeException} and its subclasses are <em>unchecked
 * exceptions</em>.
 */
public class Exception {

    public static void main(String[] args) {
        int d = 0;
        int a = 42/d;
    }
}
