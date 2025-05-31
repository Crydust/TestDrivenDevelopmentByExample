package be.crydust;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Triangle {
    private Triangle() {
        throw new UnsupportedOperationException("No instances");
    }

    public static int determineShape(int sideA, int sideB, int sideC) {

        List<Integer> sides = Arrays.asList(sideA, sideB, sideC);
        Collections.sort(sides);
        if (sides.get(0) <= 0
            || sides.get(0) + sides.get(1) <= sides.get(2)) {
            throw new IllegalArgumentException("Not a well formed triangle");
        }

        // An equilateral triangle is a triangle where all three sides are of equal length.
        if (sideA == sideB && sideB == sideC) {
            return 1;
        }

        // An isosceles triangle is a triangle that has two sides of equal length.
        if (sideA == sideB || sideB == sideC || sideA == sideC) {
            return 2;
        }

        // A scalene triangle is a type of triangle where all three sides are of different lengths.
        return 3;
    }
}
