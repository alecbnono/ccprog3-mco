package model;

import java.time.LocalDateTime;

/**
 * Reciept
 */
public class Receipt {

    private LocalDateTime transactionTime;
    private String location;
    private CoffeeDrink drink;
    private double price;

    public Receipt(String location, CoffeeDrink drink, double price) {

        this.location = location;
        this.drink = drink;
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

    public CoffeeDrink getDrink() {
        return drink;
    }

}
