package designPattern.chp5_behavior_patterns;

/**
 * 备忘录
 *
 *  1 意图  在不破坏封装性的前提下，捕获一个对象的内部状态， 并在该对象外保存这个状态。
 *  用于以后将该对象恢复到原先保存的状态
 *
 *  2 别名  token
 *
 *  3 适用性
 *   必须保存一个对象在某一个时刻的（部分）状态，可以以后方便的恢复
 *   如果一个用接口来让其他对象直接得到对象状态，将暴露对象实现细节并破坏对象封装性。
 *
 * 12 相关模式
 *   command52 命令可使用备忘录来为可撤销的操作维护状态
 *   iterator54 如前所述备忘录可用于迭代
 *
 * @author shangzhidong@zhuanzhuan.com
 * @date 2019-06-15 17:22
 */
public class aMemento56 {
    Originator.State state;

    public Originator.State getState() {
        return state;
    }

    public void setState(Originator.State state) {
        this.state = state;
    }
}

/**
 * 原发器
 */
class Originator {
    State state;

    /**
     * 创建对象状态
     */
    aMemento56 createMemento(){
        aMemento56 aMemento56 = new aMemento56();
        aMemento56.setState(new State(state));
        return aMemento56;
    }

    /**
     * 恢复对象状态
     */
    void setMemento(aMemento56 memento56) {
        this.state = memento56.getState();
    }






    static class State{
        private int a ;
        private String b;

        public State(State state) {
            a = state.a;
            b = state.b;
        }
    }
}
