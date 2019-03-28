package refactoring.chp10_makingMethodCallsSimpler;

import com.google.common.collect.Lists;

import java.util.Date;
import java.util.List;

/**
 * 你有一组参数列表通常一起出现的时候。
 * 将他们替换成一个对象.这个过程也是新增对象的过程（属性加行为)
 * 这样的好处是可以发现新的重构方法，可以将关联的行为移到新的类中 {@link refactoring.RfExtractMethod }
 * {@link refactoring.RfMoveMethod}
 *
 */
@SuppressWarnings("all")
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
                    if (entry.getCharDate().equals(start) || entry.getCharDate().equals(end) || (entry.getCharDate().after(start) && entry
                            .getCharDate().before(end))) {
                        result += entry.getValue();
                    }
                }
                return result;
            }
        }

        void testBefore() {
            Account account = new Account();
            Date start = null, end = null;
            account.getFlowBetween(start, end);
        }
    }

    class After{
        class DateRange{
            private final Date start;
            private final Date end;
            DateRange(Date start, Date end) {
                this.start = start;
                this.end = end;
            }

            public Date getStart() {
                return start;
            }

            public Date getEnd() {
                return end;
            }

            public boolean includes(Entry entry) {
                return entry.getCharDate().equals(start) || entry.getCharDate().equals(end) || (entry.getCharDate().after(start) && entry
                        .getCharDate().before(end));
            }
        }

        class Account{
            List<Entry> entryList = Lists.newArrayList();
            double getFlowBetween(DateRange dateRange) {
                double result = 0;
                for (Entry entry : entryList) {
                    if (entry.getCharDate().equals(dateRange.getStart()) || entry.getCharDate().equals(dateRange.getEnd()) || (
                            entry.getCharDate().after(dateRange.getStart()) && entry.getCharDate().before(dateRange.getEnd()))) {
                        result += entry.getValue();
                    }
                }
                return result;
            }

            /////////方式2////////{@ling}////////////////////

            /**
             * @see refactoring.RfMoveMethod
             */
            double getFlowBetween2(DateRange dateRange) {
                double result = 0;
                for (Entry entry : entryList) {
                    if (dateRange.includes(entry)) {
                        result += entry.getValue();
                    }
                }
                return result;
            }
        }
        void testAfter() {
            Account account = new Account();
            Date start = null, end = null;
            account.getFlowBetween(new DateRange(start, end));
        }

    }

}
