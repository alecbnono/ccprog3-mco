package model;

/**
 * Represents a small-sized coffee cup with an 8oz capacity.
 */
public class SmallCup extends CoffeeCup {

    /**
     * Constructs a SmallCup inventory with a specified amount.
     *
     * @param amount initial amount of small cups
     */
    public SmallCup(int amount) {
        super(amount);
        this.maxAmount = 40;
    }

    /**
     * Constructs a SmallCup inventory with zero initial stock.
     */
    public SmallCup() {
        super();
        this.maxAmount = 40;
    }

    @Override
    public String getSize() {
        return "Small";
    }

    @Override
    public double getCapacity() {
        return 8.0;
    }
}

