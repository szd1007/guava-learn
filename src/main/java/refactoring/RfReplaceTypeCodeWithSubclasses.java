package refactoring;

/**
 *  如果在你的类中存在不变的类型码，并且这个类型码会应影响这个类的行为的时候
 *
 *  为这个类型生成对应的子类（每个类有各自的行为逻辑,用多态的方式来包装）
 *
 * 如果不改变行为的话，用 {@link RfReplaceTypeCodeWithClass}
 *
 *  Motivation：
 *   通常这样的情况暗示代码中有switch或者if else语句块（烂代码），
 *   需要{@link refactoring.Chp9SimplifyingConditionalExpression.ReplaceConditionalWithPolyMorphism}
 *
 *
 *   Mechanics
 *   1. 自封装类型码
 *      如果类型码是传递到了构造函数中，那么你要把构造函数替换成一个工厂方法。
 *      因为重构之后要返回新的生成类了
 *   2. 为每个typeCode的值创建一个子类。在子类重写get方法返回对应的值
 *      中间过度状态， 类似ENGINEER子类 返回int 0
 *   3. 从父类中移出类型码成员。声明访问方法为abtstract. 同时使用{@link RfpushDownMethod} {@link RfPushDownField}
 *  Employee 类
 *  ENGINEER :int
 *  SALESMAN :int
 *  type : int
 *  \\\\\\\\\\
 *  ENGINEER 和 SALESMAN 各自抽出类来封装各自的行为。
 *
 * @author szd1007@github.com
 * @date 2019-03-08 11:21
 */
public class RfReplaceTypeCodeWithSubclasses {

    static class Before{
        private class Employee {
            private int type ;
            static final int ENGINEER = 0;
            static final int SALESMAN = 1;
            static final int MANAGER  = 2;

            Employee(int type) {
                this.type = type;
            }

            int getType() {
                return type;
            }
        }
    }


    public static class After{
        private static class Employee {
            private int type ;
            static final int ENGINEER = 0;
            static final int SALESMAN = 1;
            static final int MANAGER  = 2;

            private Employee(int type) {
                this.type = type;
            }
            private Employee() {

            }

            /**
             * 父类使用工厂方法来负责对象创建.
             * 直接指定类名的好处，可以新加类的时候不用使用switch
             * 可以在枚举类型添加对应子类名称。
             *
             *
             * 当然如果只有几个固定的子类，并且不会后期添加
             * 可以为每个子类创建一个create方法
             *
             */


            static Employee createByName(String name) {
                try {
                    return (Employee) Class.forName(name).newInstance();
                } catch (Exception e) {
                    throw new IllegalArgumentException("unable to instantiate" + name);
                }
            }
            Employee create(int type) {

                switch (type) {
                    case ENGINEER:
                        return new Engineer();
                    case SALESMAN:
                        return new SalesMan();
                    case  MANAGER:
                        return new Manager();
                    default:
                        throw new IllegalArgumentException("Incorrect type code value");
                }
//                if (type == ENGINEER) {
//                    return new Manager();
//                }
//                return new Employee(type);
            }
            int getType() {
                return type;
            }
        }

        static class Engineer extends Employee {

            private Engineer(int type) {
                super(type);
            }

            public Engineer() {
                super();
            }

            int getType() {
                return Employee.ENGINEER;
            }
        }
        static class Manager extends Employee {

            private Manager(int type) {
                super(type);
            }

            public Manager() {
                super();
            }

            int getType() {
                return Employee.ENGINEER;
            }
        }
        static class SalesMan extends Employee {

            private SalesMan(int type) {
                super(type);
            }

            public SalesMan() {
                super();
            }

            int getType() {
                return Employee.ENGINEER;
            }
        }

    }

}
