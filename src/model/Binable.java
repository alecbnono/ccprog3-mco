package model;

/**
 * Binable
 */
public interface Binable {

    public abstract boolean restock(double amount);

    public abstract boolean consume(double amount);

    public double getAmount();

    public double getMaxAmount();

    public String getType();

    public abstract String getUnit();

}
