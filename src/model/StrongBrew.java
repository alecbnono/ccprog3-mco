package model;

public class StrongBrew extends Espresso {
    public StrongBrew(StorageBin inventory) {
        super(inventory);
    }

    @Override
    public String getType() {
        return "Strong Brew";
    }

    @Override
    public double getBeanRatio() {
        return 16.0;
    }
}
