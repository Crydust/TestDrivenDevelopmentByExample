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
        assertThat(Money.franc(5), not(Money.dollar(5)));
    }

    @Test
    void currency() {
        assertThat(Money.dollar(5).currency(), is("USD"));
        assertThat(Money.franc(5).currency(), is("CHF"));
    }

    @Test
    void simpleAddition() {
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertThat(reduced, is(Money.dollar(10)));
    }

}
