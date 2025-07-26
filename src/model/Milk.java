package model;

/**
 * Represents milk as an ingredient.
 * Measured in fluid ounces.
 */
public class Milk extends Ingredient {

    /**
     * Constructs a Milk instance with zero quantity.
     */
    public Milk() {
        super();
        this.maxAmount = 640;
    }

    /**
     * Constructs a Milk instance with a specified starting quantity.
     *
     * @param quantity the initial amount in fluid ounces
     */
    public Milk(double quantity) {
        super(quantity);
    }

    /**
     * Returns the type of ingredient.
     *
     * @return "Milk"
     */
    @Override
    public String getType() {
        return "Milk";
    }

    /**
     * Returns the unit used to measure milk.
     *
     * @return "fl. oz."
     */
    @Override
    public String getUnit() {
        return "fl. oz.";
    }
}
