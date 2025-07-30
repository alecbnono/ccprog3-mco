package model;

/**
 * Represents a light brew espresso, which uses a higher ratio of water to coffee beans.
 * <p>
 * The bean-to-water ratio is set to 21.0, meaning more water per unit of beans for a lighter taste.
 * </p>
 */
public class LightBrew extends Espresso {

    /**
     * Constructs a LightBrew espresso using the provided storage inventory.
     *
     * @param inventory the {@link StorageBin} containing required ingredients like water and coffee beans
     */
    public LightBrew(StorageBin inventory) {
        super(inventory);
    }

    /**
     * Returns the type of espresso.
     *
     * @return the string "Light Brew"
     */
    @Override
    public String getType() {
        return "Light Brew";
    }

    /**
     * Returns the bean-to-water ratio used for light brew.
     * A higher ratio indicates more water, resulting in a lighter brew.
     *
     * @return 21.0 as the bean-to-water ratio
     */
    @Override
    public double getBeanRatio() {
        return 21.0;
    }
}
