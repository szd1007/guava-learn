package designPattern.chp3_createional_patterns;

/**
 * @author shangzhidong@zhuanzhuan.com
 * @date 2019-05-16 14:59
 *
 * 抽象工厂
 *
 * 1 意图
 *   提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类。
 * 2 别名 （kit）
 *
 * 4 适用性
 *   一个系统要独立于它的产品创建、组合和表示时。
 *   一个系统要由多个产品系列中的一个来配置时。（thrift）
 *   当你要强调一系列相关的产品对象的设计以便进行联合使用时。
 *   当你提供一个产品类库，而只想显示他们嫩的接口而不是实现时。
 *
 *  6参与者
 *   abstractFactory   声明一个创建爱你抽象产品的操作接口(接口)
 *   concreteFactory   实现创建具体产品对象的操作（impl）
 *   AbstractProduct   为每一类产品对象声明一个接口（接口）
 *   ConcreteProduct   定义并实现一个应用于具体创建工厂的产品对象（impl）
 *   Client            仅仅使用AbstractFactory 和AbstractProduct类声明的接口(基于接口编程)
 *
 *  7协作  运行时创建具体的工厂实例，通过abstractFactory将对象创建延迟到了子类
 *  8效果
 *    分离具体的类      将产品实现类与client隔离，client通过接口与产品交互
 *    易于交换产品系列   工厂示例只会初始化一次，通过更换具体工厂实例就可以很容易的实现产品线的切换。
 *    有利于产品一致性   一个具体的产品只能应用于同一系列的工厂中
 *    难以支持新种类产品  abstractFactory封装了所有的产品接口，在添加新产品的同时要扩展所有的工厂子类。
 *
 *  9 实现
 *  涉及的计数
 *   a. 将工厂最好实现为单例模式 {@link Singleton35}
 *   b. 创建产品，通常做法是为每个产品创建一个工厂方法{@link FactoryMethod33}(一个产品可能会有多个子类实现)
 *   c. 定义可扩展的工厂   可以通过传递参数（类型、整数、字符串）来动态创建产品。这样不用在新增产品时手动扩展所有factory类，
 *      带来的缺点就是返回的类型需要统一，客户没法区分返回具体类型。这是高度灵活和可扩展接口之间的折衷
 *
 *  10 code 实现
 *
 */
public class aAbstractFactory31 {

}

/**
 * 抽象工厂
 * ，默认实现的工厂，后续可以通过继承这个父类进行工厂扩展
 */
class BaseMazeFactory {
    Maze makeMaze(){
        return new Maze();
    }
    Wall makeWall(){
        return new Wall();
    }
    Door makeDoor(Room r1, Room r2){
        return new Door(r1, r2);
    }

    Room makeRoom(int no) {
        return new Room(no);
    }
}

/**
 * 创建一个施了魔法的迷宫
 */
class EnchantedMazeFactory extends BaseMazeFactory{

    @Override
    Door makeDoor(Room r1, Room r2) {
        return new DooorNeedingSpell(r1, r2);
    }

    @Override
    Room makeRoom(int no) {
        return new EnchantedMazeRoom(no);
    }
}

/**
 * 创建一个包含炸弹的简单迷宫
 */
class BombedMazeFactory extends BaseMazeFactory{

    @Override
    Wall makeWall() {
        return new BombedWall();
    }

    @Override
    Room makeRoom(int no) {
        return new RoomWithAnBomb(no);
    }
}
