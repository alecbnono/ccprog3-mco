package model;

public class StandardBrew extends Espresso {
    public StandardBrew(Water water, CoffeeBeans beans, double flOz) {
        super(water, beans, flOz);
    }

    @Override
    public double getBeanRatio() {
        return 1.0 / 19.0;
    }
}
