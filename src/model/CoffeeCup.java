package model;

/**
 * Abstract representation of a coffee cup.
 */
public abstract class CoffeeCup implements Binable {

    protected int quantity;
    protected int maxQuantity;

    public CoffeeCup(int quantity) {
        this.quantity = quantity;
    }

    public abstract String getSize();

    public abstract double getCapacity();

    @Override
    public String getUnit() {
        return "pcs";
    }

    @Override
    public void fillCompletely() {
        quantity = maxQuantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getMaxQuantity() {
        return maxQuantity;
    }

    public boolean restock(int quantity) {
        if (this.quantity + quantity > maxQuantity)
            return false;
        this.quantity += quantity;
        return true;
    }

    public boolean consume(int quantity) {
        if (this.quantity >= quantity) {
            this.quantity -= quantity;
            return true;
        }
        return false;
    }

}
