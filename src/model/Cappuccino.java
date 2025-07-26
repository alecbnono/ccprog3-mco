package model;

/**
 * Represents a Cappuccino coffee drink.
 * Consists of 1 part espresso and 2 parts milk.
 */
public class Cappuccino extends CoffeeDrink {

    /**
     * Constructs a Cappuccino drink with access to a storage bin for milk.
     *
     * @param inventory the storage bin containing ingredients
     */
    public Cappuccino(StorageBin inventory) {
        super(inventory);
        this.liquid = "Milk";
    }

    /**
     * {@inheritDoc}
     * For Cappuccino, the espresso-to-liquid ratio is 1:2.
     */
    @Override
    public int getRatio() {
        return 2;
    }

    /**
     * {@inheritDoc}
     * @return "Cappuccino"
     */
    @Override
    public String getName() {
        return "Cappuccino";
    }
}
