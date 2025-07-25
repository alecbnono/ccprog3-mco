package model;

import java.util.ArrayList;

/**
 * Represents a coffee truck with a specific location, type, inventory, and
 * recipe handler.
 */
public abstract class CoffeeTruck {
    protected String location;
    protected StorageBin inventory;
    protected int maxBins;
    protected CoffeeMaker coffeeMaker;
    protected CoffeeBusiness business;

    /**
     * Constructs a CoffeeTruck at a specified location.
     *
     * @param location the truck's location
     */
    public CoffeeTruck(String location, CoffeeBusiness business) {
        this.location = location;
        this.inventory = new StorageBin();
        this.coffeeMaker = new CoffeeMaker(inventory);
        this.maxBins = 8;
        this.business = business;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gets the truck type (e.g., "regular").
     *
     * @return truck type
     */
    public abstract String getType();

    public StorageBin getInventory() {
        return inventory;
    }

    public boolean serveCoffee(String drinkName, String size, String espressoType) {

        CoffeeDrink drink = coffeeMaker.makeDrink(drinkName, size, espressoType);
        CoffeeCup cup;

        if (drink != null) {

            cup = drink.getCupUsed();
            business.getPriceList();

            business.getTransactionList().addReceipt(new Receipt(this.location, drink, 100.0));
            return true;
        }
        return false;

    }

}
