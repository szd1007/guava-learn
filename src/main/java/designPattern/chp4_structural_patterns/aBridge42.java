package designPattern.chp4_structural_patterns;

import java.util.Objects;

/**
 * 桥接模式
 *
 * 1 意图
 *    将抽象部分与它的实现部分分离， 使它们都可以独立地变化。（面向接口编程）
 * 2 别名  Handle/Body
 * 3
 * 4 适用性
 *   1 你不想在抽象和它的实现部分之间有一个固定的绑定关系。例如你想在运行时刻可以将实现部分进行选择切换
 *   2 类抽象和实现部分都可以生成子类的方式进行扩充。该模式可以对不同的实现部分和抽象接口进行组合，分别进行扩充
 *   3 对一个抽象的实现部分的修改不应该对客户（client）产生影响，也就是说实现部分的接口不要对外暴露
 *   4 当你设计系统时有许多类需要生成，此时说明你必须将对象分解成两部分。 称之为 嵌套的普化（nested generalization）
     5 你想在多个对象间共享实现，但同时要求客户并不知道这一点

  6参与者
     Abstraction（Window)
       --定义抽象类的接口
       --维护一个指向Implementor类型对象的指针
     RedefinedAbstraction(IconWindow)
       --扩充由Abstraction定义的接口
     Implementor（WindowImpl）
       --定义实现类的接口，该接口不一定要与Abstraction的接口完全一样，甚至可以完全不同。通常情况下仅提供基本操作，Abstraction
            定义了基本操作之上的高级操作
     ConcreteImplementor（XWindowImpl， PMWindowImpl）
       --Implementor接口实现

  7 协作
    Abstract将client的请求转发给Implementor对象
  8 效果
     1） 分离接口极其实现部分
     2） 提高可扩充性  方便对abstraction进行扩充
     3） 实现细节对客户透明




   结构
 https://note.youdao.com/yws/public/resource/f8d17e644e954eff94da0ffe8331f9f7/xmlnote/WEBRESOURCE6940ed193f9a2da7df719e099257e3b4/21313
 https://note.youdao.com/yws/public/resource/f8d17e644e954eff94da0ffe8331f9f7/xmlnote/WEBRESOURCE6940ed193f9a2da7df719e099257e3b4/21313

 有点类似模板类方式，但是把模板类中的抽象方法提炼成接口采用外部实现。方便适用性1.2.  【面向接口编程】
 区别  模板类是1对多，子类只能关注抽象接口实现    。 桥接方式是多对多


  相关模式

 AbstractFactory 模式用来创建和配置一个特定的bridge模式
 adapter 模式用来帮助无关的类协同工作。通常在系统完成后才会使用
 而bridge则是在系统构建之初就开始使用，它使得抽象接口和实现部分进行抽离

 */
public class aBridge42 {
}

@SuppressWarnings("all")
abstract class Window{

    private WindowImpl windowImpl;
    private View view;


    public Window(View contents) {
    }

    /**
     * 这些都只window子类要实现的功能，不同子类会有不同
     */
    abstract void DrawContents();
    abstract void open();
    abstract void close();
    abstract void iconify();
    abstract void deIconify();

    //request forwarded to implementation
    abstract void setOrigin(Point at);
    abstract void setExtent(Point extent);
    abstract void raise();
    abstract void lower();
    abstract void drawLine(Point a, Point b);

    /**
     * 抽象部分使用接口进行编程，子类可以覆盖这个方法。类关系实现多对多
     */
    void drawReact(Point a, Point b) {

        windowImpl.drawReact(a.getX(), a.getY(), b.getX(), b.getY());
    }

    abstract void drawPloygon(Point[] a, int n);
    abstract void drawText(String text, Point at);

    /**
     * 使用抽象工厂方式来构建windowImpl
     */

    WindowImpl getWindowImpl(){
       return WindowImplFactory.instance().getWinImpl();
    }
    abstract View getView();

}

class WindowImplFactory{

    public static WindowImplFactory instance() {
        return null;
    }

    public WindowImpl getWinImpl() {
        return null;
    }
}
abstract class ApplicationWindow extends Window {

    public ApplicationWindow(View contents) {
        super(contents);
    }

    @Override
    void DrawContents() {
        getView().drawOn(this);
    }
}
abstract class IconWindow extends Window {

    public IconWindow(View contents) {
        super(contents);
    }

    @Override
    void DrawContents() {
        WindowImpl windowImpl = getWindowImpl();
        if (Objects.nonNull(windowImpl)) {
            windowImpl.deviceBitMap("name", 0, 0);
        }
    }
}
class View{

    public void drawOn(ApplicationWindow applicationWindow) {

    }
}

class WindowImpl{

    public void deviceBitMap(String name, int i, int i1) {

    }

    public void drawReact(int x, int y, int x1, int y1) {

    }
}

/**
 * WindowImpl  不同窗口系统下的实现。
 * 通过抽象WindowImpl 接口类， 将抽象部分与实现进行解耦。 方便各自功能多对多扩充
 *
 * ps  如果抽象部分固定，可以使用模板类方式。进行一对多扩充
 */
class XWindowImpl extends WindowImpl {

    @Override
    public void deviceBitMap(String name, int i, int i1) {
        super.deviceBitMap(name, i, i1);
    }

    @Override
    public void drawReact(int x, int y, int x1, int y1) {
        super.drawReact(x, y, x1, y1);
    }
}

class PMWindowImpl extends WindowImpl {

    @Override
    public void deviceBitMap(String name, int i, int i1) {
        super.deviceBitMap(name, i, i1);
    }

    @Override
    public void drawReact(int x, int y, int x1, int y1) {
        super.drawReact(x, y, x1, y1);
    }
}
