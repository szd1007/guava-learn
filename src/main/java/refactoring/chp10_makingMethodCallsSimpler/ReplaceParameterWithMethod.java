package refactoring.chp10_makingMethodCallsSimpler;

/**
 *一个对象调用一个方法，然后将结果作为参数传递给方法。 这个方法同样可以直接调用这个方法
 *
 * 如果一个方法能避免直接传递参数来获取值。那就应该尝试。 我们要避免长参数列表
 * @author shangzhidong@zhuanzhuan.com
 * @date 2019-03-27 13:31
 */
public class ReplaceParameterWithMethod {

    private int quantity;
    private int itemPrice;

    class Before{
        public double getPrice(){
            int basePrice = quantity * itemPrice;
            int discountLevel ;
            if (quantity > 100) {
                discountLevel = 2;
            }else {
                discountLevel = 1;
            }
            double finalPrice = discountedPrice(basePrice, discountLevel);
            return finalPrice;
        }

        private double discountedPrice(int basePrice, int discountLevel) {
            if (discountLevel == 2) {
                return basePrice * 0.1;
            }else {
                return basePrice * 0.05;
            }
        }

    }

    class After{
//        public double getPrice(){
//
//            double finalPrice = discountedPrice();
//        }

        private int getDiscountLevel() {
            int discountLevel =0;
            if (quantity > 100) {
                discountLevel = 2;
            }else {
                discountLevel = 1;
            }
            return discountLevel;
        }
//////////////////////方式1//////////////////////////////////////////
        private double getPrice() {
            int basePrice = quantity * itemPrice;;
            if (getDiscountLevel() == 2) {
                return basePrice * 0.1;
            }else {
                return basePrice * 0.05;
            }
        }
//////////////////////////方式2//////////////////////////////////
        private double getPrice2() {
            if (getDiscountLevel() == 2) {
                return getBasePrice() * 0.1;
            }else {
                return getBasePrice() * 0.05;
            }
        }

        private double getBasePrice() {
            return quantity * itemPrice;
        }

    }
}
