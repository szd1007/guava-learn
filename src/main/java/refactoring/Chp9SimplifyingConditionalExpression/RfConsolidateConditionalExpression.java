package refactoring.Chp9SimplifyingConditionalExpression;

/**
 * 当有一系列的判断都是返回同一个结果的时候，将这些条件判断抽离出来并声明一个方法。
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
            if(isNotEligableForDisability()) return 0;
            //compute the disability amount
            return  -1;
        }

        /**
         * 这个表达式是否还有进一步拆分的必要性？
         * 方法名称就已经做了表达式含义的说明
         */
        private boolean isNotEligableForDisability() {
            return (seniority < 2) || (monthsDisabled > 12) || isPartTime;
        }
    }
}
