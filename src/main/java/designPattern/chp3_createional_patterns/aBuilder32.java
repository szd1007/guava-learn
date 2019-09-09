package designPattern.chp3_createional_patterns;

/**生成器模式
 * @author szd1007@github.com
 * @date 2019-05-17 13:24
 *
 * 1 意图： 将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。
 * 3 适用性；a)当创建复杂对象的算法应该独立于该对象的组成部分以及它们的装配方式时　　b)当构造过程必须允许被构造的对象有不同的表示时
 * 5 参与者
 *   builder  未创建一个Product对象的各个部件指定抽象接口
 *   concreteBuilder 实现builder的接口以构造和装配该产品的各个部件；定义并明确它所创建的表示；提供一个检索产品的接口
 *   director  构造一个使用builder的对象
 *   product 表示被构造的复杂对象。包含定义组成的部件类
 * 7 效果
 *   可以改变一个产品的内部表示
 *   将构造代码和表示代码分开
 *   可对构造过程实施更加精细的控制
 *
 *
//builder 和 abstractFactory原理类似。但是builder是在最后进行对象返回，
//builder着重于一步步的构造一个复杂对象（单个对象整体）。
//abstractFactory 着重于多个系列的产品对象（例如同一套ui但是不同配色方案的展示，突出一系列联合使用）
 */
public class aBuilder32 {

}

class MazeBuilder {
    Maze buildMaze(){
        return null;
    }

    Door buildDoor(int r1, int r2) {
        return null;
    }
    Room buildRoom(int roomNo){
        return null;
    }

    Maze getMaze() {
        return null;
    }

}
