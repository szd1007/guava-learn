package thecompletereferenc;

public class TypeWrapper {

    static void test1(int a){
        a = -1;
    }
    static void test2(Integer a){
        a=-2;
    }

    public static void main(String[] args) {
        Integer a = 0, b =1;

        test1(a);
        test2(b);
        System.out.println(a);
        System.out.println(b);
    }
}
