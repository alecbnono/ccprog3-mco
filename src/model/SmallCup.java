package model;

public class SmallCup extends CoffeeCup {

    public SmallCup(int amount) {
        super(amount);
        this.maxAmount = 40;
    }

    public SmallCup() {
        super();
        this.maxAmount = 40;
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
