package refactoring.chp10_makingMethodCallsSimpler;

/**
 *   你有一个方法既除了返回具体值之外，还更改了一个对象的状态。
 *   这时候要创建两个方法，把查询和修改行为拆分开
 *   (例外，如果是创建一个新的订单，然后接口返回最新的订单状态。)
 *   getTotalOutstandingAndSetReadyForSummaries
 *   =======================================
 *   getTotalOutstanding
 *   setReadyForSummaries
 *
 * @author shangzhidong@zhuanzhuan.com
 * @date 2019-03-25 20:46
 */
public class RfSeperateQueryFromModifier {

}
