package model;

public class Water extends Ingredient {

    public Water() {
        super();
        this.maxAmount = 640;
    }

    public Water(double quantity) {
        super(quantity);
    }

    @Override
    public String getType() {
        return "Water";
    }

    @Override
    public String getUnit() {
        return "fl. oz.";
    }
}
