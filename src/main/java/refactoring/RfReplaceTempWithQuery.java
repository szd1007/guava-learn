package refactoring;

/**
 * 使用临时变量保存表达式结果时，将表达式封装成方法。这样一来可以被其他方法使用，并且不用进行参数传递
 * Motivation
 * 减少方法长度， 减少{@link RfExtractMethod} 传递参数
 *
 * @see RfSplitTemporaryVariable
 * @see RfSeparateQueryFromModifier
 *
 */
@SuppressWarnings("all")
public class RfReplaceTempWithQuery {
    double quantity=0,itemPrice=0;
    ////////////////////////////////////////////////////
    double test() {
        double basePrice = quantity * itemPrice;
        if (basePrice > 1000) {
            return basePrice * 0.95;
        } else
            return basePrice * 0.98;
    }
    //////////////////////////////////////////////////////
    double test2() {
        if (basePrice() > 1000) {
            return basePrice() * 0.95;
        } else
            return basePrice() * 0.98;
    }

    private double basePrice() {
        return quantity * itemPrice;
    }
}
