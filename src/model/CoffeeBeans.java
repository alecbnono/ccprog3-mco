package model;

/**
 * Represents coffee beans as an ingredient.
 * Measured in grams with a defined maximum capacity.
 */
public class CoffeeBeans extends Ingredient {

    /**
     * Constructs a CoffeeBeans instance with zero quantity.
     */
    public CoffeeBeans() {
        super();
        this.maxAmount = 1008;
    }

    /**
     * Constructs a CoffeeBeans instance with a specified starting quantity.
     *
     * @param quantity the initial amount in grams
     */
    public CoffeeBeans(double quantity) {
        super(quantity);
    }

    /**
     * Returns the type of ingredient.
     *
     * @return "Coffee Beans"
     */
    @Override
    public String getType() {
        return "Coffee Beans";
    }

    /**
     * Returns the unit used to measure coffee beans.
     *
     * @return "grams"
     */
    @Override
    public String getUnit() {
        return "grams";
    }
}
