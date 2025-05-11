package be.crydust;

public record Sum(Expression augend, Expression addend) implements Expression {

    @Override
    public Money reduce(Bank bank, String to) {
        int amount = augend.reduce(bank, to).amount
                     + addend.reduce(bank, to).amount;
        return new Money(amount, to);
    }

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    @Override
    public Expression times(int multiplier) {
        return new Sum(augend.times(multiplier), addend.times(multiplier));
    }
}
