package be.crydust;

public class Bank {
    public Money reduce(Expression source, String to) {
        return source.reduce(to);
    }

    public void addRate(String from, String to, int rate) {
        // TODO from / rate == to
    }
}
