package be.crydust;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

class MainTest {
    @Test
    void multiplication() {
        Dollar five = new Dollar(5);
        Dollar times2 = five.times(2);
        assertThat(times2.amount(), is(10));
        Dollar times3 = five.times(3);
        assertThat(times3.amount(), is(15));
    }

    @Test
    void equality() {
        assertThat(new Dollar(5), is(new Dollar(5)));
        assertThat(new Dollar(5), not(new Dollar(6)));
    }
}
