package model;

/**
 * Represents a Latte coffee drink.
 * Consists of 1 part espresso and 4 parts milk.
 */
public class Latte extends CoffeeDrink {

    /**
     * Constructs a Latte drink with access to a storage bin for milk.
     *
     * @param inventory the storage bin containing ingredients
     */
    public Latte(StorageBin inventory) {
        super(inventory);
        this.liquid = "Milk";
    }

    /**
     * {@inheritDoc}
     * For Latte, the espresso-to-liquid ratio is 1:4.
     */
    @Override
    public int getRatio() {
        return 4;
    }

    /**
     * {@inheritDoc}
     * @return "Latte"
     */
    @Override
    public String getName() {
        return "Latte";
    }
}
