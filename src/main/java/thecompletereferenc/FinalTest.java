package thecompletereferenc;

public class FinalTest {


    static class P {
        int a;
        int b;
    }

    void testLocalFinal(){
        final  int b;
        b =1;


        //error 局部变量只能赋值一次，后续不能更改
//        b=2;
    }
    void test( final  P p){
        p.a = 1;
    }
    //error
//    void test(final String s){
//        s = "xx";
//    }


    static class testClassField{
        final int b ;
        final int c ;
        static final int d;
        static final int e =1;
        final int f = 0;

        {
            b = 1;
            //error
//            d = 1;
        }
        static {
            d = 1;
        }

        public testClassField( ) {
             this.c = 1;
        }

    }

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
