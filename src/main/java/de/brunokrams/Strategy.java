package de.brunokrams;

import java.util.List;
import java.util.Random;

public abstract class Strategy {

    protected final Random random;

    public Strategy() {
        this.random = new Random(System.currentTimeMillis());
    }

    public Door chooseFirstDoor(List<Door> doors) {
        return doors.get(random.nextInt(doors.size()));
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
            List<Door> selectableDoors = doors.stream().filter(door -> (!door.isOpen() && door != chosen)).toList();
            return selectableDoors.get(random.nextInt(selectableDoors.size()));
        }
    };

}
