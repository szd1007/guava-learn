package refactoring.Chp9SimplifyingConditionalExpression;

/**
 * 当有一系列的判断都是返回同一个结果的时候，将这些条件判断抽离出来并声明一个方法。
 *
 * Mechanics
 * 1. 检查这个条件判断没有（side effect）边界影响（如果有就不能进行重构）
 * 2. 使用逻辑运算符将这些判断条件整合到一起
 * 3. extract method
 *
 * @author shangzhidong@zhuanzhuan.com
 * @date 2019-03-12 17:46
 */
public class RfConsolidateConditionalExpression {
    private int seniority;
    private boolean isPartTime;
    private int monthsDisabled;

    class Before{
        double disabilityAmount(){
            if(seniority < 2) return 0;
            if(monthsDisabled > 12) return 0;
            if (isPartTime) {
                return 0;
            }
            //compute the disability amount
            return  -1;
        }
    }

    class After{
        double disabilityAmount(){
            if(isNotEligibleForDisability()) return 0;
            //compute the disability amount
            return  -1;
        }

        /**
         * 这个表达式是否还有进一步拆分的必要性？
         * 方法名称就已经做了表达式含义的说明
         */
        private boolean isNotEligibleForDisability() {
            //这里使用了or  有时候需要用and 来处理
            return (seniority < 2) || (monthsDisabled > 12) || isPartTime;
        }
    }
}
