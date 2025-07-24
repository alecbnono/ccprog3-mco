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
    }

}
