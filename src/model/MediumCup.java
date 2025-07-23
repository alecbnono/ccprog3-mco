package model;

public class MediumCup extends CoffeeCup {

    public MediumCup(int quantity) {
        super(quantity);
        this.maxQuantity = 64;
    }

    @Override
    public String getSize() {
        return "Medium";
    }

    @Override
    public double getCapacity() {
        return 12.0;
    }
}
