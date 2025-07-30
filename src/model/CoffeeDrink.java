package model;

/**
 * The {@code CoffeeDrink} class serves as an abstract base for all coffee drink types
 * that combine espresso with another liquid ingredient (e.g., water, milk).
 * <p>
 * Subclasses define the specific espresso-to-liquid ratio and drink type name.
 * This class handles ingredient portioning and consumption from the inventory when
 * preparing a drink.
 * </p>
 *
 * It uses a {@link StorageBin} to retrieve the required ingredients, and tracks
 * the {@link CoffeeCup} and {@link Espresso} used in preparation.
 *
 * @author
 */
public abstract class CoffeeDrink {

    /** The inventory of ingredients, such as water, milk, and cups. */
    protected StorageBin inventory;

    /** The name of the liquid ingredient used in this drink (e.g., "Milk", "Water"). */
    protected String liquid;

    /** The coffee cup used to serve the drink. */
    protected CoffeeCup cup;

    /** The espresso shot used in the drink. */
    protected Espresso espresso;

    /**
     * Constructs a {@code CoffeeDrink} with the specified storage bin for retrieving ingredients.
     *
     * @param inventory the {@link StorageBin} containing ingredients and cups
     */
    public CoffeeDrink(StorageBin inventory) {
        this.inventory = inventory;
    }

    /**
     * Returns the ratio of liquid to espresso for this drink.
     * For example, a ratio of 2 means 2 parts liquid for every 1 part espresso.
     *
     * @return the espresso-to-liquid ratio
     */
    public abstract int getRatio();

    /**
     * Returns the display name or type of this coffee drink (e.g., "Americano", "Latte").
     *
     * @return the name of the drink
     */
    public abstract String getType();

    /**
     * Prepares the coffee drink using the given cup and espresso.
     * <p>
     * It calculates the required amounts of espresso and liquid based on
     * the drink's ratio and the cup's total capacity. Then, it attempts to:
     * <ul>
     *   <li>Prepare the espresso shot</li>
     *   <li>Consume the required liquid from inventory</li>
     *   <li>Consume one cup from inventory</li>
     * </ul>
     *
     * @param cup      the {@link CoffeeCup} to use for the drink
     * @param espresso the {@link Espresso} used to brew the coffee
     * @return {@code true} if all ingredients were successfully consumed and espresso prepared;
     *         {@code false} otherwise
     */
    public boolean prepare(CoffeeCup cup, Espresso espresso) {
        this.cup = cup;
        this.espresso = espresso;
        double cupCapacity = cup.getCapacity();
        double ratio = this.getRatio();

        // Divide the cup's volume based on the espresso-to-liquid ratio
        double espressoAmount = cupCapacity * 1 / (ratio + 1);
        double liquidAmount = cupCapacity * ratio / (ratio + 1);

        boolean espressoSuccess = espresso.prepare(espressoAmount);
        boolean liquidSuccess = inventory.consume(this.liquid, liquidAmount);
        boolean cupSuccess = inventory.consume(this.cup.getType(), 1);

        return espressoSuccess && liquidSuccess && cupSuccess;
    }

    /**
     * Returns the cup used for the most recent preparation of this drink.
     *
     * @return the {@link CoffeeCup} instance
     */
    public CoffeeCup getCupUsed() {
        return cup;
    }

    /**
     * Returns the espresso used for the most recent preparation of this drink.
     *
     * @return the {@link Espresso} instance
     */
    public Espresso getEspressoUsed() {
        return espresso;
    }
}
