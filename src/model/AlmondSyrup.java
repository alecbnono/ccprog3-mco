package model;

/**
 * The {@code AlmondSyrup} class represents a specific type of {@link AddOn}
 * used in the coffee truck system. It models almond-flavored syrup, which
 * can be added to beverages.
 * <p>
 * This class provides information specific to almond syrup, such as its type
 * and measurement unit.
 * </p>
 *
 * @author
 */
public class AlmondSyrup extends AddOn {

    /**
     * Constructs an {@code AlmondSyrup} object with an initial amount of 0.
     */
    public AlmondSyrup() {
        super();
    }

    /**
     * Constructs an {@code AlmondSyrup} object with the specified initial amount.
     * If the amount exceeds the maximum allowed by {@link AddOn}, it will be capped.
     *
     * @param amount the initial amount of almond syrup
     */
    public AlmondSyrup(double amount) {
        super(amount);
    }

    /**
     * Returns the type of this add-on, which is "Almond".
     *
     * @return the type of syrup as a {@code String}
     */
    @Override
    public String getType() {
        return "Almond";
    }

    /**
     * Returns the unit of measurement for almond syrup, which is fluid ounces.
     *
     * @return the unit as a {@code String} ("fl. oz.")
     */
    @Override
    public String getUnit() {
        return "fl. oz.";
    }
}
