package model;

public class ChocolateSyrup extends AddOn {
    public ChocolateSyrup() {
        super();
    }

    public ChocolateSyrup(double amount) {
        super(amount);
    }

    @Override
    public String getFlavor() {
        return "Chocolate";
    }
}
