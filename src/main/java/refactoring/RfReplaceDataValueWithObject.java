package refactoring;

import java.util.Collection;

/**
 * 你有一个数据项需要额外的数据或者行为的时候
 * 把这个数据项放到一个对象中
 *
 * 一开始只有一两个字段可以解决，后续发现有额外的需要，这时候就要把数据放到一个新类里去
 *
 *
 *{@link RfChangeValueToReference}
 * @author shangzhidong@zhuanzhuan.com
 * @date 2019-03-01 13:12
 */
public class RfReplaceDataValueWithObject {

    class Order {
        String customer;
        public Order(String customer) {
            this.customer = customer;
        }

        public String getCustomer() {
            return customer;
        }

        public void setCustomer(String customer) {
            this.customer = customer;
        }
    }

    private int numberOfOrdersFor(Collection<Order> orders, String customer) {
        int result = 0;
        for (Order x : orders) {
            if (x.getCustomer().equals(customer)) {
                result++;
            }
        }
        return result;
    }

    /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////
    class Customer {
        private String name;
        public Customer(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    class Order2 {
        private Customer customer;
        public Order2(String customer) {
            this.customer = new Customer(customer);
        }
        public String getCustomer() {
            return customer.getName();
        }

        /** @see RfRenameMethod
         *  重命名getCustomer  ，指定返回的具体含义是他的名称而不是对象
         */
        public String getCustomerName() {
            return customer.getName();
        }

        public void setCustomer(String customer) {
            this.customer = new Customer(customer);
        }
    }


}
