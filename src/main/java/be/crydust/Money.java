package be.crydust;

public abstract class Money {
    protected final int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    public static Money dollar(int amount) {
        return new Dollar(amount);
    }

    public static Money franc(int amount) {
        return new Franc(amount);
    }

    public abstract Money times(int multiplier);

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Money money)) return false;
        return amount == money.amount
               && getClass() == money.getClass();
    }

}
