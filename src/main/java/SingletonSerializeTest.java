import effectiveJava.EfLanguagePoints;
import thecompletereferenc.DateTest;

import java.io.*;
import java.rmi.server.ExportException;

/**
 * 单例模式序列化问题
 */
//@EfLanguagePoints("序列化机制中，类内部成员变量如果是静态变量不会初始化")
//@EfLanguagePoints("反序列化过程中，类内部静态基本类型会读jvm缓存， 如果是类对象，则重新生成[通过反射机制]")
@EfLanguagePoints("readResolve 解决单例序列化生成新对象的问题，同一个jvm内")
public class SingletonSerializeTest {
    public static void main(String[] args) throws Exception {
        @EfLanguagePoints("类内部的静态成员变量不会被序列化，如果jvm没有关闭，会加载缓存")
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tempFile"));
        Singleton.getInstance2().setStaticInt(100);
        Singleton.getInstance2().setName("333");
        oos.writeObject(Singleton.getInstance2());

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("tempFile")));
        Singleton newInstance = (Singleton) ois.readObject();

        System.out.println(newInstance == Singleton.getInstance2());
        System.out.println("new "+newInstance);
        System.out.println(" "+Singleton.getInstance2());
    }
}

class Singleton implements Serializable{
     private static int staticInt ;
     private String name ;

     private static  Singleton singletonField;



    public static int getStaticInt() {
        return staticInt;
    }

    public static void setStaticInt(int staticInt) {
        Singleton.staticInt = staticInt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Singleton(){
    }

    @Override
    public String toString() {
        return "staticInt:"+staticInt+"::name:"+name +"singleObj:"+this.hashCode();
    }

    private static class SingletonHolder{
        private static Singleton INSTANCE= new Singleton();
    }
    public static Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }
    @EfLanguagePoints("仅仅做示范")
    public static Singleton getInstance2(){
        if(singletonField==null){
            singletonField = new Singleton();
        }
        return singletonField;
    }
    @EfLanguagePoints("如果不重写这个方法，序列化会通过反射生成一个新对象")
    private Object readResolve(){
//        return SingletonHolder.INSTANCE;
        return singletonField;
    }
}
