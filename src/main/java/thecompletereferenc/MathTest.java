package thecompletereferenc;

public class MathTest {

    public static void main(String[] args) {
        int a =1, b=2;
        //抛出异常 when overflow
        System.out.println(Math.addExact(a, b));
    }
}
