package be.crydust;

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

    public static void assertTrue(boolean condition, String message) {
        if (!condition) {
            throw new IllegalArgumentException(message);
        }
    }
}
