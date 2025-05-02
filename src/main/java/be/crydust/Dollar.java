package be.crydust;

public final class Dollar extends Money {

    public Dollar(int amount) {
        super(amount);
    }

    @Override
    public Money times(int multiplier) {
        return new Dollar(amount * multiplier);
    }

}
