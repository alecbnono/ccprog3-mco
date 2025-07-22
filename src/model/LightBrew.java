package model;

public class LightBrew extends Espresso {
    public LightBrew(Water water, CoffeeBeans beans, double flOz) {
        super(water, beans, flOz);
    }

    @Override
    public double getBeanRatio() {
        return 1.0 / 21.0;
    }
}
