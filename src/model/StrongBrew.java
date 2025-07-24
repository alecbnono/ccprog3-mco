package model;

public class StrongBrew extends Espresso {
    public StrongBrew(StorageBin inventory) {
        super(inventory);
    }

    @Override
    public double getBeanRatio() {
        return 16.0;
    }
}
