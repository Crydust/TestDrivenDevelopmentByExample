package be.crydust;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
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

    @Test
    void plusReturnsSum() {
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;
        assertThat(sum.augend, is(five));
        assertThat(sum.addend, is(five));
    }

    @Test
    void reduceSum() {
        Sum sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        assertThat(result, is(Money.dollar(7)));
    }

    @Test
    void reduceMoney() {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        assertThat(result, is(Money.dollar(1)));
    }

    @Test
    void reduceMoneyDifferentCurrency() {
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(Money.franc(2), "USD");
        assertThat(result, is(Money.dollar(1)));
    }

    @Test
    void identityRate() {
        Bank bank = new Bank();
        assertThat(bank.rate("USD", "USD"), is(1));
    }

    @Test
    void storeRate() {
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        assertThat(bank.rate("CHF", "USD"), is(2));
    }

    @Test
    void mixedAddition() {
        Expression fiveBucks = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(fiveBucks.plus(tenFrancs), "USD");
        assertThat(result, is(Money.dollar(10)));
    }

    @Test
    void sumPlusMoney() {
        Expression fiveBucks = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression sum = new Sum(fiveBucks, tenFrancs).plus(fiveBucks);
        Money result = bank.reduce(sum, "USD");
        assertThat(result, is(Money.dollar(15)));
    }

    @Test
    void sumTimes() {
        Expression fiveBucks = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression sum = new Sum(fiveBucks, tenFrancs).times(2);
        Money result = bank.reduce(sum, "USD");
        assertThat(result, is(Money.dollar(20)));
    }

    @Test
    void plusSameCurrencyReturnsMoney() {
        Expression five = Money.dollar(5);
        Expression sum = five.plus(five);
        assertThat(sum, instanceOf(Money.class));
    }
}
