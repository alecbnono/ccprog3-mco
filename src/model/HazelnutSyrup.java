package model;

public class HazelnutSyrup extends AddOn{
    public HazelnutSyrup() {
        super();
    }

    public HazelnutSyrup(double amount) {
        super(amount);
    }

    @Override
    public String getFlavor() {
        return "Hazelnut";
    }
}
