package model;

/**
 * Cappuccino
 */
public class Cappuccino extends CoffeeDrink {

    public Cappuccino(StorageBin inventory) {
        super(inventory);
        this.liquid = "Milk";
    }

    @Override
    public int getRatio() {
        return 2;
    }

    @Override
    public String getName() {
        return "Cappuccino";
    }
}
