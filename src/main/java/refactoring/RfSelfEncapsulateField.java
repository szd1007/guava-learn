package refactoring;

/**
 * 针对内内部变量，尽量使用直接访问的形式使用。
 * 当对一个变量你在子类使用方式会和父类不一样时，可能要使用get方法（处理过的）。
 * 另外如果一个对象需要延迟加载，get方法也可以做到。
 *
 *
 *   Mechanics
 * 1. 为field对应创建get、set方法
 * 2. 直接引用都使用get和set方法来替换
 * 3. 将field设置成private
 *
 *
 *
 *
 *
 * @author szd1007@github.com
 * @date 2019-03-01 09:45
 */
public class RfSelfEncapsulateField {

    class IntRange {
        private int low,high;

        IntRange(int low, int high) {
            this.low = low;
            this.high = high;
        }
        boolean includes(int arg) {
            return arg >= low && arg <= high;
        }

        void grow(int factor) {
            high = high * factor;
        }

    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
   static class IntRange2 {
        private int low,high;

        /**
         * 不要再构造函数调用set方法， set方法通常的意义是对象创建完成之后修改值时进行调用
         * 构造函数可以直接使用内部变量，或者写一个专门的init方法。
         * @param low
         * @param high
         */
        IntRange2(int low, int high) {
            this.low = low;
            this.high = high;
        }
        boolean includes(int arg) {
            return arg >= getLow() && arg <= getHigh();
        }

        void grow(int factor) {
            setHigh(getHigh() * factor);
        }

        public int getLow() {
            return low;
        }

        public void setLow(int low) {
            this.low = low;
        }

        public int getHigh() {
            return high;
        }

        public void setHigh(int high) {
            this.high = high;
        }
    }

    static class CappedRange extends IntRange2 {
        private int cap ;
        public CappedRange(int low, int high, int cap) {
            super(low, high);
            this.cap = cap;
        }

        /**
         * 封装field内部方法调用的好处之一， 子类可以继承改变父类对应方法的含义
         */
        @Override
        public int getHigh() {
            return Math.min(super.getHigh(), cap);
        }


        public int getCap() {
            return cap;
        }

        public void setCap(int cap) {
            this.cap = cap;
        }
    }

}
