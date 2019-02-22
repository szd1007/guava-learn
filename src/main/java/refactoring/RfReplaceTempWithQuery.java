package refactoring;

/**
 * 使用临时变量保存表达式结果时，将表达式封装成方法。这样一来可以被其他方法使用，并且不用进行参数传递
 * Motivation
 * 减少方法长度， 减少{@link RfExtractMethod} 传递参数
 *
 * @see RfSplitTemporaryVariable （如果一个临时变量设置超过一次）
 * @see RfSeparateQueryFromModifier （如果查询中要修改对象 not free of side effects)
 *
 */
@SuppressWarnings("all")
public class RfReplaceTempWithQuery {
    static double quantity=0,itemPrice=0;
    ////////////////////////////////////////////////////
    double test() {
        double basePrice = quantity * itemPrice;
        if (basePrice > 1000) {
            return basePrice * 0.95;
        } else
            return basePrice * 0.98;
    }
    ///////////带来的性能损耗是否值得///////////////////////////////////////////
    // nine times out of ten, it won't matter, you will ofen find more powerful optimizations,
    //which you would have missed without refactoring. If worse comes to worse, it is easy back to temp.
    double test2() {
        if (basePrice() > 1000) {
            return basePrice() * 0.95;
        } else
            return basePrice() * 0.98;
    }

    private static double basePrice() {
        return quantity * itemPrice;
    }

    ////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////

    static class inTest1{

        double getPrice() {
            double basePrice = quantity * itemPrice;
            double discountFactor ;
            if (basePrice > 1000) {
                discountFactor = 0.95;
            }else {
                discountFactor = 0.85;
            }
            return basePrice * discountFactor;
        }
////////////////////////////////////////////////////////////////////
        double getPrice2() {
            return basePrice() * discountFactor();
        }

        private double discountFactor() {
            //使用查询替代临时变量，减少了extractMethod时传递的参数。更加清晰
            if (basePrice() > 1000) {
                return 0.95;
            }
            return 0.98;
        }
    }
}
