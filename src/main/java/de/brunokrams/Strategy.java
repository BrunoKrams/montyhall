package de.brunokrams;

import java.util.List;

import static de.brunokrams.RandomAccessList.toRandomAccessList;

public abstract class Strategy {

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
