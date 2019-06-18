package designPattern.chp5_behavior_patterns;

import com.google.common.collect.Lists;

import java.util.List;

/**  观察者   别名 依赖（dependents),发布-订阅（publish-subscribe)
 *
 * 1 意图 定义对象间的一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖它的对象都得到通知并被自动更新
 * 3 动机
 *
 *  12 相关模式
 *  mediator55 通过封装复杂的语义， changeManger充当目标和观察者之间的中介者
 *  singleton35 changeManager 可以使用该模式保证全局唯一
 *
 *
 * @author shangzhidong@zhuanzhuan.com
 * @date 2019-06-18 10:43
 */
public class aObersver57 {

}


interface Subject{

    void attach(Observer observer);
    void detach(Observer observer);

    /**
     * 如果需要依赖subject内容，可以直接调用subject对象的方法【每个observer都维护了一个object的对象引用】
     */
    void notifySubject();
}

abstract class BaseSubject implements Subject {

    List<Observer> observers = Lists.newArrayList();
    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifySubject() {
        observers.forEach(Observer::update);
    }
}

interface Observer {
    void update();
}
