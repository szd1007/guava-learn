package thecompletereferenc;

import effectiveJava.EfLanguagePoints;

import java.io.*;

class MySeClass implements Serializable{
//    class MySeClass implements Externalizable{
    String s;
    int i;
    double d;

    public MySeClass(String s, int i, double d) {
        this.s = s;
        this.i = i;
        this.d = d;
    }

    public MySeClass() {

    }
    @Override
    public String toString() {
        return "s=" + s + "; i=" + i + "; d=" + d;
    }


    //自定义序列化反序列化方法
    private void readObject(ObjectInputStream aInputStream) throws ClassNotFoundException, IOException
    {
        System.out.println("execute custom readObj");
        s = aInputStream.readUTF();
        i = aInputStream.readInt();
        d = aInputStream.readDouble();
    }

    private void writeObject(ObjectOutputStream aOutputStream) throws IOException
    {
        System.out.println("execute custom writeObj");
        aOutputStream.writeUTF(s);
        aOutputStream.writeInt(i+100);
        aOutputStream.writeDouble(d);
    }

//    @Override
//    public void writeExternal(ObjectOutput out) throws IOException {
//        System.out.println("external execute custom writeObj");
//        out.writeUTF(s);
//        out.writeInt(i+100);
//        out.writeDouble(d);
//    }
//
//    @Override
//    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
//        System.out.println("external execute custom writeObj");
//        s = in.readUTF();
//        i = in.readInt();
//        d = in.readDouble();
//    }
}
public class SerializableTest {

    public static void main(String[] args) {
        //object serializable

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("serial"))) {
            MySeClass o1 = new MySeClass("Hello", -7, 2.7e10);
            System.out.println("object1: " + o1);
            objectOutputStream.writeObject(o1);

        } catch (IOException e) {
            System.out.println("Error during serialization: " + e);
        }

        //obj deserialization
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("serial"))) {
            MySeClass ob2 = (MySeClass) objectInputStream.readObject();
            System.out.println("object2: " + ob2);
        } catch (Exception e) {
            System.out.println("Exception during deserialization: " + e);
        }
    }
}
@EfLanguagePoints
class ElvisSingleton{
    @EfLanguagePoints("另外一点，静态成员变量不会被序列化。 在反序列化中当前的jvm会从类对象中" +
            "获取这个值。序列化只会对堆内存区域进行")
    private static final ElvisSingleton SINGLETON = new ElvisSingleton();

    public static ElvisSingleton getSingleton(){
        return SINGLETON;
    }

    @EfLanguagePoints("readResolve 方法  防止单例序列化反序列化产生新的对象" +
            "主要是防止懒加载过程中使用的非静态变量引用")
    private Object readResolve(){
        return SINGLETON;
    }
}