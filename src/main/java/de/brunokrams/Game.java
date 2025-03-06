package de.brunokrams;

import java.util.List;

import static de.brunokrams.RandomAccessList.toRandomAccessList;

public class Game {

    private final Door winner;
    private final RandomAccessList<Door> doors;
    private Door chosen;

    private static final int NR_OF_DOORS = 3;

    public Game() {
        doors = new RandomAccessList<>();
        for (int i = 0; i < NR_OF_DOORS; i++) {
            doors.add(new Door());
        }

        winner = doors.getRandomElement();
    }

    public boolean play(Strategy strategy) {
        chosen = strategy.chooseFirstDoor(doors);
        openRandomDoor();
        chosen = strategy.chooseDoor(doors, chosen);
        return chosen == winner;
    }

    private void openRandomDoor() {
        RandomAccessList<Door> openableDoors = doors.stream().filter(door -> (!door.isOpen() && door != winner && door != chosen)).collect(toRandomAccessList());
        openableDoors.getRandomElement().open();
    }

    public List<Door> getDoors() {
        return doors;
    }

    public Door getWinner() {
        return this.winner;
    }

}
