package model;

/**
 * Represents a customizable espresso brew that allows users to specify
 * their preferred coffee bean to water ratio.
 * <p>
 * This class is a concrete subclass of {@link Espresso} and is typically used
 * when the customer selects a custom strength for their espresso shot.
 * </p>
 */
public class CustomBrew extends Espresso {

    /** The ratio of coffee beans to water, e.g., 0.25 means 1 part beans to 4 parts water */
    private double ratio;

    /**
     * Constructs a CustomBrew with a given ingredient inventory and bean-to-water ratio.
     *
     * @param inventory the {@link StorageBin} containing the ingredients
     * @param ratio     the coffee bean to water ratio (e.g., 0.25 = 25% beans, 75% water)
     */
    public CustomBrew(StorageBin inventory, double ratio) {
        super(inventory);
        this.ratio = ratio;
    }

    /**
     * Returns the type name of the brew.
     *
     * @return {@code "Custom Brew"}
     */
    @Override
    public String getType() {
        return "Custom Brew";
    }

    /**
     * Returns the ratio of beans used in this custom espresso.
     *
     * @return the bean-to-water ratio as a {@code double}
     */
    @Override
    public double getBeanRatio() {
        return ratio;
    }
}
