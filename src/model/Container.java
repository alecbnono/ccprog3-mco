package model;

/**
 * Container
 */
public interface Container extends Binable {

    public abstract boolean restock(double amount);

    public abstract boolean consume(double amount);

    public abstract double getAmount();
}
