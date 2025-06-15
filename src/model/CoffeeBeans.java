package model;

public class CoffeeBeans extends Item{

    private final double ozToGrams = 28.34952;

    public CoffeeBeans(double quantity) {
        this.name = "Coffee Beans";
        this.quantity = quantity;
        this.unit = "grams";
    }

}
