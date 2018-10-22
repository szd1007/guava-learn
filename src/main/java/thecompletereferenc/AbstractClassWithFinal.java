package thecompletereferenc;

public class AbstractClassWithFinal {

    public static void main(String[] args) {
        A a ;
        a = new B();
        a.hello();
        a = new C();
        a.hello();

    }
}



abstract class A {
    abstract void hello();
}
final class B extends A{
    @Override
    void hello() {
        System.out.println("hello B");
    }
}

class C extends A{
    @Override
    void hello() {
        System.out.println("hello C");
    }
    final void finalMethod(){
        System.out.println("final can't be override");
    }
}

class D extends C{

    @Override
    void hello() {
        super.hello();
    }

    //Using final to prevent Overriding
//    @Override
//    void finalMethod() {
//        super.finalMethod();
//    }
}

//Using final to prevent inheritance
//class E extends B{
//
//}
