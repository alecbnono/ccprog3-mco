package model;

public class StandardBrew extends Espresso {
    public StandardBrew(StorageBin inventory) {
        super(inventory);
    }

    @Override
    public double getBeanRatio() {
        return 19.0;
    }
}
