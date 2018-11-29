package thecompletereferenc;

//每个枚举类型都是一个具体的实例对象，可以有自己的对象属性和方法
public enum EnumDemo {
    A(10), B(110), C(88), D;

    private int price;  //price of each instance  每个实例对象的成员
    //constructor
    EnumDemo(int p){
        this.price = p;
    }
    //可以有多个构造函数
    EnumDemo(){
        //默认设置一个值
        this.price = -1;
    }
    int getPrice(){
        return price;
    }
    void test(){
        values();
    }
}

class  EnumDemoTest{
    public static void main(String[] args) {
        //display price of b
        System.out.println(EnumDemo.B + ": "+EnumDemo.B.getPrice());
        System.out.println(Enum.valueOf(EnumDemo.class, "A"));
    }
}