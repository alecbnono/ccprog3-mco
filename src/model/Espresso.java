package model;

public abstract class Espresso {

    private StorageBin inventory;

    public Espresso(StorageBin inventory) {
        this.inventory = inventory;
    }

    public abstract double getBeanRatio();

    // amount in fl oz.
    public boolean prepare(double amount) {
        double ratio = this.getBeanRatio();
        double beanGrams = 28.34952 / (ratio + 1) * amount;
        double waterOz = ratio / (ratio + 1) * amount;
        return inventory.consume("Coffee Beans", beanGrams) &&
                inventory.consume("Water", waterOz);
    }
}
