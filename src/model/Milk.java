package model;

public class Milk extends Ingredient {

    public Milk() {
        super();
        this.maxAmount = 640;
    }

    public Milk(double quantity) {
        super(quantity);
    }

    @Override
    public String getType() {
        return "Milk";
    }

    @Override
    public String getUnit() {
        return "fl. oz.";
    }
}
