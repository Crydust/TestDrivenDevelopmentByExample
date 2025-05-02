package be.crydust;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

class MainTest {
    @Test
    void multiplication() {
        Money five = Money.dollar(5);
        assertThat(five.times(2), is(Money.dollar(10)));
        assertThat(five.times(3), is(Money.dollar(15)));
    }

    @Test
    void equality() {
        assertThat(Money.dollar(5), is(Money.dollar(5)));
        assertThat(Money.dollar(5), not(Money.dollar(6)));
        assertThat(Money.franc(5), is(Money.franc(5)));
        assertThat(Money.franc(5), not(Money.franc(6)));
        assertThat(Money.franc(5), not(Money.dollar(5)));
    }

    @Test
    void francMultiplication() {
        Money five = Money.franc(5);
        assertThat(five.times(2), is(Money.franc(10)));
        assertThat(five.times(3), is(Money.franc(15)));
    }

    @Test
    void currency() {
        assertThat(Money.dollar(5).currency(), is("USD"));
        assertThat(Money.franc(5).currency(), is("CHF"));
    }

    @Test
    void differentClassEquality() {
        assertThat(new Money(5, "USD"), is(new Dollar(5, "USD")));
        assertThat(new Money(5, "CHF"), is(new Franc(5, "CHF")));
    }

}
