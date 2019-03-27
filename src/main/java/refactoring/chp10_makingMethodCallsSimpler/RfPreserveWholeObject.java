package refactoring.chp10_makingMethodCallsSimpler;

/**
 * 你要从一个对象获取多个值(一个值的话不用)，并且要将这些值当做参数进行传递的时候
 * 使用这个对象来替代原来的方法
 *
 *  当你一个方法需要来自另外一个对象的大量属性的时候，通常说明这个方法应该属于依赖的对象，这时用{@link refactoring.RfMoveMethod}
 *  作为替代方案
 *
 *
 * int  low = daysTempRange().getLow();
 * int high = daysTempRange().getHigh();
 * withinPlan = plan.withinRange(low, high);
 * ----------------------------------------
 * withinPlan = plan.withinRange(daysTempRange());
 *
 *
 */
public class RfPreserveWholeObject {
    class Before{

    }

}
