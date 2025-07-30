package model;

/**
 * The {@code Container} interface represents a specialized type of {@link Binable}
 * that holds a measurable quantity of an item (such as liquids or powders)
 * and supports operations for restocking and consuming its contents.
 * <p>
 * This interface is meant for any object that functions as a container
 * in the coffee system, such as milk jugs, syrup bottles, or water tanks.
 * </p>
 *
 * @see Binable
 */
public interface Container extends Binable {

    /**
     * Attempts to restock the container with the specified amount.
     *
     * @param amount the amount to add
     * @return {@code true} if restocking was successful; {@code false} otherwise
     */
    @Override
    public abstract boolean restock(double amount);

    /**
     * Attempts to consume the specified amount from the container.
     *
     * @param amount the amount to remove
     * @return {@code true} if the amount could be consumed; {@code false} if not enough content
     */
    @Override
    public abstract boolean consume(double amount);

    /**
     * Gets the current amount stored in the container.
     *
     * @return the current amount as a {@code double}
     */
    @Override
    public abstract double getAmount();
}
