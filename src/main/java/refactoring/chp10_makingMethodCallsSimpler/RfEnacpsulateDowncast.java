package refactoring.chp10_makingMethodCallsSimpler;

/**
 * 一个方法返回一个object对象，这个结果需要由调用者进行向下转换（down cast）
 * 将downCast行为方法方法内部来做
 *
 * 不要给服务方带来额外的转换工作。这个我们可以自己来弄
 *
 * ///////////////
   Object lastReading(){
      return readings.lastElement();
    }

   Reading lastReading(){
    return (Reading) readings.lastElement();
 }
 */
public class RfEnacpsulateDowncast {
}
