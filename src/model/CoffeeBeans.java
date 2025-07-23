package model;

public class CoffeeBeans extends Ingredient {

    public CoffeeBeans() {
        super();
        this.maxAmount = 1008;
    }

    public CoffeeBeans(double quantity) {
        super(quantity);
    }

    @Override
    public String getType() {
        return "Coffee Beans";
    }

    @Override
    public String getUnit() {
        return "grams";
    }
}
