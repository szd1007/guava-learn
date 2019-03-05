package refactoring;

import java.util.HashSet;
import java.util.Set;

/**
 *  你有两个类需要互相使用对方的一些特性，但是只有一个单向的链接。
 *  要添加反向链接，并且更改修饰符去更新两边集合
 *
 *  刚开始有两个类，一个引用另一个。后续发现被引用的类需要另外的类的feature。
 *
 *  Mechanics
 *  1. 添加一个成员变量保存反向指针
 *  2. 确定哪个类要控制这个关联关系
 *  3. 在非控制侧的类创建一个helper方法。起名时要清晰的指标该方法的作用。
 *  4. 如果存在的modifier（修饰符）在控制侧，用它来更新反向引用
 *  5. 如果存在的modifier（修饰符）在被控制的一侧，在控制侧创建一个控制方法，，从被控制的一侧去掉用它
 */
public class RfChangeUnidirectionalAssociaitionToBidirectional {

    class Order{
        Customer customer;
        Customer getCustomer() {
            return customer;
        }

        public void setCustomer(Customer customer) {
            this.customer = customer;
        }
    }
    // customer 没有到order的引用
    class Customer {

    }

    //////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////
    class Customer2{
        Set<Order2> orders = new HashSet<>();
        Set friendOrders() {
            /**
             * should only be used by Order When modifying the association
             */
            return orders;
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
    }
}
