package designPattern.chp3_createional_patterns;

/**
 * @author szd1007@github.com
 * @date 2019-05-16 14:37
 */
public class Door implements MapSite{

    private Room room1, room2;
    private boolean isOpen;

    public Door(Room ro1, Room ro2) {
        this.room1 = ro1;
        this.room2 = ro2;
    }

    @Override
    public void enter() {}

    Room otherSideFrom(Room room) {
      return null;
    }
}

class DooorNeedingSpell extends Door{

    public DooorNeedingSpell(Room ro1, Room ro2) {
        super(ro1, ro2);
    }
}
