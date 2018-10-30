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
        System.out.println(returnAfterFinally());
        System.out.println(returnAfterFinallyWithObj());
        System.out.println(returnAfterFinallyObj().b);

        try {
            ChainExcDemo.demoProc();
        } catch (java.lang.NullPointerException e) {
            //display top level exception
            System.out.println("Caught: " + e);

            //display cause exception
            System.out.println("Original cause: " + e.getCause());
        }
    }

    //multiget exception
    public static void multicatchException(){
        try {
            System.out.println("do something");
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("get");
        }
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

    static int returnAfterFinally() {
        int b = 0;
        try{
            return b;
        }finally {
            b = 2;
        }
    }
    static int returnAfterFinallyWithObj() {
        Ea a = new Ea();
        try{
            a.b = 1;
            return a.b;
        }finally {
            a.b = 3;
        }
    }
    static Ea returnAfterFinallyObj() {
        Ea a = new Ea();
        try{
            a.b = 1;
            //return 的时候已经赋值， 后续不能改变这个值或者引用
            return a;
        }finally {
            a.b = 3;
            a = null;
        }
    }
}

class Ea{
    int b ;
}

//链式异常
class ChainExcDemo{
    static void demoProc(){
        //create an exception
        NullPointerException e = new NullPointerException("top layer");

        //addd a cause
        e.initCause(new ArithmeticException("cause"));
        throw e;
    }
}
