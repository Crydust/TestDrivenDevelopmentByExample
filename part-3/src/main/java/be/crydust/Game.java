package be.crydust;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Game {

    public interface WrappedRandom {
        int randomDieSide(int sides);
    }

    public static class SimpleWrappedRandom implements WrappedRandom {
        private final Random random;

        public SimpleWrappedRandom(Random random) {
            this.random = random;
        }

        @Override
        public int randomDieSide(int sides) {
            return 1 + random.nextInt(0, sides);
        }
    }

    public interface Die {
        Iterable<Integer> roll();
    }

    public static class SimpleDie implements Die {
        private final WrappedRandom random;
        private final int sides;

        public SimpleDie(WrappedRandom random, int sides) {
            this.random = random;
            this.sides = sides;
        }

        @Override
        public Iterable<Integer> roll() {
            return List.of(random.randomDieSide(sides));
        }
    }

    public static class Dice implements Die {

        private final List<Die> dice;

        public Dice(Die... dice) {
            this.dice = List.of(dice);
        }

        @Override
        public Iterable<Integer> roll() {
            List<Integer> values = new ArrayList<>();
            for (Die die : dice) {
                for (Integer n : die.roll()) {
                    values.add(n);
                }
            }
            return values;
        }
    }

}
