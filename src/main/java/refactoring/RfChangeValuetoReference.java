package refactoring;


import java.util.HashMap;
import java.util.Map;

/**
 * 你有一个类里面有多个相同的实例，当你想用单独一个对象来替换的时候（单例模式，或者就是普通的对象引用）
 *
 * 比如{@link RfReplaceDataValueWithObject }, 里面的相同的customer对象（具体的实例不同，但是都是一个名字。意义上一个）
 *
 *   用工厂方法替代构造函数是很重要的！！！！！！（effective java）
 *   {@link RfReplaceConstructorWithFactoryMethod}
 *
 * Mechanics
 * 1. 用factoryMethod  替换 构造函数
 * 2. 确定用哪个类用来提供新类访问的入口
 *      可能是个静态的字典或者一个注册对象
 *      你可能有多个对象当做新对象的入口
 * 3. 确定对象是否需要预先生成，或者随用随生成
 * 4. 使用工厂方法返回对象引用
 *    如果对象是提前生成，你要处理访问了不存在对象的异常
 *    你可能会用到{@link RfRenameMethod} 去表明返回的是存在的对象
 */
@SuppressWarnings("all")
public class RfChangeValuetoReference {
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////
    static class Customer {
        private String name;
        private Customer(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        /**
         * FactoryMethod  工厂方法替换构造函数
         * @param name para
         */
        public static Customer create(String name) {
//            return new Customer(name);
            return instances.get(name);
        }

        /**
            因为只返回存在的对象,所以改一下名字。确定这个方法的真实含义
         {@link RfRenameMethod}
         */
        public static Customer getNamed(String name) {
            return instances.get(name);
        }

        private static Map<String, Customer> instances = new HashMap<>();

        static void loadCustomers() {
            instances.put("Lemon Car Hire", new Customer("Lemon Car Hire"));
            //这个吊吊的
            new Customer("Associated Coffee Machines").store();
            new Customer("Bilston Gasworks").store();

        }

        private void store() {
            instances.put(getName(), this);
        }

    }

    class Order2 {
        private Customer customer;
        public Order2(String name) {
//            this.customer = new Customer(customer);
            this.customer = Customer.create(name);
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
