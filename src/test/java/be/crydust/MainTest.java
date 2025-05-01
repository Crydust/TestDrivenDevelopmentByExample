package be.crydust;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class MainTest {
    @Test
    void multiplication() {
        Dollar five = new Dollar(5);
        Dollar times2 = five.times(2);
        assertThat(times2.amount, is(10));
        Dollar times3 = five.times(3);
        assertThat(times3.amount, is(15));
    }
}
