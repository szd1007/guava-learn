package designPattern.chp3_createional_patterns;

/**
 * @author shangzhidong@zhuanzhuan.com
 * @date 2019-05-16 14:45
 */
public class MazeGame {

    Maze createMaze() {
        Maze maze = new Maze();
        Room r1 = new Room(1);
        Room r2 = new Room(2);

        Door theDoor = new Door(r1, r2);
        maze.addRoom(r1);
        maze.addRoom(r2);

        r1.setSides(Direction.North, new Wall());
        r1.setSides(Direction.East, theDoor);
        r1.setSides(Direction.South, new Wall());
        r1.setSides(Direction.West, new Wall());

        r2.setSides(Direction.North, new Wall());
        r2.setSides(Direction.East, new Wall());
        r2.setSides(Direction.South, new Wall());
        r2.setSides(Direction.West, theDoor);


        return maze;
    }

    ///////////////////////////////////////////////////////////////////////////
    //////使用抽象工厂 创建
    Maze createMaze(BaseMazeFactory factory) {
        Maze maze = factory.makeMaze();
        Room r1 = factory.makeRoom(1);
        Room r2 = factory.makeRoom(2);

        Door theDoor = factory.makeDoor(r1, r2);
        maze.addRoom(r1);
        maze.addRoom(r2);

        r1.setSides(Direction.North, factory.makeWall());
        r1.setSides(Direction.East, theDoor);
        r1.setSides(Direction.South, factory.makeWall());
        r1.setSides(Direction.West, factory.makeWall());

        r2.setSides(Direction.North, factory.makeWall());
        r2.setSides(Direction.East, factory.makeWall());
        r2.setSides(Direction.South, factory.makeWall());
        r2.setSides(Direction.West, theDoor);


        return maze;
    }
}
