package de.brunokrams;

import java.util.List;
import java.util.Random;

import static de.brunokrams.RandomAccessList.toRandomAccessList;

public abstract class Strategy {

    protected final Random random;

    public Strategy() {
        this.random = new Random(System.currentTimeMillis());
    }

    public Door chooseFirstDoor(RandomAccessList<Door> doors) {
        return doors.getRandomElement();
    }

    public abstract Door chooseDoor(List<Door> doors, Door chosen);

    public static final Strategy STAY = new Strategy() {
        @Override
        public Door chooseDoor(List<Door> doors, Door chosen) {
            return chosen;
        }
    };

    public static final Strategy CHANGE = new Strategy() {
        @Override
        public Door chooseDoor(List<Door> doors, Door chosen) {
            RandomAccessList<Door> selectableDoors = doors.stream().filter(door -> (!door.isOpen() && door != chosen)).collect(toRandomAccessList());
            return selectableDoors.getRandomElement();
        }
    };

}
