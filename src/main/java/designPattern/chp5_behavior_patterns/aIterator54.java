package designPattern.chp5_behavior_patterns;

/**
 * 迭代器模式   （别名  游标，cursor)
 *
 * 1 意图
 *    提供一种方法顺序访问一个聚合对象中的各个元素，而又不需暴露该对象的内部表示。
 * 8 效果
 *    支持以不同的方式遍历一个聚合。一个树的遍历中序和后序可用不同的迭代器实现
 *    迭代器简化了聚合的接口
 *    同一个聚合可以有多个遍历
 */
public class aIterator54 {

}
interface Iterator<E>{
    E first();
    E next();
    boolean isDone();
    E current();
}
abstract class AbstractList<E>{

    /**
     *factory method   子类实现具体
     * */
    abstract Iterator<E> iterator();
}

class ArrayList<E> extends AbstractList<E>{

    @Override
    Iterator<E> iterator() {
        return new ListIterator<E>();
    }

    static class ListIterator<E> implements Iterator<E>{

        @Override
        public E first() {
            return null;
        }

        @Override
        public E next() {
            return null;
        }

        @Override
        public boolean isDone() {
            return false;
        }

        @Override
        public E current() {
            return null;
        }
    }
}