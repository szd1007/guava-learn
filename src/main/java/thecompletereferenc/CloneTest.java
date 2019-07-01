package thecompletereferenc;

import effectiveJava.EfLanguagePoints;

/**
 * when clone is made, constructor for the obj being cloned is not called.
 * As implemented by obj,
 * !!!a clone is simply an exact copy of the original
 * 复制的对象是完全复制一份， 对象内部的引用也只是复制引用而已，肯定不会把对象引用实例重新创建一遍
 * <p>
 * 条件， 要实现Cloneable接口
 *
 * it is easy to think that a class is safe for cloning when it actually is not
 * 很容易能想像一个类是clone安全的，如果这个类就不支持clone
 */
@EfLanguagePoints("复制功能最好由构造器或者工厂提供，唯一例外时数组【存储基本数据类型】")
public class CloneTest implements Cloneable {
    int a;
    double b;
    Long ccc;
    @EfLanguagePoints("clone 是浅拷贝， 引用要递归调用clone方法")
    int[] ref;

    /**
     * clone 方式1  ，protect方法 类或内部类使用
     */
    @EfLanguagePoints("共有方法要省略异常抛出，或者变成运行时异常")
    CloneTest cTest() {
        try {
            //call clone in object.
            CloneTest cloneTest = (CloneTest) super.clone();
            cloneTest.ref = ref.clone();
            return cloneTest;
        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning not allowed.");
            throw new RuntimeException("clone error");
        }
    }



    /**
     * 方式2 更改默认修饰符 public
     * @return
     */
    @Override
    public Object clone()  {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("cloning not allowed");
            return this;
        }
    }
    @Override
    public String toString() {
        return "a="+a +"  b=" + b;

    }
}

class CloneChild extends CloneTest {
    int c;


}
class CloneDemo {
    public static void main(String[] args) {
        CloneTest x1 = new CloneTest();
        CloneTest x2 ;
        x1.a = 10;
        x1.b = 20.98;
        x1.ccc = 111L;
        x2 = x1.cTest();    //clone x1

        System.out.println(x1);
        System.out.println(x2);
        System.out.println(x1.ccc);
        x2.ccc=999L;
        System.out.println(x1.ccc);
        System.out.println(x2.ccc);
        CloneChild c1 = new CloneChild();
        c1.a = 1;
        c1.b = 2;
        c1.c = 3;

        CloneChild c2 = (CloneChild) c1.clone();
        System.out.println(c2 + "  c:" + c2.c);
    }
}