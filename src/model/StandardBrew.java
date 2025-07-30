package model;

/**
 * Represents a standard espresso brew with a fixed bean-to-water ratio.
 * This brew uses 19.0 grams of beans per 1 fl oz of water.
 */
public class StandardBrew extends Espresso {

    /**
     * Constructs a StandardBrew using the specified inventory.
     *
     * @param inventory the storage bin containing ingredients (beans and water)
     */
    public StandardBrew(StorageBin inventory) {
        super(inventory);
    }

    /**
     * Returns the type of espresso brew.
     *
     * @return the string "Standard Brew"
     */
    @Override
    public String getType() {
        return "Standard Brew";
    }

    /**
     * Returns the bean-to-water ratio in grams per ounce for this brew.
     *
     * @return 19.0, the standard brew ratio
     */
    @Override
    public double getBeanRatio() {
        return 19.0;
    }
}
