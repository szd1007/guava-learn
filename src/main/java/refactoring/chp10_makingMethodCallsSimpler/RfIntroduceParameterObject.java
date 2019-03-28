package refactoring.chp10_makingMethodCallsSimpler;

import com.google.common.collect.Lists;

import java.util.Date;
import java.util.List;

/**
 * 你有一组参数列表通常一起出现的时候。
 * 将他们替换成一个对象
 * 这样的好处是可以发现新的重构方法，可以讲关联的行为移到新的类中 {@link refactoring.RfExtractMethod }
 * {@link refactoring.RfMoveMethod}
 *
 */
public class RfIntroduceParameterObject {
    class Entry{
         private final double value;
         private final Date charDate;
        Entry(double value, Date chargeDate) {
            this.value = value;
            this.charDate = chargeDate;
        }

        public double getValue() {
            return value;
        }

        public Date getCharDate() {
            return charDate;
        }
    }

    class Before{
        class Account{
            List<Entry> entryList = Lists.newArrayList();
            double getFlowBetween(Date start, Date end) {
                double result = 0;
                for (Entry entry : entryList) {
//                    if(entry.getCharDate())
                }
                return result;
            }
        }
    }

}
