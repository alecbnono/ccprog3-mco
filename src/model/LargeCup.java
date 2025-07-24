package model;

public class LargeCup extends CoffeeCup {

    public LargeCup(int amount) {
        super(amount);
        this.maxAmount = 80;
    }

    public LargeCup() {
        super();
        this.maxAmount = 40;
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
