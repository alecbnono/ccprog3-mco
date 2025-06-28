package model;

/**
 * Represents coffee beans as a type of Item, measured in grams.
 */
public class CoffeeBeans extends Item {

    private final double OZ_TO_GRAMS = 28.34952;

    /**
     * Constructs a CoffeeBeans item with a given quantity.
     *
     * @param quantity the quantity of coffee beans in grams
     */
    public CoffeeBeans(double quantity) {
        super(quantity, 1008);
        this.name = "Coffee Beans";
        this.unit = "grams";
    }

    /**
     * Constructs a CoffeeBeans item with quantity initialized to 0 grams.
     */
    public CoffeeBeans() {
        super(0, 1008);
        this.name = "Coffee Beans";
        this.unit = "grams";
    }
    
}
