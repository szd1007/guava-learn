package thecompletereferenc;

import java.util.Currency;
import java.util.Locale;
import java.util.Set;

/**
 * @author shangzhidong@zhuanzhuan.com
 * @date 2018-12-14 13:14
 */
public class CurrencyTest {

    public static void main(String[] args) {
        Set<Currency> ava = Currency.getAvailableCurrencies();

        System.out.println(ava);
        System.out.println(ava.iterator().next().getDisplayName());

        Currency cn = Currency.getInstance(Locale.SIMPLIFIED_CHINESE);
        //人民币 CNY
        System.out.println(cn.getDisplayName() + " " + cn.getCurrencyCode() + " " + cn.getSymbol());
        System.out.println("default fractional digits:" + cn.getDefaultFractionDigits());

    }
}
