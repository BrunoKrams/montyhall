package de.brunokrams;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    private final Door winner;
    private final List<Door> doors;
    private final Random random;
    private Door chosen;

    private static final int NR_OF_DOORS = 3;

    public Game() {
        random = new Random(System.currentTimeMillis());
        doors = new ArrayList<>();
        for (int i = 0; i < NR_OF_DOORS; i++) {
            doors.add(new Door());
        }

        winner = doors.get(random.nextInt(NR_OF_DOORS));
    }

    public boolean play(Strategy strategy) {
        chosen = strategy.chooseFirstDoor(doors);
        openRandomDoor();
        chosen = strategy.chooseDoor(doors, chosen);
        return chosen == winner;
    }

    private void openRandomDoor() {
        List<Door> openableDoors = doors.stream().filter(door -> (!door.isOpen() && door != winner && door != chosen)).toList();
        openableDoors.get(random.nextInt(openableDoors.size())).open();
    }

    public List<Door> getDoors() {
        return doors;
    }

    public Door getWinner() {
        return this.winner;
    }

}
