package model;

public class StrongBrew extends Espresso {
    public StrongBrew(Water water, CoffeeBeans beans, double flOz) {
        super(water, beans, flOz);
    }

    @Override
    public double getBeanRatio() {
        return 1.0 / 16.0;
    }
}
