package refactoring;

/** 一个类有类型编码（数字)，并且这些编码不影响类的行为(如果类行为根据类型值不同而改变，
 *  考虑使用{@link RfReplaceTypeCodeWithSubClass}
 * 将这些类型定义放到一个新类中
 *
 * 如果传递数字，那么使用这些类型的方法参数 在 编译层面只能进行数字校验，容易带来潜在bug 且不易察觉
 *
 * Mechanics
 * 1. 为类型码创建一个类（枚举）
 * 2. 使用新的枚举替换原来的
 * 3.
 * @author shangzhidong@zhuanzhuan.com
 * @date 2019-03-08 09:37
 */
public class RfReplaceTypeCodeWithClass {

    class Before {
        class Person{
            public static final int O = 0;
            public static final int A = 1;
            public static final int B = 2;
            public static final int AB = 3;

            private int bloodGroup;

            public Person(int bloodGroup) {
                this.bloodGroup = bloodGroup;
            }

            public void setBloodGroup(int bloodGroup) {
                this.bloodGroup = bloodGroup;
            }

            public int getBloodGroup() {
                return bloodGroup;
            }

        }

    }

   static class After {
        enum BloodGroupEnum{
            O(0), A(1), B(2), AB(3);

            private int code;

            BloodGroupEnum(int code) {
                this.code = code;
            }
        class Person{


            private BloodGroupEnum bloodGroup;

            public Person(BloodGroupEnum bloodGroup) {
                this.bloodGroup = bloodGroup;
            }

            public void setBloodGroup(BloodGroupEnum bloodGroup) {
                this.bloodGroup = bloodGroup;
            }

            public BloodGroupEnum getBloodGroup() {
                return bloodGroup;
            }

            /**
             * 不建议使用数字
             */
            private int getBloodGroupCode() {
                return bloodGroup.code;
            }

            }

        }

    }
}
