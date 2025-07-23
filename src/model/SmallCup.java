package model;

public class SmallCup extends CoffeeCup {

    public SmallCup(int quantity) {
        super(quantity);
        this.maxQuantity = 40;
    }

    @Override
    public String getSize() {
        return "Small";
    }

    @Override
    public double getCapacity() {
        return 8.0;
    }
}
