package model;

/**
 * Represents water as an ingredient.
 * Measured in fluid ounces.
 */
public class Water extends Ingredient {

    /**
     * Constructs a Water instance with zero quantity.
     */
    public Water() {
        super();
        this.maxAmount = 640;
    }

    /**
     * Constructs a Water instance with a specified starting quantity.
     *
     * @param quantity the initial amount in fluid ounces
     */
    public Water(double quantity) {
        super(quantity);
    }

    /**
     * Returns the type of ingredient.
     *
     * @return "Water"
     */
    @Override
    public String getType() {
        return "Water";
    }

    /**
     * Returns the unit used to measure water.
     *
     * @return "fl. oz."
     */
    @Override
    public String getUnit() {
        return "fl. oz.";
    }
}
