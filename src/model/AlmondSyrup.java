package model;

public class AlmondSyrup extends AddOn{
    public AlmondSyrup() {
        super();
    }

    public AlmondSyrup(double amount) {
        super(amount);
    }

    @Override
    public String getFlavor() {
        return "Almond";
    }
}
