package model;

/**
 * CoffeeDrink
 */
public abstract class CoffeeDrink {

    protected StorageBin inventory;
    protected String liquid;
    protected CoffeeCup cup;

    public CoffeeDrink(StorageBin inventory) {
        this.inventory = inventory;
    }

    public abstract int getRatio();

    public abstract String getName();

    public boolean prepare(CoffeeCup cup, Espresso espresso) {
        this.cup = cup;
        double cupCapacity = cup.getCapacity();
        double ratio = this.getRatio();

        double espressoAmount = cupCapacity * 1 / (ratio + 1);
        double liquidAmount = cupCapacity * ratio / (ratio + 1);
        return espresso.prepare(espressoAmount) && inventory.consume(this.liquid, liquidAmount);
    }

    public CoffeeCup getCupUsed() {
        return cup;
    }
}
