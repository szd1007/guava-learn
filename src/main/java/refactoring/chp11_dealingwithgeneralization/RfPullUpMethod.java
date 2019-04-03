package refactoring.chp11_dealingwithgeneralization;

/**
 * 当在子类中有通用的方法。将这些方法抽样到父类之中。
 *
 * 有时候两个方法大部分逻辑一致，但是略有差别。 {@link RfFormTemplateMethod}
 *
 * Mechanics
 * 1. 检查方法确保是可抽离的通用方法
 * 2. 可能会有不同的方法访问级别，修改成统一访问符。提到父类中
 * 3. 如果调用了子类的方法，声明abstract。 如果用到了子类的属性，那么pullUpField 或者 {@link refactoring.RfEncapsulateField}
 */
public class RfPullUpMethod {

}
