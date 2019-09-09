package refactoring;

import java.util.Date;

/**
 * 一个服务类中有 许多方法 需要你自己编写但是你不能修改源码的时候。
 *  创建一个子类继承server（推荐），或者使用包装（wrapper）方式来使用server中的方法
 *
 *  Mechanics
 *  1 针对server创建一个子类或者wrapper
 *      构造函数中server要作为一个参数，子类要调用合适的父类构造器； 如果是wrapper那么要设置合适的代理域
 *  2 在extension  添加新的特性
 *  3 替换使用原来类的地方到extension上
 *  4 将原来写的ForeignMethod 移植到extension中来  {@link RfIntroduceForeignMethod}
 *
 *
 * @author szd1007@github.com
 * @date 2019-02-28 09:38
 */
public class RfIntroduceLocalExtension {

    static class mfDate extends Date {

        public mfDate(String dateStr) {
            super(dateStr);
        }

        public mfDate(Date arg) {
            super(arg.getTime());
        }

        /**
         * 这个方法新本地扩展方法，可能原来在不同类中声明成了ForeignMethod  {@link RfIntroduceForeignMethod}
         */
        public Date nextDay() {
            //因为继承了date，所以对应的方法可以直接使用咯
            return new Date(getYear(), getMonth(), getDate() + 1);
        }

        public int dayOfYear() {
            return -1;
        }

    }

    static class mfDateWrapper {
        private Date original;
    }

}
