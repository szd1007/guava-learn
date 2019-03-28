package refactoring.chp10_makingMethodCallsSimpler;

/**
 * 一个方法返回一个特别的code来代表一个错误
 *
 * 将错误码替换成异常处理
 *
 * 注意事项：
 *         1. 确定异常类型，checked 和unchecked
 *          如果是checked 那么调用方要显示处理
 *          unchecked那么就是直接抛出异常，导致bug
 *
 * int withdraw(int amount) {
 *     if (amount > balance)
 *          return -1;
 *     else {
 *         balance -= amount;
 *         return 0;
 *     }
 * }
 * void withdraw(int amount)throws BalanceEception{
 *     if (amount > balance) throw new BalanceException();
 *          balance -= amount;
 * }
 */
public class RfRepalceErrorCodeWithException {

}
