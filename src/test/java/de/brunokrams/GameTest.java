package de.brunokrams;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @Test
    public void exactlyOneDoorContainsAPrize() {
        // given
        Game game = new Game();

        // when
        List<Door> doorsWithPrice = game.getDoors().stream().filter(door -> door == game.getWinner()).toList();

        // then
        assertThat(doorsWithPrice).hasSize(1);
    }

}
