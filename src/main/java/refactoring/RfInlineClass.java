package refactoring;

/**
 *  一个类并没有做太多事情，将这个类里的所有feature放到另外的类里面并把这个类删掉。
 *  通常是重构之后，原来的类剩下的部分不值得再占用一个类了。
 *
 *
 *  Mechanics
 *  1 在要移动的目标类中声明原有类的方法，将这些方法代理到原有类
 *      如果一个分离接口针对原有类方法是有意义的话，首先进行{@link RfExtractInterface}
 *  2 将原来对source的引用切换到目标类上来
 *
 *  3 使用 {@link RfMoveMethod} 和{@link RfMoveField} 把source的所有特性都移到 目标类来
 *  4
 *
 * @author szd1007@github.com
 * @date 2019-02-27 09:28
 */
public class RfInlineClass {

}
