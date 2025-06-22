package model;

public class CoffeeBeans extends Item {

    private final double OZ_TO_GRAMS = 28.34952;

    public CoffeeBeans(double quantity) {
        super(quantity, 1008);
        this.name = "Coffee Beans";
        this.unit = "grams";
    }

    @Override
    public boolean consume(double amount) {
        if (amount * OZ_TO_GRAMS <= 0 || quantity < amount * OZ_TO_GRAMS) {
            return false;
        } else {
            quantity -= amount * OZ_TO_GRAMS;
            return true;
        }
    }
}
