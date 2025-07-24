package model;

public class SucroseSyrup extends AddOn{
    public SucroseSyrup() {
        super();
    }

    public SucroseSyrup(double amount) {
        super(amount);
    }

    @Override
    public String getFlavor() {
        return "Sucrose";
    }
}
