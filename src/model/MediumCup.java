package model;

/**
 * Represents a medium-sized coffee cup with a 12 oz capacity.
 * <p>
 * This class models the inventory and properties of medium cups used in the coffee truck system.
 * </p>
 */
public class MediumCup extends CoffeeCup {

    /**
     * Constructs a MediumCup with a specified initial amount in stock.
     *
     * @param amount the number of medium cups initially available
     */
    public MediumCup(int amount) {
        super(amount);
        this.maxAmount = 64;
    }

    /**
     * Constructs a MediumCup with zero initial stock.
     */
    public MediumCup() {
        super();
        this.maxAmount = 64;
    }

    /**
     * Returns the size label of the cup.
     *
     * @return "Medium" as the cup size
     */
    @Override
    public String getSize() {
        return "Medium";
    }

    /**
     * Returns the liquid capacity of the cup in fluid ounces.
     *
     * @return 12.0 fluid ounces
     */
    @Override
    public double getCapacity() {
        return 12.0;
    }
}
