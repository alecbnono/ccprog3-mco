package model;

public abstract class Espresso {
    protected Water water;
    protected CoffeeBeans beans;
    protected double flOz;

    public Espresso(Water water, CoffeeBeans beans, double flOz) {
        this.water = water;
        this.beans = beans;
        this.flOz = flOz;
    }

    public abstract double getBeanRatio();

    public boolean prepare() {
        double beanRatio = getBeanRatio();
        double beanGrams = flOz * beanRatio * 28.3495;
        double waterOz = flOz - (beanGrams / 28.3495);
        return beans.consume(beanGrams) && water.consume(waterOz);
    }

    public double getFlOz() {
        return flOz;
    }
}
