package refactoring;

/**
 * 封装集合，集合当做返回值时要和普通对象区别对待一下
 * 当一个方法返回一个集合的时候，使其返回一个只读的view。 并且提供 add/remove 方法。不提供set方法
 * 这样不用让client过多干涉set所在类内部结构
 *
 */
public class RfEncapsulateCollection {
}
