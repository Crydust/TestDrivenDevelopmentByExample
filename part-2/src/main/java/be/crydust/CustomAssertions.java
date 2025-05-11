package be.crydust;

import java.util.Objects;

/**
 * This class merely exists to avoid using java's `assert` keyword.
 * The `assert` keyword is ignored if we forget the `-ea` argument.
 */
public final class CustomAssertions {
    private CustomAssertions() {
        // do not instantiate
    }

    public static void assertTrue(boolean condition) {
        assertTrue(condition, "Assertion failed");
    }

    public static void assertEquals(Object expected, Object actual) {
        assertTrue(Objects.equals(expected, actual), "Expected <%s>, but was <%s>".formatted(expected, actual));
    }

    public static void assertTrue(boolean condition, String message) {
        if (!condition) {
            throw new IllegalArgumentException(message);
        }
    }
}
