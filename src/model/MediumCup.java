package model;

public class MediumCup extends CoffeeCup {

    public MediumCup(int amount) {
        super(amount);
        this.maxAmount = 64;
    }

    public MediumCup() {
        super();
        this.maxAmount = 64;
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
