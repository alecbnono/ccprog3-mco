package model;

/**
 * Abstract representation of a coffee cup.
 */
public abstract class CoffeeCup implements Binable {

    protected int amount;
    protected int maxAmount;

    public CoffeeCup() {
        this.amount = 0;
    }

    public CoffeeCup(int amount) {
        this.amount = amount;
    }

    public abstract String getSize();

    public abstract double getCapacity();

    @Override
    public String getType() {
        return getSize() + " Cup";
    }

    @Override
    public String getUnit() {
        return "pcs";
    }

    @Override
    public double getAmount() {
        return amount;
    }

    public double getMaxAmount() {
        return maxAmount;
    }

    @Override
    public boolean restock(double amount) {
        if (this.amount + (int) amount > maxAmount)
            return false;
        this.amount += (int) amount;
        return true;
    }

    @Override
    public boolean consume(double amount) {
        if (this.amount >= (int) amount) {
            this.amount -= (int) amount;
            return true;
        }
        return false;
    }

}
