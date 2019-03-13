package refactoring.Chp9SimplifyingConditionalExpression;

/**
 * 将controlFlag 用break continue 或者  return 替代
 *
 * @author shangzhidong@zhuanzhuan.com
 * @date 2019-03-13 13:14
 */
public class RfRemoveControlFlag {

    class Before {

        void checkSecurity(String[] people) {
            boolean found = false;
            for (int i = 0; i < people.length; i++) {
                if (!found) {
                    if (people[i].equals("Don")) {
                        sendAlert();
                        found = true;
                    }

                    if (people[i].equals("John")) {
                        sendAlert();
                        found = true;
                    }
                }
            }
        }
    }

    class After {

        void checkSecurity(String[] people) {
            for (int i = 0; i < people.length; i++) {
                if (people[i].equals("Don")) {
                    sendAlert();
                    break;
                }
                if (people[i].equals("John")) {
                    sendAlert();
                    break;
                }
            }
        }

        void checkSecurity2(String[] people) {
            for (int i = 0; i < people.length; i++) {
                if (needAlert(people[i])) {
                    sendAlert();
                    break;
                }
            }
        }

        private boolean needAlert(String person) {
            return person.equals("Don") || person.equals("John");
        }
    }

    private void sendAlert() {

    }

}
