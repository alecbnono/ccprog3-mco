package model;

/**
 * CustomBrew
 */
public class CustomBrew extends Espresso {

    private double ratio;

    public CustomBrew(StorageBin inventory, double ratio) {
        super(inventory);
        this.ratio = ratio;
    }

    @Override
    public double getBeanRatio() {
        return ratio;
    }

}
