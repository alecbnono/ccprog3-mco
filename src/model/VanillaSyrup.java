package model;

public class VanillaSyrup extends AddOn {
    public VanillaSyrup() {
        super();
    }

    public VanillaSyrup(double amount) {
        super(amount);
    }

    @Override
    public String getType() {
        return "Vanilla";
    }

    @Override
    public String getUnit() {
        return "fl. oz.";
    }
}
