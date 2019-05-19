package designPattern.chp3_createional_patterns;

/**
 * 原型
 *
 * 1 意图  用原型实例指定创建对象的种类，并且通过拷贝这些原型来创建新的对象。
 *
 * 7效果
 *  运行时刻增加和删除产品
 *  改变值以指定新对象
 *  改变结构以指定新对象
 *  减少子类的构造
 *  用类动态配置应用
 *
 *  demo:
 *  从配置文件中读取要实现的类并绑定到全局表中。全局表维护对象周期，当使用时从全局表中查询到原型
 *  然后clone他（会创建实例，这个是和单例模式的区别）
 *
 *  相关模式
 *   prototype和abstractFactory在某种方面相互竞争，但是也可以一起使用。af可以存储一个被克隆的原型集合，
 *   并且返回对象。
 *
 *   大量composite43和decorator也可以从prototype中获益
 */
public class aPrototype34 {
}


class MazePrototypeFactory extends BaseMazeFactory{
    public MazePrototypeFactory(Maze maze, Wall wall, Room room, Door door) {

    }
    @Override
    Maze makeMaze() {
        return super.makeMaze();
    }

    @Override
    Wall makeWall() {
        return super.makeWall();
    }

    @Override
    Door makeDoor(Room r1, Room r2) {
        return super.makeDoor(r1, r2);
    }

    @Override
    Room makeRoom(int no) {
        return super.makeRoom(no);
    }
}