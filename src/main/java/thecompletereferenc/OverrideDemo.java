package thecompletereferenc;

import effectiveJava.EfLanguagePoints;

/**
 *
 * （1）重写方法必须和被重写方法具有相同的参数列表（包括顺序及个数还有类型），返回类型必须和被重写方法的返回类型相同或者是返回类型的子类型。

 （2）重写方法的访问控制修饰符不能比被重写方法更严格（比如一个在父类中声明为public的方法重写成一个protected的方法）。

 （3）只有实例方法才能被重写，超类中的static和final方法不能被重写。

 （4）重写方法不能抛出新的检查异常，或者是抛出比被重写方法声明的检查异常更广泛的检查异常。

 （5）注意一种特殊情况：如果超类的方法版本中声明了检查异常，但重写的子类方法中没有声明，这时如果使用多态的方式进行调用，那么编译器认为你调用的是声明了异常的方法。

 * @author szd1007@github.com
 * @date 2019-06-21 14:21
 */
public class OverrideDemo {

      Parent  testReturn(){
        return new Parent();
    }
}

class SubOverride extends OverrideDemo {

    @Override
    @EfLanguagePoints("返回值可以是子类")
      Children testReturn() {
        return new Children();
    }
}

class Parent {


}

class Children extends Parent {


}
