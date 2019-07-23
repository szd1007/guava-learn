package designPattern.chp3_createional_patterns;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * 单例模式
 *  1 意图 保证一个类仅有一个实例，并提供一个访问它的全局访问点。
 *  3 适用性
 *     当类只能有一个实例而且客户可以从一个众所周知的访问点访问它时。
 *     当这个唯一实例应该是通过子类化可扩展的，并且客户应该无需更改代码就能使用一个扩展的实例时。
 *  5 参与者
 *    singleton  定义一个instance操作，允许客户访问它的唯一实例。
 *                同时可能负责创建它自己的唯一实例。
 *  6 协作
 *    客户只能通过Singleton的Instance操作访问一个singleton多实例。
 *
 *  7 效果
 *    1） 对唯一实例的受控访问
 *    2） 缩小命名空间
 *    3） 允许对操作和表示的精化
 *     #### 可以有singleton的子类，用这个扩展类的实例来配置应用。可以运行时配置应用
 *    4） 允许可变数目的实例
 *    5） 比类操作更灵活
 *
 *  相关模式
 *  n 多模式都可以使用singleton模式来实现。参见abstractFactory  builder  prototype
 */
public class aSingleton35 {

    private static class InstanceHolder{
        private static final aSingleton35 INSTANCE = new aSingleton35();
    }

    public static aSingleton35 instance() {
        return InstanceHolder.INSTANCE;
    }


    //同时 instance可能有多个子类实现，我们可以将对象选择代码放到这个方法体中。

    public static aSingleton35 instance2(){
//        if is null
//        String lookName = getEnv("SING");
//        if(xx.equals "''")
//        return  x;
//        else
//            return y
        return null;
    }

}

/**
 * 枚举单例
 */
enum AenumSingleton{
    INSTANCE;

    public void doSomeThing(){}
}


