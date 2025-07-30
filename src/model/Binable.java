package model;

/**
 * The {@code Binable} interface defines a contract for any item or ingredient
 * that can be stored in a bin within the coffee truck system.
 * <p>
 * Implementing classes must support operations for restocking, consuming,
 * and reporting details such as current amount, maximum capacity, type,
 * and unit of measurement.
 * </p>
 *
 * This interface is typically implemented by add-ons, ingredients, or containers
 * that have a measurable quantity and are managed by the inventory system.
 *
 * @author
 */
public interface Binable {

    /**
     * Attempts to restock the item with the specified amount.
     * If the addition exceeds the item's maximum capacity, the operation should fail.
     *
     * @param amount the amount to add
     * @return {@code true} if restocking was successful; {@code false} otherwise
     */
    public abstract boolean restock(double amount);

    /**
     * Attempts to consume the specified amount from the item.
     * If there is not enough available, the operation should fail.
     *
     * @param amount the amount to consume
     * @return {@code true} if consumption was successful; {@code false} otherwise
     */
    public abstract boolean consume(double amount);

    /**
     * Returns the current amount of the item available.
     *
     * @return the current quantity
     */
    public double getAmount();

    /**
     * Returns the maximum amount the item can hold.
     *
     * @return the maximum capacity
     */
    public double getMaxAmount();

    /**
     * Returns the type or name of the item (e.g., "Milk", "Water", "Almond").
     *
     * @return the item type as a {@code String}
     */
    public String getType();

    /**
     * Returns the unit of measurement for the item (e.g., "ml", "fl. oz.", "g").
     *
     * @return the unit of measurement as a {@code String}
     */
    public abstract String getUnit();
}
