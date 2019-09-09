package designPattern.chp3_createional_patterns;

/**
 * @author szd1007@github.com
 * @date 2019-05-16 14:31
 */
public class Room implements MapSite {

    private int roomNumber;
    private MapSite[] sides;
    public Room(int roomNo) {
        this.roomNumber = roomNo;
        sides = new MapSite[4];
    }

    public void setSides(Direction direction, MapSite site) {
        sides[direction.ordinal()] = site;
    }
    @Override
    public  void enter() {}
}

class EnchantedMazeRoom extends Room{

    public EnchantedMazeRoom(int roomNo) {
        super(roomNo);
    }
}
class RoomWithAnBomb extends Room{

    public RoomWithAnBomb(int roomNo) {
        super(roomNo);
    }
}
