package be.crydust;

import java.util.Arrays;

public final class Triangle {
    private Triangle() {
        throw new UnsupportedOperationException("No instances");
    }

    public static int determineShape(int sideA, int sideB, int sideC) {

        int[] sides = {sideA, sideB, sideC};
        Arrays.sort(sides);
        if (sides[0] <= 0
            || sides[0] + sides[1] <= sides[2]) {
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
