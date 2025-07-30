package model;

/**
 * Represents a large-sized coffee cup with a 16 oz capacity.
 * <p>
 * This class extends {@link CoffeeCup} and sets the maximum stock capacity to 40 cups.
 * </p>
 */
public class LargeCup extends CoffeeCup {

    /**
     * Constructs a LargeCup with a specified initial amount in stock.
     *
     * @param amount the initial number of large cups
     */
    public LargeCup(int amount) {
        super(amount);
        this.maxAmount = 40;
    }

    /**
     * Constructs a LargeCup with zero initial stock.
     */
    public LargeCup() {
        super();
        this.maxAmount = 40;
    }

    /**
     * Returns the size label of the cup.
     *
     * @return the string "Large"
     */
    @Override
    public String getSize() {
        return "Large";
    }

    /**
     * Returns the capacity of the large cup in fluid ounces.
     *
     * @return 16.0 fluid ounces
     */
    @Override
    public double getCapacity() {
        return 16.0;
    }
}
