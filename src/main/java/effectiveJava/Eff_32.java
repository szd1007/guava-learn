package effectiveJava;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 32. 谨慎并用泛型和可变参数
 */
public class Eff_32 {

    static <T> T[] pickTwo(T a, T b, T c) {
        switch (ThreadLocalRandom.current().nextInt(3)) {
            case 0:{
                return toArray(a,c);
            }
            case 1:{
                return toArray(a,b);
            }
            case 2:{
                return toArray(c,b);
            }
        }
        throw new AssertionError();//can't be here
    }

    private static <T> T[] toArray(T ... args) {
        return args;
    }

    public static void main(String[] args) {
        String[] attributes = pickTwo("Good", "Fast", "Cheap");
    }
}
