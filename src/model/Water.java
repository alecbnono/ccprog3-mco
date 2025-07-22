package model;

public class Water extends Item implements Ingredient {
    public Water(double quantity, double maxQuantity) {
        super("Water", quantity, maxQuantity);
    }
}
