package refactoring;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *  这种重构方式比较费时费力，一般不使用。。。。。
 *
 *
 *
 * 两个类之间有双向关联，但是一方不再需要使用另一方的特性的时候。
 * 将其改成单向引用.
 * 双向引用会增加系统的耦合性，使代码变得复杂难以维护。尽量使用单向
 * {@link RfChangeUnidirectionalAssociaitionToBidirectional}
 *
 * Mechanics
 * 1. 检查所有读取持有要移出引用的成员变量的reader。确定到底能不能删除
 *     考虑没有引用的情况下能否确定另外的对象，如果可以使用{@link RfSubstituteAlgorithm}
 *  来满足client使用getMethod
 *     考虑在使用这个field的方法参数上把引用的对象加上去
 * 2. 如果client要使用getter，使用{@link RfSelfEncapsulateField}， 在getter上使用{@link RfSubstituteAlgorithm}
 *
 * 3. 如果client不需要getter，使用另一种方式来使用对象
 * 4. 当没有reader在field上，移除所有对这个field的update方法，移除这个field
 *
 *
 */
public class RfChangeBidirectionalAssociationToUnidirectional {
    class Customer2{
        Set<Order2> orders = new HashSet<>();

        /**
         * should only be used by Order
         *
         *  When modifying the association
         */
        Set<Order2> friendOrders() {

            return orders;
        }

        public int getDiscount() {
            return 0;
        }
    }

    class Order2{
        Customer2 customer;
        Customer2 getCustomer() {
            return customer;
        }

        public void setCustomer(Customer2 customer) {
            if (customer != null) {
                customer.friendOrders().remove(this);
            }

            this.customer = customer;
            if (customer != null) {
                customer.friendOrders().add(this);
            }
        }
        double getDiscountedPrice() {
            return getGrossPrice() * (1 - customer.getDiscount());
        }

        private double getGrossPrice() {
            return 0;
        }
        double getPriceFor(Order2 order) {
            return order.getDiscountedPrice();
        }
    }
    ////////////////////////////////////////////
    //////////////////////////////////////////
    ///只有先有customer才有order。  故将移除oder中customer的引用

    class Order{

        /**
         * 去除customer的引用，对应的方法参数中添加customer对象
         */
        double getDiscountedPrice(Customer customer) {
            return getGrossPrice() * (1 - customer.getDiscount());
        }

        private double getGrossPrice() {
            return 0;
        }

        /**
         * 方式2 {@link RfSubstituteAlgorithm}
         * 不通过引用的方式来获取对象，
         * ps. 这种方式在接口级别还是双向引用的，但是在实现上是进行了分离。
         */
        Customer getCustomer() {
            for (Customer customer : Customer.getInstances()) {
                if (customer.containsOrder(this)) {
                    return customer;
                }
            }
            return null;
        }

    }

    static class Customer {

        /**
         * customer调用时将对象的连接关系传递过去即可
         */
        double getPriceFor(Order order) {
            return order.getDiscountedPrice(this);
        }

        public int getDiscount() {
            return 0;
        }

        public static List<Customer> getInstances() {
            return null;
        }

        public boolean containsOrder(Order order) {
            return false;
        }
    }


}
