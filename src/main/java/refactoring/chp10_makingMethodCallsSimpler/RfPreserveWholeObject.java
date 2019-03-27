package refactoring.chp10_makingMethodCallsSimpler;

/**
 * 你要从一个对象获取多个值(一个值的话不用)，并且要将这些值当做参数进行传递的时候
 * 使用这个对象来替代原来的方法
 * <p>
 * 当你一个方法需要来自另外一个对象的大量属性的时候，通常说明这个方法应该属于依赖的对象，这时用{@link refactoring.RfMoveMethod}
 * 作为替代方案
 * <p>
 * <p>
 * int  low = daysTempRange().getLow();
 * int high = daysTempRange().getHigh();
 * withinPlan = plan.withinRange(low, high);
 * ----------------------------------------
 * withinPlan = plan.withinRange(daysTempRange());
 */
@SuppressWarnings("all")
public class RfPreserveWholeObject {

    class Before {

        class Room {

            boolean withinPlan(HeatingPlan plan) {
                int low = daysTempRange().getLow();
                int high = daysTempRange().getHigh();
                return plan.withinRange(low, high);
            }

        }

    }

    class After {

        class Room {

            boolean withinPlan(HeatingPlan plan) {
                return plan.withinRange(daysTempRange());
            }

            //            ==============================
            //进一步重构  move method
            boolean withInRange(TempRange tempRange) {
                return range.includes(tempRange);
            }
        }
    }

    private TempRange daysTempRange() {
        return null;
    }

    private class HeatingPlan {

        boolean withinRange(int low, int high) {
            return (low >= range.getLow()) && high <= range.getHigh();
        }

        public boolean withinRange(TempRange tempRange) {
            return tempRange.getLow() >= range.getLow() && tempRange.getHigh() <= range.getHigh();
        }
    }

    private TempRange range;

    private class TempRange {

        public int getLow() {
            return 0;
        }

        public int getHigh() {
            return 0;
        }

        public boolean includes(TempRange range) {
            return range.getLow() >= this.getLow() && range.getHigh() <= this.getHigh();
        }
    }
}
