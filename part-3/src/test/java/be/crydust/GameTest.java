package be.crydust;

import be.crydust.Game.Dice;
import be.crydust.Game.Die;
import be.crydust.Game.SimpleDie;
import be.crydust.Game.SimpleWrappedRandom;
import be.crydust.Game.WrappedRandom;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.oneOf;

public class GameTest {

    @Test
    void shouldReturnRandomDieSide() {
        SimpleWrappedRandom random = new SimpleWrappedRandom(new Random());

        int value = random.randomDieSide(6);

        assertThat(value, oneOf(1, 2, 3, 4, 5, 6));
    }

    @Test
    void shouldRollDie() {
        Die d6 = new SimpleDie(aFixedRandom(5), 6);

        Iterable<Integer> roll = d6.roll();

        assertThat(roll, contains(5));
    }

    @Test
    void shouldCompositeDice() {
        Dice dice = new Dice(
                aFixedDie(1),
                aFixedDie(2),
                aFixedDie(3)
        );

        Iterable<Integer> roll = dice.roll();

        assertThat(roll, containsInAnyOrder(1, 2, 3));
    }

    private static WrappedRandom aFixedRandom(int value) {
        return _ -> value;
    }

    private static Die aFixedDie(int value) {
        return () -> List.of(value);
    }

}
