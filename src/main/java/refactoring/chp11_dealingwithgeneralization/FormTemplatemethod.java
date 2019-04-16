package refactoring.chp11_dealingwithgeneralization;

/**
 * 塑造模板函数
 *
 * 你有一些子类， 将其中响应的某些函数以相同顺序执行类似的操作， 但各个操作的细节有所不同。
 *
 * 将操作进行函数方封装，并且保持相同的签名。 于是原函数就变得相同了。然后将原函数上移至超类，形成模板类。
 */
public class FormTemplatemethod {

    abstract class A {
        void process(){
            doSomething1();
            //do something else
        }

        abstract  void doSomething1() ;
    }

    class B extends A {
        @Override
        void doSomething1() {

        }
    }

}
