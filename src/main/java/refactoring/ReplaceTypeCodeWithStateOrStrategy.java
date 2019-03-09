package refactoring;

/**
 * 你有一个类型编码会影响类的行为， 但是呢 不能用子类的方式重构
 *  用一个状态对象来替换类型编码（枚举就很适合）
 */
@SuppressWarnings("all")
public class ReplaceTypeCodeWithStateOrStrategy {

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
        }
    }

    static class After{
        private static int monthSalary;
        private static int commission;
        private static int bonus;

        private static class Employee {
            private int type ;
            enum Employtype{
                ENGINEER(0),SALESMAN(1),MANAGER(2);
                private int code;
                Employtype(int code) {
                    code = code;
                }

                public static Employtype getByCode(int code) {
                    for (Employtype employtype : values()) {
                        if (employtype.code == code) {
                            return employtype;
                        }
                    }
                    throw new RuntimeException("wrong code found" + code);
                }
            }

            Employee(int type) {
                this.type = type;
            }

            Employtype getType() {
                return Employtype.getByCode(type);
            }

            int payAmount() {
                switch (getType()) {
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
        }
    }
}
