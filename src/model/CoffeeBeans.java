package model;

public class CoffeeBeans extends Item implements Ingredient {
    public CoffeeBeans(double quantity, double maxQuantity) {
        super("Coffee Beans", quantity, maxQuantity);
    }
}
