package model;

public class LargeCup extends CoffeeCup {

    public LargeCup(int quantity) {
        super(quantity);
        this.maxQuantity = 80;
    }

    @Override
    public String getSize() {
        return "Large";
    }

    @Override
    public double getCapacity() {
        return 16.0;
    }
}
