package designPattern.chp5_behavior_patterns;

/**
 * 策略  别名 政策（policy）
 *
 *   当有太多的ifElse 意味着需要使用strategy模式
 *
 * 1 意图  定义一系列的算法， 把它们一个个封装起来，并且使它们可相互替换。本模式使得算法可独立于
 * 使用它的客户而变化
 *
 * 8 效果
 *    相关算法系列
 *    一个可以替代继承的方式
 *    消除条件语句
 *
 *              void fun(){
 *
 *                switch(type):
 *                    case Simple:
 *                    xxxx
 *                    case Complex:
 *                     x xxx
 *                      }
 *
 *    context.getByType(type).doSomeThing
 *
 *   12 相关模式
 *     Flyweight46， strategy是很好的轻量级对象
 */

public class aStrategy59 {

}

class Compositon {

    Compositon(Compositor compositor) {
        this.compositor = compositor;
    }

    /**
     * 这个是算法类的抽象。除了通过构造函数传递过来，还可以后续根据策略更改
     */
    private Compositor compositor;

    /**
     * 正常的处理逻辑
     */
    public void coreFunc() {
        //do .sj.lfsjldf
        compositor.compose();
        //do after
    }
}
interface Compositor{
    void compose();
}

class SimpleCompositor implements Compositor {

    @Override
    public void compose() {
        System.out.println("simpleCompositor ");
    }
}

class ComplexCompositor implements Compositor {

    @Override
    public void compose() {
        System.out.println("complexCompositor ");
    }
}
