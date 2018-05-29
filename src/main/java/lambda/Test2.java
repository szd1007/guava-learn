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
        System.out.println(new Test2().getClass().getName());
        doSomthing(new DoStuff() {

            @Override public boolean isGood(int value) {
                return value == 41;
            }
        });
        doSomthing(answer -> answer == 41);


    }


}
