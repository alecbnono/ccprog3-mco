package;

package model;

/**
 * Americano
 */
public class Americano extends CoffeeDrink {

    public Americano(StorageBin inventory) {
        super(inventory);
        this.liquid = "Water";
    }

    @Override
    public int getRatio() {
        return 2;
    }

    @Override
    public String getName() {
        return "Americano";
    }
}
