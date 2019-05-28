package designPattern.chp4_structural_patterns;

/**
 * 适配器
 *
 * 1 意图
 *   将一个类的接口转换成客户希望的另外一个接口。使得原本由于接口不兼容而不能一起工作的那些类可以一起工作
 * 2 别名
 *   包装器  Wrapper
 * 3 动机
 *
 * 4 适用性
 *    你想使用一个已经存在了的类， 而它的接口不符合你的需求。
 *    你想创建一个可以复用，该类可以与其他不相关的类或不可预见的类（即那些接口可能不一定兼容的类）协同工作
 *   （仅适用于对象Adapter）你想使用一些已经存在的子类，但是不可能对每一个都进行子类化以匹配它们的接口。对象适配器可以
 *    适配它的父类接口。
 * 5 结构。 一共有两种实现
 *    1. 同时继承目标target和提供具体功能的adaptee，这样适配器就具有的两个类的功能，然后直接调用adaptee方法
 *    2. 适配器继承target，然后将adaptee类以对象组合的方式持有该引用。通过类方法调用实现【依赖对象组合】
 *
 *
 *  6 相关模式
 *    Bridge(4.2)模式结构与对象适配器类似，但是其目的是将接口部分与实现部分分离，从而对它们可以较为容易的也
 *    相对独立的加以改变。 而adapter意味着改变一个一有对象的接口
 *
 *    Decorator(4.4)增强了对象的功能而又不改变其接口。透明性很好。并且支持递归组合
 *
 *    Proxy（4.7）在不改变它的接口的条件下，为另一个对象定义了一个代理。
 */

public class aAdapter41 {
}


/**
 * 使用对象组合的方式，在java中实现adapter
 */
@SuppressWarnings("all")
class TextShape extends Shape{

    private TextView textView;

    public TextShape(TextView textView) {
        this.textView = textView;
    }
    @Override
    @SuppressWarnings("all")
    void boundingBox(Point bottomLeft, Point topRight) {

        Coord bottom=null, left=null, width=null, height=null;

        //通过textView获取坐标值
        textView.getOrigin(bottom, left);
        textView.getExtent(width, height);

        bottomLeft = new Point(bottom, left);
        topRight = new Point(height, width);
    }

    boolean isEmpty() {
        return textView.isEmpty();
    }

    /**
     * 这个是adaptee中没有的功能，所以要从0开始进行实现
     * @return
     */
    @Override
    Manipulator createManipulator() {
        return new TextManipulator(this);
    }

}

