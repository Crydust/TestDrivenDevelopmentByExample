package be.crydust;

public class Money {
    protected final int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Money money)) return false;
        return amount == money.amount
               && getClass() == money.getClass();
    }

}
