package model;

public class LightBrew extends Espresso {
    public LightBrew(StorageBin inventory) {
        super(inventory);
    }

    @Override
    public double getBeanRatio() {
        return 21.0;
    }
}
