package be.crydust;

public record Franc(int amount) {

    public Franc times(int multiplier) {
        return new Franc(amount * multiplier);
    }

}
