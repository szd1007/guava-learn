package refactoring.Chp9SimplifyingConditionalExpression;

import java.util.Objects;

/**
 * 当需要对一个null值进行多次判断的时候。
 * 将null value 替换成一个null object
 *
 *
 * Mechanics
 * 1. 针对当前类创建一个null version的子类。 在类中添加isNull 方法。同时父类返回false，null 版本返回true
 * 2. 查找所有会有请求source时会出现null的地方，将原来返回null替换成返回Null Version 对象
 * 3. 将原来判断source对象等于null的地方都替换成调用 isNull方法
 * 4. 查找原来使用方调用非空对象时的方法，在对应的空对像中实现对应的空方法
 * 5. null子类重写父类中的方法。执行对应的逻辑
 * 6. 针对这些null对象中override的方法，去除条件判断
 *
 *
 *
 * if(customer == null) plan =  BillingPlan.basic();
 * else plan = customer.getPlan();
 * ------------------------------------------------------------
 * NullCustomer.getPlan();
 *
 * @author shangzhidong@zhuanzhuan.com
 * @date 2019-03-15 09:16
 */
@SuppressWarnings("all")
public class RfIntroduceNullObject {

    private Customer customer;

    class Before{

        class Site{
            Customer getCustomer() {
                return customer;
            }
        }
        public void test() {
            Customer customer = new Site().getCustomer();
            BillingPlan plan ;
            if (customer == null) {
                plan = BillingPlan.basic();
            } else {
                plan = customer.getPlan();
            }

            String customerName;
            if (customer == null) {
                customerName = "occupant";
            } else {
                customerName = customer.getName();
            }

            int weeksDelinquent;
            if (customer == null) {
                weeksDelinquent = 0;
            } else {
                weeksDelinquent= customer.getHistory().getWeekDelinquentInLastYear();
            }
        }
    }

    class After{
        class Site{
            Customer getCustomer() {
                //直接生成空对像
                if (Objects.isNull(customer)) {
                    return Customer.newNull();
                }
                return customer;
            }
        }

        /**
         * 这样的好处是针对大多数的使用者，我们可以提供一个默认的行为
         * 如果有部分client要在null时执行不同的行为，那么还是要调用IsNull方法。
         */
        public void test() {
            Customer customer = new Site().getCustomer();
            BillingPlan plan ;
            plan = customer.getPlan();

            String customerName;
            customerName = customer.getName();

            int weeksDelinquent;
            weeksDelinquent= customer.getHistory().getWeekDelinquentInLastYear();
        }
    }

    ///////////////////////////////////////////////////////////////
    private static class NullCustomer extends Customer {

        /**
         * 添加空对象判断方法
         */
        @Override
        public boolean isNull() {
            return true;
        }


        @Override
        public String getName() {
            return "occupant";
        }

        @Override
        public BillingPlan getPlan() {
            return BillingPlan.basic();
        }

        @Override
        public PaymentHistory getHistory() {
            return new NullPaymentHistory();
        }

        private static class NullPaymentHistory extends PaymentHistory {

            public boolean isNull() {
                return true;
            }

            @Override
            int getWeekDelinquentInLastYear() {
                return 0;
            }
        }
    }





    static class Customer {

        /**
         * 添加非空判断
         */
        public boolean isNull() {
            return  false;
        }

        /**
         * 添加factory method 生成空对像. 这样的好处是 null 对象都不用向外暴露
         * @return
         */
        static Customer newNull() {
            return new NullCustomer();
        }


        public String getName(){
            return null;
        }

        public BillingPlan getPlan() {
            return null;
        }

        public PaymentHistory getHistory() {
            return null;
        }

    }
    static class BillingPlan{


        public static BillingPlan basic() {
            return null;
        }
    }
    static class PaymentHistory {
        public boolean isNull() {
            return false;
        }
        int getWeekDelinquentInLastYear() {
            return 0;
        }
    }
}
