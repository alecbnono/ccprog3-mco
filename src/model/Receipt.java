package model;

import java.time.LocalDateTime;

/**
 * Reciept
 */
public class Receipt {

    private LocalDateTime transactionTime;
    private String location;
    private Binable product;
    private double price;

    public Receipt(String location, Binable product, double price) {
        this.location = location;
        this.product = product;
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

    public Binable getProduct() {
        return product;
    }

    @Override
    public String toString() {

        if (product instanceof CoffeeDrink) {
            CoffeeDrink drink = (CoffeeDrink) product;

            return String.format("%-20s %6s %.2f", getProduct(), drink.getCupUsed().getSize(), getPrice());
        } else {
            return String.format("%-20s %6s %.2f", getProduct(), "", getPrice());
        }

    }

}
