package model;

public class StrongBrew extends Espresso {
    public StrongBrew(Water water, CoffeeBeans beans) {
        super(water, beans);
    }

    @Override
    public double getBeanRatio() {
        return 16.0;
    }
}
