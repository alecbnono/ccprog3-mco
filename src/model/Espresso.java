package model;

/**
 * Abstract base class representing an espresso preparation behavior.
 * <p>
 * Subclasses define the type of espresso and specify the coffee bean-to-water ratio.
 * The {@code prepare} method calculates the amount of each ingredient needed
 * based on a total fluid ounce volume.
 * </p>
 */
public abstract class Espresso {

    /** Inventory containing coffee beans and water used for brewing */
    protected StorageBin inventory;

    /**
     * Constructs an Espresso with the given inventory of ingredients.
     *
     * @param inventory the {@link StorageBin} from which ingredients are consumed
     */
    public Espresso(StorageBin inventory) {
        this.inventory = inventory;
    }

    /**
     * Returns the type of espresso (e.g., "Strong Brew", "Light Brew", etc.).
     *
     * @return a string representing the espresso type
     */
    public abstract String getType();

    /**
     * Returns the ratio of water to beans used in this espresso preparation.
     * <p>
     * For example, a ratio of 3 means 3 parts water to 1 part beans.
     * </p>
     *
     * @return the water-to-bean ratio as a double
     */
    public abstract double getBeanRatio();

    /**
     * Prepares an espresso shot of the specified amount in fluid ounces.
     * <p>
     * The method calculates the amount of coffee beans (in grams)
     * and water (in fl. oz.) based on the bean ratio and consumes them
     * from the inventory.
     * </p>
     *
     * @param amount the total espresso volume to prepare (in fluid ounces)
     * @return {@code true} if both coffee beans and water were successfully consumed;
     *         {@code false} if either ingredient was insufficient
     */
    public boolean prepare(double amount) {
        double ratio = this.getBeanRatio();

        // Convert the amount to proportional bean grams and water ounces
        double beanGrams = (28.34952 / (ratio + 1)) * amount; // 1 fl oz ≈ 28.35 grams total content
        double waterOz = (ratio / (ratio + 1)) * amount;

        boolean beanSuccess = inventory.consume("Coffee Beans", beanGrams);
        boolean waterSuccess = inventory.consume("Water", waterOz);

        return beanSuccess && waterSuccess;
    }
}
