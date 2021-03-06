package designPattern.chp4_structural_patterns;

/**
 * 装饰器
 * 1 意图
 *   动态地给一个对象添加一些额外的职责。就增加功能来说，Decorator模式相比生成子类更为灵活。
 * 2 别名
 *   包装器 wrapper
 * 3 动机
 *    可以动态的给一个对象添加额外职责的意思是说，通过外部包装的类来提供这些额外的功能。这个外部包装类
 *    和被装饰的组件接口一致。
 *    https://note.youdao.com/yws/public/resource/f8d17e644e954eff94da0ffe8331f9f7/xmlnote/16B352954A8B4D429D11E34AE09C7BDC/21346
 *
 * 4 适用性
 *   - 不影响其他对象的情况下，以动态、透明的方式各单个对象添加职责
 *   - 处理那些可以撤消的职责
 *   - 当不能采用生成子类的方法进行扩充时。1 可能有大量独立的扩展，为支持每一种组合将产生大量的子类，导致子类数目爆炸
 *      2 因为类定义被隐藏，或类定义不能用于生成子类。
 *
 * 7 协作
 *   decorator 将请求转发给它的component对象，并有可能在转发请求前后执行一些附加的动作。
 * 8 效果
 *    1） 比静态继承更灵活   可以在运行时刻增加和删除职责。相比之下继机制要为每个类创建对应的子类。增加系统复杂度。
 *    同时也可以做到重复添加一个特性。比如textView添加双边框。
 *    2）即用即付 添加职责。可通过decorator为类动态添加职责，职责拆分。方便扩展
 *    3） 不依赖对象标识
 *    4） 会产生一些小对象。很容易进行定制。但是很难学习这些系统。
 *
 *  9 实现
 *    1） 接口一致性， 被装饰的接口和装饰对象的接口要一致。可以是装饰对象的子类
 *    2） 当只要添加一个职责时省略抽象的decorator类。 直接继承实现装饰器
 *    3） 保持component类接口干净简洁。 这个接口是被装饰对象和装饰器共同继承的。
 *    4） 只有在component比较简洁的情况下适合该模式。相当于在对象上加了一个外壳。 如果component过于复杂，那么适合使用strategy模式


 相关模式
    adapter（4.1） ，适配器将给对象一个全新的接口
    Composite（4.3） 将装饰器视为一个退化的、仅有一个组件的组合。装饰仅给对象添加一些额外的职责-目的不在于对象聚集
    strategy（5.9） 用一个装饰你可以改变对象的外表， strategy使你可以改变对象的内核。这是改变对象的两种途径。


 */
public class aDecorator44 {


    public static void main(String[] args) {
        VisualComponent textViewss = new TextViewss();
        //进行装饰
        textViewss = new BorderDecorator(textViewss);
    }
}

interface VisualComponent {
    void draw();
    void resize();
}

class TextViewss implements VisualComponent {

    @Override
    public void draw() {

    }

    @Override
    public void resize() {

    }
}
class Decorator implements VisualComponent {
    private VisualComponent component;
    public Decorator(VisualComponent component) {
        this.component = component;
    }
    @Override
    public void draw() {
        component.draw();
    }

    @Override
    public void resize() {
        component.resize();
    }
}

class BorderDecorator extends Decorator{

    public BorderDecorator(VisualComponent component) {
        super(component);
    }

    private void drawBorder(){}


    @Override
    public void draw() {
        super.draw();
        drawBorder();
    }
}


