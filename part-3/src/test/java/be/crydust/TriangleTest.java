package be.crydust;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static be.crydust.Triangle.determineShape;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class TriangleTest {
    @ParameterizedTest
    @CsvSource(useHeadersInDisplayName = true, textBlock = """
            sideA, sideB, sideC, shape
            3, 3, 3, 1
            2, 2, 2, 1
            3, 3, 2, 2
            3, 2, 3, 2
            2, 3, 3, 2
            3, 3, 4, 2
            3, 4, 3, 2
            4, 3, 3, 2
            3, 4, 5, 3
            """)
    void shouldDetermineShapeOfWellFormedTriangles(int sideA, int sideB, int sideC, int expectedShape) {
        assertEquals(expectedShape, determineShape(sideA, sideB, sideC));
    }

    @ParameterizedTest
    @CsvSource(useHeadersInDisplayName = true, textBlock = """
            sideA, sideB, sideC
            -1, 3, 3
            3, -1, 3
            3, 3, -1
            0, 3, 3
            3, 0, 3
            3, 3, 0
            1, 2, 3
            3, 1, 2
            2, 3, 1
            """)
    void shouldThrowForNotWellFormedTriangles(int sideA, int sideB, int sideC) {
        try {
            determineShape(sideA, sideB, sideC);
            fail();
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
}