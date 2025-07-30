package model;

/**
 * Represents a strong espresso brew that uses a higher ratio of coffee beans to water.
 * Inherits from the abstract {@link Espresso} class.
 */
public class StrongBrew extends Espresso {

    /**
     * Constructs a StrongBrew instance with the specified inventory of ingredients.
     *
     * @param inventory the StorageBin containing ingredients needed for brewing
     */
    public StrongBrew(StorageBin inventory) {
        super(inventory);
    }

    /**
     * Returns the type of this espresso brew.
     *
     * @return the string "Strong Brew"
     */
    @Override
    public String getType() {
        return "Strong Brew";
    }

    /**
     * Returns the ratio of coffee beans (grams) per unit of water for strong brews.
     *
     * @return the bean ratio (16.0)
     */
    @Override
    public double getBeanRatio() {
        return 16.0;
    }
}
