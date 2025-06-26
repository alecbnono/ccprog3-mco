package model;

import java.util.ArrayList;

/**
 * CoffeeTruck
 */
public class CoffeeTruck {
    protected String location;
    protected String type;
    protected ArrayList<StorageBin> inventory;
    protected int maxBins;
    protected CoffeeRecipe coffeeRecipe;
    protected PriceList priceList;

    public CoffeeTruck(String location) {
        this.location = location;
        this.inventory = new ArrayList<StorageBin>();
        this.coffeeRecipe = new CoffeeRecipe();
        this.priceList = new PriceList();
    }

    public String getLocation() {
        return location;
    }

    public String getType() {
        return type;
    }

    public StorageBin getBin(int boxNo) {
        if (boxNo >= 0 && boxNo < maxBins) {
            return inventory.get(boxNo);
        }
        return null;
    }
    public PriceList getPriceList() {
        return priceList;
    }

    public int getBinCount() {
        return maxBins;
    }

    // for type: "cappuccino", "americano", "latte"
    // for size: "small", "medium", "large"
    public boolean serveCoffee(String type, String size) {
        switch (type.toLowerCase()) {
            case "americano":
                return coffeeRecipe.makeAmericano(inventory, size);
            case "cappuccino":
                return coffeeRecipe.makeCappuccino(inventory, size);
            case "latte":
                return coffeeRecipe.makeLatte(inventory, size);
            default:
                return false;
        }
    }
}
