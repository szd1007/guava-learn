package refactoring;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 *  你有一个引用对象，如果本身是小的、不可变且不好管理，那就搞成一个valueObject
 *  {@link RfChangeValuetoReference}
 *
 *  确保对象是不可变的，
 *  例如你有一个对象表示money，你钱可以变（重新创建一个对象）。但是之前的money对象不能通过修改的方式代表新的金额
 *
 *  Mechanics
 *  1. 检查对象是否是immutable 或是能够变成 immutable
 *      如果不是，可以执行{@link RfRemoveSettingMethod}
 *      如果你想重构的类不是不可变的，那么就放弃这种重构方式
 *  2. 类中创建equals方法和hash方法
 *      因为会有不同的类对象代表相同的含义，比如上面说的money
 *  3. 考虑移出所有的工厂方法并让这个类的constructor变为public
 */

@SuppressWarnings("all")
public class RfChangeReferenceToValue {
    static class Currency {
        private String code;
        static Map<String, Currency> instances = Maps.newHashMap();

        public String getCode() {
            return code;
        }

        private Currency(String code) {
            this.code = code;
        }

        public static Currency get(String code) {
            return instances.get(code);
        }
    }

    ////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////

    static class Currency2 {
        private String code;

        public String getCode() {
            return code;
        }

        public Currency2(String code) {
            this.code = code;
        }

        /**
         * 重写 equals 方法
         * @param arg
         * @return
         */
        @Override
        public boolean equals(Object arg) {
            if (!(arg instanceof Currency2)) {
                return false;
            }
            Currency2 other = (Currency2) arg;
            return code.equals(other.getCode());
        }

        @Override
        public int hashCode() {
            return code.hashCode();
        }

        public static void main(String[] args) {
            new Currency2("USD").equals(new Currency2("USD"));
        }
    }
}
