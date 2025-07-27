package model;

public class AlmondSyrup extends AddOn {
    public AlmondSyrup() {
        super();
    }

    public AlmondSyrup(double amount) {
        super(amount);
    }

    @Override
    public String getType() {
        return "Almond";
    }

    @Override
    public String getUnit() {
        return "fl. oz.";
    }
}
