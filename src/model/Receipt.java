package model;

import java.time.LocalDateTime;

/**
 * Represents a receipt for a transaction made at a coffee truck.
 * <p>
 * A receipt can be for one of the following product types:
 * Espresso, Add-On, or CoffeeDrink. Each receipt records the time of purchase,
 * product details, location, and final price.
 * </p>
 */
public class Receipt {

    /** Time when the transaction occurred. */
    private LocalDateTime transactionTime;

    /** Location of the coffee truck where the transaction took place. */
    private String location;

    /** Espresso product involved in the transaction (if applicable). */
    private Espresso espresso;

    /** Add-on product involved in the transaction (if applicable). */
    private AddOn addOn;

    /** Coffee drink involved in the transaction (if applicable). */
    private CoffeeDrink drink;

    /** String identifier for the type of product. */
    private String productType;

    /** Final transaction price. */
    private double price;

    /**
     * Constructs a receipt for a {@link CoffeeDrink} product.
     *
     * @param location the location of the truck
     * @param product  the coffee drink purchased
     * @param price    the total price
     */
    public Receipt(String location, CoffeeDrink product, double price) {
        this.location = location;
        this.drink = product;
        this.productType = "Coffee Drink";
        this.price = price;
        this.transactionTime = LocalDateTime.now();
    }

    /**
     * Constructs a receipt for an {@link AddOn} product.
     *
     * @param location the location of the truck
     * @param product  the add-on purchased
     * @param price    the total price
     */
    public Receipt(String location, AddOn product, double price) {
        this.location = location;
        this.addOn = product;
        this.productType = "Add-On";
        this.price = price;
        this.transactionTime = LocalDateTime.now();
    }

    /**
     * Constructs a receipt for an {@link Espresso} product.
     *
     * @param location the location of the truck
     * @param product  the espresso purchased
     * @param price    the total price
     */
    public Receipt(String location, Espresso product, double price) {
        this.location = location;
        this.espresso = product;
        this.productType = "Espresso";
        this.price = price;
        this.transactionTime = LocalDateTime.now();
    }

    /**
     * Returns the timestamp of the transaction.
     *
     * @return the transaction time
     */
    public LocalDateTime getTime() {
        return transactionTime;
    }

    /**
     * Returns the truck location where the transaction occurred.
     *
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Returns the price paid in the transaction.
     *
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns the name/type of the product involved in the transaction.
     *
     * @return the product name, or null if type is unrecognized
     */
    public String getProduct() {
        return switch (productType) {
            case "Coffee Drink" -> drink.getType();
            case "Add-On" -> addOn.getType();
            case "Espresso" -> espresso.getType();
            default -> null;
        };
    }

    /**
     * Returns a string representation of the receipt formatted for display.
     *
     * @return formatted receipt string
     */
    @Override
    public String toString() {
        if (productType.equals("Coffee Drink")) {
            return String.format(
                    "%-20s (%13s) %6s ₱%.2f",
                    getProduct(),
                    drink.getEspressoUsed().getType(),
                    drink.getCupUsed().getSize(),
                    getPrice()
            );
        } else {
            return String.format(
                    "%-20s (%13s) %6s ₱%.2f",
                    getProduct(),
                    "",
                    "",
                    getPrice()
            );
        }
    }
}
