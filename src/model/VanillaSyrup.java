package model;

public class VanillaSyrup extends AddOn{
    public VanillaSyrup() {
        super();
    }

    public VanillaSyrup(double amount) {
        super(amount);
    }

    @Override
    public String getFlavor() {
        return "Vanilla";
    }
}
