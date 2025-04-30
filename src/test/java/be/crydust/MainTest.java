package be.crydust;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class MainTest {
    @Test
    @Disabled
    void failing() {
        assertThat(false, is(true));
    }
}
