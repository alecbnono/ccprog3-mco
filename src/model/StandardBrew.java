package model;

public class StandardBrew extends Espresso {
    public StandardBrew(Water water, CoffeeBeans beans) {
        super(water, beans);
    }

    @Override
    public double getBeanRatio() {
        return 19.0;
    }
}
