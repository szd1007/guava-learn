package refactoring.chp10_makingMethodCallsSimpler;

/**
 * 你想做一些复杂创建对象的操作的时候。
 * 将构造器替换成工厂方法(类似单例，直接将工厂方法放到对应的类中)
 *
 *
 * 如果一个父类创建要依靠子类的type值，来返回不同的子类实例的时候。
 * 没法通过构造函数来获取。因为构造函数只能获取对应关联的类
 * Employee(int type){
 *     this.type = type;
 * }
 * ---------------------------------------
 * static Employee create(int type) {
 *     return new Employee(type);
 * }
 *
 * @author szd1007@github.com
 * @date 2019-03-28 13:32
 *
 * 参考代码
 * @see refactoring.RfReplaceTypeCodeWithSubclasses  After#create
 */
public class RfReplaceConstrucotrWithFactoryMethod {

}
