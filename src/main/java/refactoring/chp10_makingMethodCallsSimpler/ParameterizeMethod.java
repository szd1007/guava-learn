package refactoring.chp10_makingMethodCallsSimpler;

/**
 * 几个方法做相同的事情，但是不同的方法体中包含不同值
 * 将这些不同的值通过新增的参数传递过来
 *
 *
 *  fivePercentRaise()
 *  tenPercentRaise()
 *  ===============
 *  raise(percentage)
 */
public class ParameterizeMethod {
    private double salary;
    class Before{
        class Empployee{
            void tenPercentRaise() {
                salary *= 1.1;
            }
            void fivePercentRaise() {
                salary *= 1.05;
            }
        }

        double baseCharge() {
            double result = Math.min(lastUsage(), 100) * 0.03;
            if (lastUsage() > 100) {
                result += (Math.min(lastUsage(), 200) - 100) * 0.05;
            }
            if (lastUsage() > 200) {
                result += (lastUsage() - 200) * 0.07;
            }
            return result;
        }
    }

    private double lastUsage() {
        return 0;
    }

    class After{
        double baseCharge() {
            double result = usageInRange(0, 100) * 0.03;
            result += usageInRange(100, 200) * 0.05;
            result += usageInRange(200, Integer.MAX_VALUE) * 0.07;
            return result;
        }

        private double usageInRange(int start, int end) {
            if (lastUsage() > start) {
                return Math.min(lastUsage(), end) - start;
            }else {
                return 0;
            }
        }

        class Employee{
            void raise(double factor) {
                salary *= (1 + factor);
            }
        }
    }

}
