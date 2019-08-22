import effectiveJava.EfLanguagePoints;

import java.io.*;
import java.rmi.server.ExportException;

/**
 * 单例模式序列化问题
 */
public class SingletonSerializeTest {
    public static void main(String[] args) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tempFile"));
        oos.writeObject(Singleton.getInstance());

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("tempFile")));
        Singleton newInstance = (Singleton) ois.readObject();

        System.out.println(newInstance == Singleton.getInstance());
    }
}

class Singleton implements Serializable{
    private static class SingletonHolder{
        private static Singleton INSTANCE= new Singleton();
    }
    public static Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }
    @EfLanguagePoints("如果不重写这个方法，序列化会通过反射生成一个新对象")
    private Object readResolve(){
        return SingletonHolder.INSTANCE;
    }
}
