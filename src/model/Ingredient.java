package model;

/**
 * An abstract class representing a measurable and consumable ingredient.
 * Implements the {@code Container} interface, allowing it to be filled or tracked.
 */
public abstract class Ingredient implements Container {

    /** Current amount of the ingredient available */
    protected double amount;

    /** Maximum amount that the container can hold */
    protected double maxAmount;

    /**
     * Constructs an Ingredient with zero amount.
     */
    public Ingredient() {
        this.amount = 0;
    }

    /**
     * Constructs an Ingredient with a specific starting amount.
     *
     * @param amount the initial amount of the ingredient
     */
    public Ingredient(double amount) {
        this.amount = amount;
    }

    /**
     * Returns the current amount of the ingredient.
     *
     * @return current amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Returns the maximum capacity of the ingredient container.
     *
     * @return maximum amount
     */
    public double getMaxAmount() {
        return maxAmount;
    }

    /**
     * Checks if the ingredient is fully consumed.
     *
     * @return {@code true} if the amount is less than or equal to zero
     */
    public boolean isDepleted() {
        return amount <= 0;
    }

    /**
     * Attempts to restock the ingredient by a certain amount.
     *
     * @param amount the amount to add
     * @return {@code true} if restock was successful; {@code false} if it exceeds maxAmount
     */
    public boolean restock(double amount) {
        if (this.amount + amount > maxAmount)
            return false;
        this.amount += amount;
        return true;
    }

    /**
     * Attempts to consume a specific amount of the ingredient.
     *
     * @param amount the amount to consume
     * @return {@code true} if there was enough to consume; {@code false} otherwise
     */
    public boolean consume(double amount) {
        if (this.amount >= amount) {
            this.amount -= amount;
            return true;
        }
        return false;
    }
}
