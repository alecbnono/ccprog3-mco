package model;

/**
 * Represents a Hazelnut syrup add-on for coffee drinks.
 * <p>
 * This class extends {@link AddOn} and specifies the type and unit of measurement.
 * </p>
 */
public class HazelnutSyrup extends AddOn {

    /**
     * Constructs a HazelnutSyrup with a default amount (usually zero).
     */
    public HazelnutSyrup() {
        super();
    }

    /**
     * Constructs a HazelnutSyrup with a specified initial amount.
     *
     * @param amount the initial amount of syrup in fluid ounces
     */
    public HazelnutSyrup(double amount) {
        super(amount);
    }

    /**
     * Returns the type of this add-on.
     *
     * @return the string "Hazelnut"
     */
    @Override
    public String getType() {
        return "Hazelnut";
    }

    /**
     * Returns the unit of measurement for the syrup.
     *
     * @return the string "fl. oz."
     */
    @Override
    public String getUnit() {
        return "fl. oz.";
    }
}
