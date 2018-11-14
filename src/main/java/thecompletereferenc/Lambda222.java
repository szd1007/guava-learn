package thecompletereferenc;

/**
 * @author shangzhidong@zhuanzhuan.com
 * @date 2018-11-14 13:36
 */
public class Lambda222 {

}

//Constructors References
// classname::new
@FunctionalInterface
interface MyFunc222{
    MyClass22 func(int n);
}
class MyClass22 {
    private int val;

    MyClass22(int val) {
        this.val = val;
    }
    MyClass22(){}
    int getVal(){
        return val;
    }
}
class ConstructorRefDemo {

    public static void main(String[] args) {
        MyFunc222 myFunc222 = MyClass22::new;

        //创建对象1。可以当作工厂方法来用
        MyClass22 obj1 = myFunc222.func(1);
        //创建对象2
        MyClass22 obj2 = myFunc222.func(2);

        System.out.println(obj1);
        System.out.println(obj2);
    }
}
