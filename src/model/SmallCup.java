package model;

/**
 * Represents a small-sized coffee cup with an 8oz capacity.
 * <p>
 * This class extends {@link CoffeeCup} and defines the size, capacity,
 * and maximum inventory quantity specific to small cups.
 * </p>
 */
public class SmallCup extends CoffeeCup {

    /**
     * Constructs a {@code SmallCup} inventory with a specified initial amount.
     *
     * @param amount the starting stock of small cups
     */
    public SmallCup(int amount) {
        super(amount);
        this.maxAmount = 40;
    }

    /**
     * Constructs a {@code SmallCup} inventory with zero initial stock.
     */
    public SmallCup() {
        super();
        this.maxAmount = 40;
    }

    /**
     * Returns the cup size label.
     *
     * @return "Small" as the cup size
     */
    @Override
    public String getSize() {
        return "Small";
    }

    /**
     * Returns the cup capacity in fluid ounces.
     *
     * @return 8.0 fluid ounces
     */
    @Override
    public double getCapacity() {
        return 8.0;
    }
}
