package model;

/**
 * Represents any item that can be stored in a StorageBin.
 */
public abstract class Item {
    protected String name;
    protected double quantity;
    protected double maxQuantity;

    public Item(String name, double quantity, double maxQuantity) {
        this.name = name;
        this.quantity = quantity;
        this.maxQuantity = maxQuantity;
    }

    public String getName() {
        return name;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getMaxQuantity() {
        return maxQuantity;
    }

    public boolean isDepleted() {
        return quantity <= 0;
    }

    public boolean restock(double amount) {
        if (quantity + amount > maxQuantity) return false;
        quantity += amount;
        return true;
    }

    public boolean consume(double amount) {
        if (quantity >= amount) {
            quantity -= amount;
            return true;
        }
        return false;
    }
}
