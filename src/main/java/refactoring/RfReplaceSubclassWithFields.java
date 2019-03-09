package refactoring;

/**
 * 你有一些子类，这些子类区别只是通过相同的方法去获取不同的常量值的时候（constant method）
 * 将子类去掉，构造方法上移 就ok
 *
 * Mechanics。
 * 1. 使用 {@link RfReplaceConstructorWithFactoryMethod} 在父类中创建子类对应的创建方法
 *      把子类移出之后，对应子类的构造方法就没法使用了。必须显示调用方法创建。
 */
public class RfReplaceSubclassWithFields {
    static class Before {
        abstract class Person {
            abstract boolean isMale();
            abstract  char getCode();

        }
        class Male extends Person {
            @Override
            boolean isMale() {
                return true;
            }

            @Override
            char getCode() {
                return 'M';
            }
        }

        class Female extends Person {

            @Override
            boolean isMale() {
                return false;
            }

            @Override
            char getCode() {
                return 'F';
            }
        }
    }

    static class After {
        static class Person {
            GenderEnum genderEnum;

            protected Person(GenderEnum male) {

            }

            boolean isMale(){
                 return genderEnum.equals(GenderEnum.MALE);
             }
              char getCode(){
                  return genderEnum.code;
              }

            Person createMale() {
                return new Person(GenderEnum.MALE);
            }
            Person createFemale() {
                return new Person(GenderEnum.FEMALE);
            }

            enum GenderEnum{
                MALE('M'),FEMALE('F');
                char code;

                GenderEnum(char code) {
                    this.code = code;
                }
            }
        }

    }
}
