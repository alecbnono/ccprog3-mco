package model;

public class LightBrew extends Espresso {
    public LightBrew(Water water, CoffeeBeans beans) {
        super(water, beans);
    }

    @Override
    public double getBeanRatio() {
        return 21.0;
    }
}
