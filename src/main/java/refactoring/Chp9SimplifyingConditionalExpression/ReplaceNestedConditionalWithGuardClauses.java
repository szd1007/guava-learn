package refactoring.Chp9SimplifyingConditionalExpression;

/**
 * 一个方法使用条件判断导致其执行路径不清晰，（比如连续的if else）。针对这些特殊情形使用guard clauses
 *
 *  如果你使用if then else语句，说明 前后两者的地位是等价的，针对哪些不常出现的分支，直接返回。表明其特殊性
 *
 *  Mechanics
 *  1. 将每个check操作放到guard clauses
 *  2. 如果每个check都返回同一个结果 用{@link RfConsolidateConditionalExpression}
 *
 */
public class ReplaceNestedConditionalWithGuardClauses {
    private static final double ADJ_FACTOR = 0;
    private boolean isDead;
    private boolean isSeparated;
    private double captial;
    private double intRate;
    private double duration;
    private double income;
    class Before{
        double getPayAmount (){
            double result;
            if (isDead) result = deadAmount();
            else {
                if (isSeparated) result = separatedAmount();
                else result = normalPayAmount();
            }
            return result;
        }
        //demo2  反转判断条件，使用guard clauses
        public double getAdjustedCapital(){
            double result = 0.0;
            if (captial > 0.0) {
                if (intRate >0.0 && duration > 0.0){
                    result =  (income/duration) * ADJ_FACTOR;
                }
            }
            return result;
        }
    }
    class After{
        double getPayAmount (){
            if (isDead) return deadAmount();
            if(isSeparated) return separatedAmount();
            return normalPayAmount();
        }


        //demo2  反转判断条件，使用guard clauses
        public double getAdjustedCapital(){
            if(captial<=0.0) return 0.0;
            if(intRate<0.0 || duration < 0.0) return 0.0;
            return (income/duration) * ADJ_FACTOR;
        }
    }


    private double normalPayAmount() {
        return 0;
    }

    private double separatedAmount() {
        return 0;
    }


    private double deadAmount() {
        return 0;
    }

}

