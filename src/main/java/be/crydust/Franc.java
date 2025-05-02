package be.crydust;

public final class Franc extends Money {

    public Franc(int amount) {
        super(amount);
    }

    @Override
    public Money times(int multiplier) {
        return new Franc(amount * multiplier);
    }

}
