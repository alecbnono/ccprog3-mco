package model;

public class HazelnutSyrup extends AddOn {
    public HazelnutSyrup() {
        super();
    }

    public HazelnutSyrup(double amount) {
        super(amount);
    }

    @Override
    public String getType() {
        return "Hazelnut";
    }

    @Override
    public String getUnit() {
        return "fl. oz.";
    }
}
