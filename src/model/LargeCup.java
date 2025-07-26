package model;

/**
 * Represents a large-sized coffee cup with a 16oz capacity.
 */
public class LargeCup extends CoffeeCup {

    /**
     * Constructs a LargeCup inventory with a specified amount.
     *
     * @param amount initial amount of large cups
     */
    public LargeCup(int amount) {
        super(amount);
        this.maxAmount = 40;
    }

    /**
     * Constructs a LargeCup inventory with zero initial stock.
     */
    public LargeCup() {
        super();
        this.maxAmount = 40;
    }

    @Override
    public String getSize() {
        return "Large";
    }

    @Override
    public double getCapacity() {
        return 16.0;
    }
}
