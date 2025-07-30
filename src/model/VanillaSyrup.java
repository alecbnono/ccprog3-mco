package model;

/**
 * Represents a vanilla syrup add-on used in coffee drinks.
 * This class extends {@link AddOn} and defines its specific type and unit.
 */
public class VanillaSyrup extends AddOn {

    /**
     * Constructs a VanillaSyrup instance with default amount (typically 0).
     */
    public VanillaSyrup() {
        super();
    }

    /**
     * Constructs a VanillaSyrup instance with a specified amount.
     *
     * @param amount the amount of vanilla syrup in fluid ounces
     */
    public VanillaSyrup(double amount) {
        super(amount);
    }

    /**
     * Returns the type of this add-on.
     *
     * @return the string "Vanilla"
     */
    @Override
    public String getType() {
        return "Vanilla";
    }

    /**
     * Returns the unit of measurement used for this add-on.
     *
     * @return the string "fl. oz."
     */
    @Override
    public String getUnit() {
        return "fl. oz.";
    }
}
