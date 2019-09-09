package refactoring.chp10_makingMethodCallsSimpler;

import java.util.List;

/**
 * 你有一个方法既除了返回具体值之外，还更改了一个对象的状态。
 * 这时候要创建两个方法，把查询和修改行为拆分开
 * (例外，如果是创建一个新的订单，然后接口返回最新的订单状态。)
 * getTotalOutstandingAndSetReadyForSummaries
 * =======================================
 * getTotalOutstanding
 * setReadyForSummaries
 * <p>
 * A good rule to follow is to say that any method that returns a value should not
 * have observable side effects.
 *
 * @author szd1007@github.com
 * @date 2019-03-25 20:46
 */
@SuppressWarnings("all")
public class RfSeperateQueryFromModifier {

    class Before {

        String foundMiscreant(List<String> people) {
            for (String person : people) {
                if (person.equals("Don")) {
                    sendAlert();
                    return "Don";
                }
                if (person.equals("John")) {
                    sendAlert();
                    return "John";
                }
            }
            return "";
        }

        void checkSecurity(List<String> people) {
            String found = foundMiscreant(people);
            //do sth else
        }
    }

    class After {

        String foundPerson(List<String> people) {
            for (String person : people) {
                if (person.equals("Don")) {
                    return "Don";
                }
                if (person.equals("John")) {
                    return "John";
                }
            }
            return "";
        }

        private void sendAlert2(List<String> people) {
            if (!foundPerson(people).equals("")) {
                sendAlert();
            }
        }

        void checkSecurity(List<String> people) {
            String found = foundPerson(people);
            //            if (!Strings.isNullOrEmpty(found)) {
            //                sendAlert();
            //            }
            sendAlert2(people);
            //do sth else
        }
    }

    void sendAlert() {

    }

}
