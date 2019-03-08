package refactoring;

/**
 *  如果在你的类中存在不变的类型码，并且这个类型码会应影响这个类的行为的时候
 *
 *  为这个类型生成对应的子类（每个类有各自的行为逻辑,用多态的方式来包装）
 *
 * 如果不改变行为的话，用 {@link RfReplaceTypeCodeWithClass}
 *
 *  Motivation：
 *   通常这样的情况暗示代码中有switch或者if else语句块（烂代码），需要{@link RfReplaceConditionalWithPolymorphism}
 *
 *
 *   Mechanics
 *   1. 自封装类型码
 *      如果类型码是传递到了构造函数中，那么你要把构造函数替换成一个工厂方法
 *   2. 为每个typeCode的值创建一个子类。在子类重写get方法返回对应的值
 *      中间过度状态， 类似ENGINEER子类 返回int 0
 *   3. 从父类中
 *  Employee 类
 *  ENGINEER :int
 *  SALESMAN :int
 *  type : int
 *  \\\\\\\\\\
 *  ENGINEER 和 SALESMAN 各自抽出类来封装各自的行为。
 *
 * @author shangzhidong@zhuanzhuan.com
 * @date 2019-03-08 11:21
 */
public class RfReplaceTypeCodeWithSubclasses {

}
