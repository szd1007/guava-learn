package thecompletereferenc;

public class defaultMethod {
}


interface DA{
    void a();
    //定义的时候直接使用这个方法不太好
    default void b(){
        System.out.println("common function");
    }
    //1一个接口如果不是每个实现类都使用，可以直接实现默认方法。不用子类单独实现
    //2 后续需要新增接口的时候可以使用，这样已经存在的代码不需要改变
    default void c(){
        throw new RuntimeException("method not supported");
    }
}
interface DB{
    default void c(){
        ;
    }
    default void d(){}

}
//c 继承db  所以子类DEB中的c方法会执行
interface DEB  extends DB{
    @Override
    default void c(){}
}
class DAI implements DA{
    @Override
    public void a() {

    }
}

//default 方式支持多重继承，但是不能重名.但是子类可以继承默认方法。就可以不报错了
class Dd implements DA,DB{
    @Override
    public void a() {

    }
    //可以继承默认方法
    @Override
    public void c(){
        //直接调用指定接口的默认方法；
       DA.super.c();
       DB.super.c();
    }
}