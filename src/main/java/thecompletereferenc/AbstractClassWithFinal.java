package thecompletereferenc;

import java.util.List;

public class AbstractClassWithFinal {

    public static void main(String[] args) {
//        A a ;
//        a = new B();
//        a.hello();
//        a = new C();
//        a.hello();
        Abb abb = new Abb();
        abb.getTest();
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


interface Ia{
    int a=1;
    void a();
}
class IaImpl implements Ia{
    @Override
    public void a() {

    }
}

class Aa {
    //private  default public protected
     interface IAa{
        void test();
    }
    class Aaa{
         public Aaa(){
             System.out.println("Aaa initialized");
         }
    }
    Aaa get(){return new Aaa();}
}

//Aaa 非static  只能在类内部使用
//也就是说不能脱离定义的类独立使用，但是生成后可以根据限定符返回给调用方
//class Ab extends Aa.Aaa{
//
//}

//嵌套接口是可以在外部类使用的，只要限定符没问题
class Abb implements Aa.IAa{

    @Override
    public void test() {

    }
    Aa.Aaa getTest(){

//        return new Aa.Aaa();
        return  new Aa().get();
    }
        ;
}

interface Xa{
    void a();
    void b();
}
interface Xb extends Xa{
    void c();
}
abstract class Xc implements Xb{
    @Override
    public void a() {

    }

    @Override
    public void c() {

    }
}

class Xd extends Xc{
    @Override
    public void b() {

    }
}