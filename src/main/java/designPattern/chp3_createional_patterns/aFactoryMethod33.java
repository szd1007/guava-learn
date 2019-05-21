package designPattern.chp3_createional_patterns;

/**
 * 工厂方法（别名  虚构造器 virtual constructor）
 *  定义一个用于创建对象的接口，让子类决定实例化哪一个类。 使类的实例化推迟到子类。
 *
 *  适用性：
 *    当一个类不知道它必须创建的对象的类的时候。（默认有个类实现，但是子类可以根据情况重写实现不同类的初始化）
 *    当一个类希望由它的子类来指定它所创建的对象的时候
 *    当类将创建对象的职责委托给多个帮助子类中的某一个，且你希望将哪一个帮助子类是代理者这一信息局部化的时候。
 *
 *  参与者：
 *     Product： 定义工厂方法所创建对象的接口
 *     ConcreteProduct: product接口实现
 *     Creator： 声明的工厂方法，用来创建product对象。可以有一个缺省实现
 *     ConcreteCreator: 工厂方法的一个具体实现
 *
 *   效果；
 *      为子类提供hook， factorymethod给子类一个挂钩已提供对象的扩展版本
 *      连接平行的类层次（一一对应的类，）
 *
 *    相关模式：
 *    templateMethod 中经常会用到factoryMethod
 *    abstractFactory 中会用到工厂方法
 *
 */
public class aFactoryMethod33 {
}
