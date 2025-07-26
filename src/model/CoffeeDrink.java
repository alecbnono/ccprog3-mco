package model;

/**
 * Abstract base class representing a coffee drink made with espresso and another liquid (e.g., water or milk).
 * Subclasses define the name and espresso-to-liquid ratio for each specific drink type.
 */
public abstract class CoffeeDrink {

    /** Inventory used to retrieve ingredients (liquid) */
    protected StorageBin inventory;

    /** Type of liquid to be used (e.g., "Milk", "Water") */
    protected String liquid;

    /** The coffee cup used to prepare this drink */
    protected CoffeeCup cup;

    /**
     * Constructs a CoffeeDrink with a given ingredient inventory.
     *
     * @param inventory the storage bin containing liquid ingredients
     */
    public CoffeeDrink(StorageBin inventory) {
        this.inventory = inventory;
    }

    /**
     * Gets the ratio of liquid to espresso.
     * For example, 2 means 2 parts liquid to 1 part espresso.
     *
     * @return the espresso-to-liquid ratio
     */
    public abstract int getRatio();

    /**
     * Returns the display name of the drink.
     *
     * @return the name of the drink
     */
    public abstract String getName();

    /**
     * Prepares the drink using the provided cup and a given espresso source.
     * It calculates ingredient portions based on the cup size and the drink ratio.
     *
     * @param cup      the cup used to serve the drink
     * @param espresso the espresso source
     * @return {@code true} if both espresso and liquid were successfully consumed; {@code false} otherwise
     */
    public boolean prepare(CoffeeCup cup, Espresso espresso) {
        this.cup = cup;
        double cupCapacity = cup.getCapacity();
        double ratio = this.getRatio();

        // Divide the cup's volume into espresso and liquid based on the defined ratio
        double espressoAmount = cupCapacity * 1 / (ratio + 1);
        double liquidAmount = cupCapacity * ratio / (ratio + 1);

        // Prepare espresso and consume the appropriate liquid
        return espresso.prepare(espressoAmount) && inventory.consume(this.liquid, liquidAmount);
    }

    /**
     * Returns the cup used in this drink preparation.
     *
     * @return the cup object
     */
    public CoffeeCup getCupUsed() {
        return cup;
    }
}
