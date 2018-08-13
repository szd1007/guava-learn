package lambda;

import com.sun.istack.internal.NotNull;

public class Test2 {

//    @FunctionalInterface
    interface DoStuff{
        boolean isGood(int value);

        default void xx(int b) {
            System.out.println(b);
        }

    }

    static void doSomthing( DoStuff stuff) {
        System.out.println(stuff.isGood(41));
        System.out.println(stuff.isGood(22));
    }
    public static void main(String[] args) {
        String sql = "update a = a";
        int a = 1;
        int b = -2;
        String x1 = sql + a;
        String x2 = sql + b;
        System.out.println(x1);
        System.out.println(x2);
    }


}
