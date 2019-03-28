package refactoring.chp10_makingMethodCallsSimpler;

/**
 * 当存在一个条件可以通过程序判断的方式来处理的时候，不要用异常的方式来实现
 *
 *
 * double getValueForPeriod(int periodNumber) {
 *     try{
 *         return values[periodNumber];
 *     } catch(ArrayIndexOutOfBoundException e) {
 *         return 0;
 *     }
 * }
 * -------------------------------
 * double getValueForPeriod(int periodNumber) {
 *     if (periodNumber >= values.length) return 0;
 *     return values[periodNumber];
 * }
 */
public class RepalceExceptionWithTest {
}
