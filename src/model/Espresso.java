package model;

public abstract class Espresso {

    protected StorageBin inventory;

    public Espresso(StorageBin inventory) {
        this.inventory = inventory;
    }

    public abstract String getType();

    public abstract double getBeanRatio();

    // amount in fl oz.
    public boolean prepare(double amount) {
        double ratio = this.getBeanRatio();
        double beanGrams = 28.34952 / (ratio + 1) * amount;
        double waterOz = ratio / (ratio + 1) * amount;

        boolean beanSuccess = inventory.consume("Coffee Beans", beanGrams);
        boolean waterSuccess = inventory.consume("Water", waterOz);

        return beanSuccess && waterSuccess;
    }
}
