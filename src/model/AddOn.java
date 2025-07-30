package model;

/**
 * The {@code AddOn} class represents an abstract container for additional ingredients
 * or components that can be added to a product in the coffee truck simulation system.
 * <p>
 * This class implements the {@link Container} interface and provides base functionality
 * for managing the amount of an add-on, such as restocking, consuming, and checking depletion status.
 * Subclasses can represent specific add-ons like Milk, Sugar, etc.
 * </p>
 *
 * @author
 */
public abstract class AddOn implements Container {

    /** The current amount of the add-on in milliliters or grams (depending on context). */
    protected double amount;

    /** The maximum allowable amount of the add-on. */
    protected final double MAX_AMOUNT = 640.0;

    /**
     * Constructs an {@code AddOn} with an initial amount of 0.
     */
    public AddOn() {
        this.amount = 0;
    }

    /**
     * Constructs an {@code AddOn} with the specified initial amount.
     * If the initial amount exceeds the {@code MAX_AMOUNT}, it is capped.
     *
     * @param initialAmount the initial amount to store
     */
    public AddOn(double initialAmount) {
        this.amount = Math.min(initialAmount, MAX_AMOUNT);
    }

    /**
     * Returns the current amount stored in the add-on.
     *
     * @return the current amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Returns the maximum amount this add-on can hold.
     *
     * @return the maximum capacity
     */
    public double getMaxAmount() {
        return MAX_AMOUNT;
    }

    /**
     * Checks if the add-on is depleted (i.e., amount is 0 or less).
     *
     * @return {@code true} if the amount is less than or equal to 0; otherwise, {@code false}
     */
    public boolean isDepleted() {
        return amount <= 0;
    }

    /**
     * Attempts to restock the add-on with the specified amount.
     * If the restock would exceed {@code MAX_AMOUNT}, the operation fails.
     *
     * @param amount the amount to add
     * @return {@code true} if successfully restocked; {@code false} otherwise
     */
    public boolean restock(double amount) {
        if (this.amount + amount > MAX_AMOUNT)
            return false;
        this.amount += amount;
        return true;
    }

    /**
     * Attempts to consume the specified amount from the add-on.
     * If there is not enough available, the operation fails.
     *
     * @param amount the amount to consume
     * @return {@code true} if successfully consumed; {@code false} otherwise
     */
    public boolean consume(double amount) {
        if (this.amount >= amount) {
            this.amount -= amount;
            return true;
        }
        return false;
    }

    /**
     * Fills the add-on to its maximum capacity.
     */
    public void fillCompletely() {
        this.amount = MAX_AMOUNT;
    }
}
