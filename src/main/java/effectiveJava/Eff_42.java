package effectiveJava;

import java.util.function.DoubleBinaryOperator;

/**
 * 42. Lambda优先于匿名类
 *
 * @see effectiveJava.Eff_34.Operation
 * @see thecompletereferenc.Lambda
 */
public class Eff_42 {
    @EfLanguagePoints("枚举操作类型的lambda版本，每个操作类型都有一个特殊的处理逻辑")
    public enum OperationLambda {
        PLUS("+", (x, y) -> x + y),
        MINUS("-", (x, y) -> x - y),
        DIVIDE("/", (x, y) -> x / y);
        private final String symbol;
        private final DoubleBinaryOperator op;

        OperationLambda(String symbol, DoubleBinaryOperator operator) {
            this.symbol = symbol;
            this.op = operator;
        }

        @Override
        public String toString() {
            return symbol;
        }

        public double apply(double x, double y) {
            return op.applyAsDouble(x, y);
        }

    }
}
