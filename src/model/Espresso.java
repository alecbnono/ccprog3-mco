package model;

public abstract class Espresso {
    protected Water water;
    protected CoffeeBeans beans;

    public Espresso(Water water, CoffeeBeans beans) {
        this.water = water;
        this.beans = beans;
    }

    public abstract double getBeanRatio();

    // amount in fl oz.
    public boolean prepare(double amount) {
        double ratio = this.getBeanRatio();
        double beanGrams = 28.34952 / (ratio + 1) * amount;
        double waterOz = ratio / (ratio + 1) * amount;
        return beans.consume(beanGrams) && water.consume(waterOz);
    }
}
