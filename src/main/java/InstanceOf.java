/**
 * 通过接口来进行类的分类，同时使用instanceOf进行分类处理
 * 指明这个对象是否是这个特定类或者是它的子类的一个实例
 * @author szd1007@github.com
 * @date 2018-05-17 13:28
 */
public class InstanceOf {

    interface A {

    }

    interface A_a extends A {

    }

    interface A_b extends A {

    }

    static class aImpl1 implements A_a {

    }

    static class aImpl2 implements A_b {

    }

    static class subA extends aImpl1 {

    }

    public static void main(String[] args) {
        A aa = new aImpl1();
        A ab = new aImpl2();
        A subA = new subA();
        System.out.println(aa instanceof A);
        System.out.println(aa instanceof A_a);
        System.out.println(aa instanceof A_b);
        System.out.println(ab instanceof A);
        System.out.println(ab instanceof A_a);
        System.out.println(ab instanceof A_b);
        System.out.println(subA instanceof A);
        System.out.println(subA instanceof A_a);
        System.out.println(subA instanceof A_b);

//        if (xx instanceof A_a) {
//            //进行处理A_a类型
//        }
    }
}
