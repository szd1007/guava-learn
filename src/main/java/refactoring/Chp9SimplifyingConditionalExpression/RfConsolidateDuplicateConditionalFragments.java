package refactoring.Chp9SimplifyingConditionalExpression;

/**
 * 相同的代码段出现在一个条件表达式中的所有分支里的时候，
 *    要把分支代码抽离出去
 *
 *
 * @author szd1007@github.com
 * @date 2019-03-13 09:32
 */
public class RfConsolidateDuplicateConditionalFragments {

    private double total;
    private double price;
    private void send() {
    }
    private boolean isSpecialDeal() {
        return false;
    }


    class Before {
        void test() {
            if (isSpecialDeal()) {
                total = price * 0.95;
                send();
            }else {
                total = price * 0.98;
                send();
            }
        }
    }

    class After {
        void test() {
            if (isSpecialDeal()) {
                total = price * 0.95;
            } else {
                total = price * 0.98;
            }
            //将send从原来的判断分支中移出来。
            //如果不是一个方法而是一个代码段，那么需要将这部分代码抽离成方法（一个，或多个）
            send();
        }
    }



}
