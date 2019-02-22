package refactoring;

import static refactoring.RfReplaceTempWithQuery.itemPrice;
import static refactoring.RfReplaceTempWithQuery.quantity;

/**
 *  当你有一个复杂的表达式时，将其中部分公式放到一个临时变量中，然后根据用意命名该变量
 *
 *  Motivation
 *  将复杂的表达式分解成更容易管理的部分
 *
 *  替代方案  {@link RfExtractMethod}, 当不好实施时才使用此方式
 *
 *
 *
 *
 *
 *  if (( platform.toUpperCase().indexOf("MAC") > -1) &&
 *  (browser.toUpperCase().indexOf("IE") > -1) &&
 *  wasInitialized() && resize > 0)
 *  {
 *      //do something
 *  }
 *
 *         ||
 *         ||
 *        \  /
 *         \/
 *  final boolean isMacOs = platform.toUpperCase().indexOf("MAC") > -1;
 *  final boolean isIEBrowser = browser.toUpperCase().indexOf("IE") > -1;
 *  final boolean wasResized = resize >  0;
 *
 *  if (isMacOs && isIEBrowser && wasInitialized() && wasResized) {
 *      //do something
 *  }
 *
 * @author shangzhidong@zhuanzhuan.com
 * @date 2019-02-22 11:49
 */
@SuppressWarnings("all")
public class RfIntroduceExplainingVariable {

    //        =====================================================
    //        =====================================================
    double price(){

        //price is base price - quantity discount + shipping
        return quantity * itemPrice -
                Math.max(0,quantity -500) * itemPrice*0.05 +
                Math.min(quantity * itemPrice * 0.1, 100.0);

    }
    //        =====================================================
    //        =====================================================
    double price2() {
        final double basePrice = quantity * itemPrice;
        final double quantityDiscount = Math.max(0, quantity - 500);
        final double shipping = Math.min(basePrice * 0.1, 100.0);
        return basePrice - quantityDiscount + shipping;
    }
    //        =====================================================
    // 使用 extractMethod        =====================================================
    double price3(){
        return basePrice() - quantityDiscount() + shipping();
    }

    private double shipping() {
        return 0;
    }

    private double quantityDiscount() {
        return 0;
    }

    private double basePrice() {
        return 0;
    }

    //        =====================================================
    //        =====================================================
}
