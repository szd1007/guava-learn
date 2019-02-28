package refactoring;

/**
 * 你正在使用的server类需要添加一个额外方法，但是你不能修改这个类
 * 这时候用server作为第一个参数，在client创建该方法。
 *
 * Date newStart = new Date (previousEnd.getYear(), previousEnd.getMonth(), previousEnd.getDate() + 1);
 * \ \\\\\\
 * Date newStart = nextDay(previousEnd);
 * private static Date nextDay(Date arg) {
 *     return new Date (arg.getYear(), arg.getMonth(), arg.getDate() + 1);
 * }
 *
 * Motivation
 *
 *    {@link RfIntroduceLocalExtension},当有多个foreign method的时候。或者直接联系server作者添加方法
 *
 *
 *  Mechanics
 *  1. 在client创建一个method做你想做的事情
 *      这个方法不应该访问client的具体特性，如果需要具体值可以通过参数传递进来
 *  2. 将server作为第一个参数传递到method中
 *  3. 添加注释，标注该方法是一个 foreign method， 应该在server端实现
 *      这样当你后面想要移出这些foreign 方法时， 方便查找。
 *
 */
public class RfIntroduceForeignMethod {

    /**
     *  * Date newStart = new Date (previousEnd.getYear(), previousEnd.getMonth(), previousEnd.getDate() + 1);
     * \ \\\\\\
     * Date newStart = nextDay(previousEnd);
     * private static Date nextDay(Date arg) {
     *     return new Date (arg.getYear(), arg.getMonth(), arg.getDate() + 1);
     * }
     *
     */
}
