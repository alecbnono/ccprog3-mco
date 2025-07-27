package model;

public class SucroseSyrup extends AddOn {
    public SucroseSyrup() {
        super();
    }

    public SucroseSyrup(double amount) {
        super(amount);
    }

    @Override
    public String getType() {
        return "Sucrose";
    }

    @Override
    public String getUnit() {
        return "fl. oz.";
    }
}
