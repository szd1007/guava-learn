package designPattern.chp4_structural_patterns;

/**
 * 享元
 * 1 意图   运用共享技术有效地支持大量细粒度的对象
 * 3 适用性
 *     一个应用程序使用了大量的对象
 *     完全由于使用大量对象造成很大的内存开销
 *     若删除对象外部状态，可以用相对较少的共享对象取代很多组对象
 *     应用程序不依赖对象标识。
 *
 * 5参与者
 *    flyweight（Glyph）：描述一个接口，通过这个接口可以接受并作用于外部状态
 *    concreteFlyweight（Character）： 共享对象实现
 *    unsharedConcreteFlyweight： 结构体系中非共享部分，比如 row column，这类对象通常持有concreteFlyweight对象进行处理
 *    flyweightFactory ： 抽象工厂，负责管理flyweight
 *    client  ： 维持一个flyweight的引用，计算或者存储多个flyweight的外部状态
 *
 * 8 实现
 *    1）删除外部状态
 *    2）管理共享对象【通常情况共享对象一般比较少，仅需创建维护对象就ok。无需删除】
 *
 *
 * @author shangzhidong@zhuanzhuan.com
 * @date 2019-05-30 11:19
 */
public class aFlyweight46 {

}

abstract class Glyph {

    abstract void draw(WindowGlyph windowGlyph, GlyphContext context);
    abstract void setFont(Font font, GlyphContext context);
    abstract Font getFont(GlyphContext context);
    abstract void first(GlyphContext context);
    abstract void next(GlyphContext context);
    abstract boolean isDone(GlyphContext context);
    abstract Glyph current(GlyphContext context);
    abstract void insert(Glyph glyph, GlyphContext context);
    abstract void remove(GlyphContext context);

}
class WindowGlyph{}
class GlyphContext{}
class Font{}
