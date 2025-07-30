package model;

import java.time.LocalDateTime;

/**
 * Reciept
 */
public class Receipt {

    private LocalDateTime transactionTime;
    private String location;
    private Espresso espresso;
    private AddOn addOn;
    private CoffeeDrink drink;
    private String productType;
    private double price;

    public Receipt(String location, CoffeeDrink product, double price) {
        this.location = location;
        this.drink = product;
        this.productType = "Coffee Drink";
        this.price = price;
        this.transactionTime = LocalDateTime.now();
    }

    public Receipt(String location, AddOn product, double price) {
        this.location = location;
        this.addOn = product;
        this.productType = "Add-On";
        this.price = price;
        this.transactionTime = LocalDateTime.now();
    }

    public Receipt(String location, Espresso product, double price) {
        this.location = location;
        this.espresso = product;
        this.productType = "Espresso";
        this.price = price;
        this.transactionTime = LocalDateTime.now();
    }

    public LocalDateTime getTime() {
        return transactionTime;
    }

    public String getLocation() {
        return location;
    }

    public double getPrice() {
        return price;
    }

    public String getProduct() {
        if (productType.equals("Coffee Drink")) {
            return drink.getType();
        } else if (productType.equals("Add-On")) {
            return addOn.getType();
        } else if (productType.equals("Espresso")) {
            return espresso.getType();
        } else {
            return null;
        }
    }

    public  getName() {
        if (productType.equals("Coffee Drink")) {

            return;         } else {
            return;
        }
    }

    @Override
    public String toString() {

        if (productType.equals("Coffee Drink")) {

            return String.format("%-20s (%13s) %6s ₱%.2f", getProduct(), drink.getEspressoUsed().getType(),
                    drink.getCupUsed().getSize(), getPrice());
        } else {
            return String.format("%-20s (%13s) %6s ₱%.2f", getProduct(), "", "", getPrice());
        }

    }

}
