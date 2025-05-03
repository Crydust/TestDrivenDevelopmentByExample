package be.crydust;

public class Money implements Expression {
    protected final int amount;
    protected final String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    public Money times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    public String currency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Money money)) return false;
        return amount == money.amount
               && currency().equals(money.currency());
    }

    @Override
    public String toString() {
        return "Money{" +
               "amount=" + amount +
               ", currency='" + currency + '\'' +
               '}';
    }

    public Expression plus(Money addend) {
        return new Sum(this, addend);
    }

    @Override
    public Money reduce(String to) {
        int rate = "CHF".equals(currency) && "USD".equals(to)
                ? 2
                : 1;
        return new Money(amount / rate, to);
    }
}
