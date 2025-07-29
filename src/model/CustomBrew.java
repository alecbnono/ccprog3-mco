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
    public String getType() {
        return "Custom Brew";
    }

    @Override
    public double getBeanRatio() {
        return ratio;
    }

}
