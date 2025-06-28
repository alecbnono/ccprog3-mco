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
     * @param quantity    initial quantity
     * @param maxQuantity maximum allowed quantity
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

    /**
     * Returns the name of the item.
     * 
     * @return the name of the item
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the current quantity of the item.
     * 
     * @return the quantity of the item
     */
    public double getQuantity() {
        return quantity;
    }

    /**
     * Returns the unit of measurement used for the item.
     * 
     * @return the unit string (e.g., "g", "fl. oz.", "pcs")
     */
    public String getUnit() {
        return unit;
    }

    /**
     * Returns the maximum quantity capacity of the item.
     * 
     * @return the maximum quantity allowed for this item
     */
    public double getMaxQuantity() {
        return maxQuantity;
    }

    /**
     * Checks whether the item has been fully consumed.
     * 
     * @return true if the item quantity is less than or equal to zero, false
     *         otherwise
     */
    public boolean isDepleted() {
        return quantity <= 0;
    }

    /**
     * Attempts to restock the item by the given amount.
     * 
     * If the amount is less than or equal to zero, the method returns false.
     * If the resulting quantity would exceed the item's maximum capacity,
     * the quantity is set to the maximum. Otherwise, the amount is added normally.
     * 
     * @param amount the amount to add to the item's quantity
     * @return true if restocking was successful or adjusted to max, false if input
     *         is invalid
     */
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

    /**
     * Attempts to consume the item by the given amount.
     * 
     * The operation fails if the amount is less than or equal to zero,
     * or if the item does not have enough quantity available.
     * 
     * @param amount the amount to consume
     * @return true if the item was successfully consumed, false otherwise
     */
    public boolean consume(double amount) {
        if (amount <= 0 || quantity < amount) {
            return false;
        } else {
            quantity -= amount;
            return true;
        }
    }
}
