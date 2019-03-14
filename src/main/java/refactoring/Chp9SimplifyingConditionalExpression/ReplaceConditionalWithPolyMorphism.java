package refactoring.Chp9SimplifyingConditionalExpression;

/**
 * 你有一个条件判断根据不同的类型来选择不同的行为的时候(if esle、switch)
 *   将每个分支下沉到子类，当前方法改写成abstract的。
 *   @see refactoring.ReplaceTypeCodeWithStateOrStrategy
 *   @see refactoring.RfReplaceTypeCodeWithSubclasses
 */
@SuppressWarnings("all")
public class ReplaceConditionalWithPolyMorphism {
    static class Before{
        private int monthSalary;
        private int commission;
        private int bonus;

        private class Employee {
            private int type ;
            static final int ENGINEER = 0;
            static final int SALESMAN = 1;
            static final int MANAGER  = 2;

            Employee(int type) {
                this.type = type;
            }

            int getType() {
                return type;
            }

            int payAmount() {
                switch (type) {
                    case ENGINEER:
                        return monthSalary;
                    case SALESMAN:
                        return monthSalary + commission;
                    case MANAGER:
                        return monthSalary + bonus;
                    default:
                        throw new RuntimeException("Incorrect Employee");
                }
            }

            ////////////////////
            //payAmount方法在父类中abstract。子类实现具体逻辑
        }
    }

}
