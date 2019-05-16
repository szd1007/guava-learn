package designPattern.chp3_createional_patterns;

/**
 * @author shangzhidong@zhuanzhuan.com
 * @date 2019-05-16 14:59
 *
 * 抽象工厂
 *
 * 1 意图
 *   提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类。
 * 2 别名 （kit）
 *
 * 4 适用性
 *   一个系统要独立于它的产品创建、组合和表示时。
 *   一个系统要由多个产品系列中的一个来配置时。（thrift）
 *   当你要强调一系列相关的产品对象的设计以便进行联合使用时。
 *   当你提供一个产品类库，而只想显示他们嫩的接口而不是实现时。
 *
 *  6参与者
 *   abstractFactory   声明一个创建爱你抽象产品的操作接口(接口)
 *   concreteFactory   实现创建具体产品对象的操作（impl）
 *   AbstractProduct   为每一类产品对象声明一个接口（接口）
 *   ConcreteProduct   定义并实现一个应用于具体创建工厂的产品对象（impl）
 *   Client            仅仅使用AbstractFactory 和AbstractProduct类声明的接口(基于接口编程)
 *
 *  7协作  运行时创建具体的工厂实例，通过abstractFactory将对象创建延迟到了子类
 *  8效果
 *    分离具体的类      将产品实现类与client隔离，client通过接口与产品交互
 *    易于交换产品系列   工厂示例只会初始化一次，通过更换具体工厂实例就可以很容易的实现产品线的切换。
 *    有利于产品一致性   一个具体的产品只能应用于同一系列的工厂中
 *    难以支持新种类产品  abstractFactory封装了所有的产品接口，在添加新产品的同时要扩展所有的工厂子类。
 *
 *  9 实现
 *
 */
public class AbstractFactory31 {

}
