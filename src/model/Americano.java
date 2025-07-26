package model;

/**
 * Represents an Americano coffee drink.
 * Consists of 1 part espresso and 2 parts water.
 */
public class Americano extends CoffeeDrink {

    /**
     * Constructs an Americano drink with access to a storage bin for water.
     *
     * @param inventory the storage bin containing ingredients
     */
    public Americano(StorageBin inventory) {
        super(inventory);
        this.liquid = "Water";
    }

    /**
     * {@inheritDoc}
     * For Americano, the espresso-to-liquid ratio is 1:2.
     */
    @Override
    public int getRatio() {
        return 2;
    }

    /**
     * {@inheritDoc}
     * @return "Americano"
     */
    @Override
    public String getName() {
        return "Americano";
    }
}
