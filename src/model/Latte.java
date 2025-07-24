package model;

/**
 * Latte
 */
public class Latte extends CoffeeDrink {

    public Latte(StorageBin inventory) {
        super(inventory);
        this.liquid = "Milk";
    }

    @Override
    public int getRatio() {
        return 4;
    }

    @Override
    public String getName() {
        return "Latte";
    }
}
