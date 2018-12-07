package thecompletereferenc;

import org.junit.Test;

public class MathTest {

    public static void main(String[] args) {
        int a =1, b=2;
        //抛出异常 when overflow
        System.out.println(Math.addExact(a, b));
        long al = 111L;
        int ai = Math.toIntExact(al);
    }

    @Test
    public void testToRadiansToDegrees() {
        double theta = 120.0;
        System.out.println(theta + " degrees is " + Math.toRadians(theta) + " radians");

        theta = 1.312;
        System.out.println(theta + " radians is " + Math.toDegrees(theta) + " degrees.");

    }

    @Test
    public void testStrictMath() {
        int abs = StrictMath.abs(-1);
        System.out.println(abs);
    }
}
