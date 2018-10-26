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
        divideByZero();
    }

    public static void divideByZero(){

        try {
            int d = 0;
            d = d/0;
        } catch (ArithmeticException e){
            System.out.println("arithmetic ex");
        } catch (java.lang.Exception e) {
            System.out.println("ex");
            e.printStackTrace();
        }
    }
}
