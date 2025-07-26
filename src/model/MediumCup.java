package model;

/**
 * Represents a medium-sized coffee cup with a 12oz capacity.
 */
public class MediumCup extends CoffeeCup {

    /**
     * Constructs a MediumCup inventory with a specified amount.
     *
     * @param amount initial amount of medium cups
     */
    public MediumCup(int amount) {
        super(amount);
        this.maxAmount = 64;
    }

    /**
     * Constructs a MediumCup inventory with zero initial stock.
     */
    public MediumCup() {
        super();
        this.maxAmount = 64;
    }

    @Override
    public String getSize() {
        return "Medium";
    }

    @Override
    public double getCapacity() {
        return 12.0;
    }
}
