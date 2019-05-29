package designPattern.chp4_structural_patterns;


import java.util.Iterator;

/**
 * 组合
 *
 * 1 意图
 *    将对象组合成树形结构以表示"部分-整体"的层次结构，使得用户对单个对象和组合对象的使用具 有一致性。
 * 2 动机
 *
 * 3 动机
 *    * 你想表示对象的部分-整体层次结构
 *    * 你希望用户忽略组合对象与单个对象的不同，用户将统一地使用组合结构中的所有对象。
 * 4 结构
 *
 * 6 协作
 *   用户使用component类接口与组合结构中的对象进行交互。如果接收者是个叶节点，则直接处理。如果是composite，通常将
 *   请求发送给它的子部件，在转发请求前后可能执行一些辅助操作。
 *
 *   composite类和子部件类的接口保持一致，对client来说调用完全一样。composite负责子节点的遍历
 *
 *
 *  11 相关模式
 *    decorator（4.4）经常与composite一起使用，
 *    flyweight（4.6）让你能共享组件，但不能再引用他们的父部件
 *    iterator（5.4）可用来遍历composite
 *    visitor（5.11）将本来应该分布在composite和leaf类中的操作行为局部化。
 *
 */
public class aComposite43 {

    public static void main(String[] args) {

        Chassis chassis = new Chassis();
        FloppyDisk floppyDisk = new FloppyDisk();
        chassis.add(floppyDisk);

        Cabinet cabinet = new Cabinet("cabinet");
        Bus bus = new Bus();
        cabinet.add(bus);
        //cabinet 作为composite 添加另外一个composite作为子部件
        cabinet.add(chassis);


    }
}

abstract class Equipment{
    private String name;

    String name(){
        return this.name;
    }
    abstract Watt Power();
    abstract  Currency NetPrice();
    abstract  Currency DiscountPrice();

     void add(Equipment equipment){};
     void remove(Equipment equipment){};
    Iterator<Equipment> createIterator(){
        return null;
    }

}
class FloppyDisk extends Equipment{
    @Override
    Watt Power() {
        return null;
    }

    @Override
    Currency NetPrice() {
        return null;
    }

    @Override
    Currency DiscountPrice() {
        return null;
    }
}
class Bus extends Equipment{
    @Override
    Watt Power() {
        return null;
    }

    @Override
    Currency NetPrice() {
        return null;
    }

    @Override
    Currency DiscountPrice() {
        return null;
    }
}


/**
 * composite . 包含其他设备的类，
 */
class CompositeEquiment extends Equipment{
    @Override
    Watt Power() {
        return null;
    }

    /**
     * composite 负责对功能方法进行遍历处理
     */
    @Override
    Currency NetPrice() {
        Currency currency = new Currency();

        Iterator<Equipment> iterator = createIterator();
        while (iterator.hasNext()) {
            currency.total += iterator.next().NetPrice().total;
        }
        return currency;
    }

    @Override
    Currency DiscountPrice() {
        return null;
    }

    @Override
    void add(Equipment equipment) {
        super.add(equipment);
    }

    @Override
    void remove(Equipment equipment) {
        super.remove(equipment);
    }

    /**
     *   节点中可以通过列表等存储该信息
     */
    @Override
    Iterator<Equipment> createIterator() {
        return super.createIterator();
    }
}

/**
 * 程序中的另外一个composite。  一个程序可以有多个composite
 */
class Chassis extends CompositeEquiment{

    @Override
    Watt Power() {
        return super.Power();
    }

    @Override
    Currency NetPrice() {
        return super.NetPrice();
    }

    @Override
    Currency DiscountPrice() {
        return super.DiscountPrice();
    }
}
class Cabinet extends CompositeEquiment{

    public Cabinet(String cabinet) {

    }

    @Override
    Watt Power() {
        return super.Power();
    }

    @Override
    Currency NetPrice() {
        return super.NetPrice();
    }

    @Override
    Currency DiscountPrice() {
        return super.DiscountPrice();
    }
}


class Watt{

}
class Currency{
    public int total;

}