package model;

/**
 * Represents a sucrose syrup add-on for coffee drinks.
 * Extends the {@link AddOn} class to be used as a sweetener.
 */
public class SucroseSyrup extends AddOn {

    /**
     * Constructs a SucroseSyrup object with zero initial amount.
     */
    public SucroseSyrup() {
        super();
    }

    /**
     * Constructs a SucroseSyrup object with the specified amount.
     *
     * @param amount the initial amount of sucrose syrup in fluid ounces
     */
    public SucroseSyrup(double amount) {
        super(amount);
    }

    /**
     * Returns the type of the add-on.
     *
     * @return the string "Sucrose"
     */
    @Override
    public String getType() {
        return "Sucrose";
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
