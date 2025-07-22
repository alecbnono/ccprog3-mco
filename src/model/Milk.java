package model;

public class Milk extends Item implements Ingredient {
    public Milk(double quantity, double maxQuantity) {
        super("Milk", quantity, maxQuantity);
    }
}
