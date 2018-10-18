package thecompletereferenc;

public class FinalTest {


    static class P {
        int a;
        int b;
    }

    void test( final  P p){
        p.a = 1;
    }
    //error
//    void test(final String s){
//        s = "xx";
//    }
    void test( String b){
        b = "xxx";
    }
    public static void main(String[] args) {
        P p = new P();
        new FinalTest().test(p);
        String b = "cc";
        new FinalTest().test(b);
        System.out.println(b);
    }

}
