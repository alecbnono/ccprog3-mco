package model;

public class CoffeeBeans extends Item {

    private final double OZ_TO_GRAMS = 28.34952;

    public CoffeeBeans(double quantity) {
        super(quantity, 1008);
        this.name = "Coffee Beans";
        this.unit = "grams";
    }

    public CoffeeBeans() {
        super(0, 1008);
        this.name = "Coffee Beans";
        this.unit = "grams";
    }
    
}
