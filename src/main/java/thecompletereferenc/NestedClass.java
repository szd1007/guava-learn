package thecompletereferenc;

public class NestedClass {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.test();
//        new NestedClass().test(1);
        // inner can be created only in the context of out
       // Outer.Inner inner = new Outer.Inner();
    }
    void test (int ... v){}
    void test (int a, int ... v){}
}
class Outer {
    private int out_x =1;

    public void test(){
        Inner inner = new Inner();
        inner.disp();
    }

    class Inner {
        public void disp(){
            System.out.println("outX: "+out_x);
        }
    }
}