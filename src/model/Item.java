package model;

/**
 * Abstract class representing an inventory item.
 */
public abstract class Item {

    protected String name;
    protected String unit;
    protected double quantity;
    protected double maxQuantity;

    /**
     * Constructs an Item with a given quantity and maximum quantity.
     *
     * @param quantity     initial quantity
     * @param maxQuantity  maximum allowed quantity
     */
    public Item(double quantity, double maxQuantity) {
        this.maxQuantity = maxQuantity;

        if (quantity >= 0 && quantity <= maxQuantity) {
            this.quantity = quantity;
        } else if (quantity > maxQuantity) {
            this.quantity = maxQuantity;
        } else if (quantity < 0) {
            this.quantity = 0;
        }
    }


    /**
     * Constructs an Item with max quantity and zero initial quantity.
     *
     * @param maxQuantity the max allowed quantity
     */
    public Item(double maxQuantity) {
        this.maxQuantity = maxQuantity;
    }

    public String getName() {
        return name;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    public double getMaxQuantity() {
        return maxQuantity;
    }

    public boolean isDepleted() {
        return quantity <= 0;
    }

    public boolean restock(double amount) {
        if (amount <= 0) {
            return false;
        } else if (maxQuantity < quantity + amount) {
            quantity = maxQuantity;
            return true;
        } else {
            quantity += amount;
            return true;
        }
    }

    public boolean consume(double amount) {
        if (amount <= 0 || quantity < amount) {
            return false;
        } else {
            quantity -= amount;
            return true;
        }
    }
}
