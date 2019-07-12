package effectiveJava;

/**
 * 34. 用enum代替int常量

 */
public class Eff_34 {

    @EfLanguagePoints("针对枚举每个类型需要有特殊的行为时用抽象方法。不要用switch！！！")
    public enum Operation{
        PLUS("+"){
            @Override
            public double apply(double x, double y) {
                return x + y;
            }
        },
        MINUS("-"){
            @Override
            public double apply(double x, double y) {
                return x - y;
            }
        }
        ;

        private final String symbol;

        Operation(String symbol) {
            this.symbol = symbol;
        }
        @Override
        public String toString() {
            return symbol;
        }
        public abstract double apply(double x, double y);

    }

    /**
     * switch  仅仅限于给外部的枚举增加特定于常量的行为
     */
    @EfLanguagePoints("如果存在多个枚举类型对应一种相同行为，那么采用策略枚举方法，减少模版代码（strategy enum）")
    enum PayrollDay{
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,
        SATURDAY(PayType.WEEKEND),SUNDAY(PayType.WEEKEND);

        @EfLanguagePoints("")
        private final PayType payType;


        PayrollDay(PayType payType) {
            this.payType = payType;
        }

        PayrollDay() {
            this.payType = PayType.WEEKDAY;
        }

        @EfLanguagePoints("使用策略枚举替代switch  来完成多对一枚举行为映射")
        int pay(int minsWorked, int payRate){
            return payType.overtimePay(minsWorked,payRate);
        }

        enum PayType{
            WEEKDAY {
                int overtimePay(int minsWorked, int payRate){
                    return minsWorked <= MINS_PER_SHIFT?0:(minsWorked-MINS_PER_SHIFT)*payRate/2;
                }
            },
            WEEKEND{
                @Override
                int overtimePay(int mins, int payRte) {
                    return mins * payRte / 2;
                }
            };

            abstract int overtimePay(int mins, int payRte);
            private static final int MINS_PER_SHIFT = 8 * 60;

            int pay(int minsWorked, int payRate){
                int basePay = minsWorked * payRate;
                return basePay + overtimePay(minsWorked, payRate);
            }
        }

    }
}
