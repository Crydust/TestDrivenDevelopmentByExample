package be.crydust;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class MainTest {
    @Test
    void multiplication() {
        Dollar five = new Dollar(5);
        five.times(2);
        assertThat(five.amount, is(10));
    }
}
