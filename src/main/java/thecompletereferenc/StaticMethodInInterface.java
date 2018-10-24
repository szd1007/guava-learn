package thecompletereferenc;

public class StaticMethodInInterface {
    public static void main(String[] args) {
        Ssa.printDefault();
    }
}


interface Ssa{
    /**
     * 接口中的静态方法可以直接调用
     * static method in interface not inherited by either an implementing class or a subInterface
     */
    static void printDefault(){
        System.out.println("print default");
    }

    //jdk9 开始支持private关键字
    //private void a();
}