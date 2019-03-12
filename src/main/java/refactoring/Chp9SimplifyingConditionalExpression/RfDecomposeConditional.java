package refactoring.Chp9SimplifyingConditionalExpression;

/**
 * 你有一个复杂的条件表达式（if-then-else).(一眼看不出来表达式的含义）
 *  从condition/then/else中 抽取方法{@link refactoring.RfExtractMethod} ,
 *
 *  Mechanics
 *  1. 将condition抽取出来作为一个方法
 *  2. 将else中的部分抽成一个方法
 *
 *
 * if (date.before (SUMMER_START) || date.after(SUMMER_END))
 *      charge = quantity * winterRate + winterServiceCharge;
 * else
 *      charge = quantity * summerRate;
 ---------------------*
 * if (notSummer(date))
 *      charge = winterCharge(quantity);
 * else
 *      charge = summerCharge(quantity);
 *
 *
 *private boolean notSummer(Date date) {
 *     return date.before (SUMMER_START) || date.after(SUMMER_END);
 *}
 *private boolean summerCharge(int quantity) {
 *     return quantity * summerRate;
 *}
 *
 * @author shangzhidong@zhuanzhuan.com
 * @date 2019-03-11 17:11
 */
public class RfDecomposeConditional {


}
