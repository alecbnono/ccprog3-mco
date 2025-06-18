package model;

public class CoffeeBeans extends Item{

    private final double ozToGrams = 28.34952;

    public CoffeeBeans(double quantity) {
        this.name = "Coffee Beans";
        this.quantity = quantity;
        this.unit = "grams";
    }
    public boolean consume(double amount){
        if(amount * ozToGrams <= 0 || quantity < amount * ozToGrams){
            return false;
        }
        else {
            quantity -= amount * ozToGrams;
            return true;
        }
    }
}
