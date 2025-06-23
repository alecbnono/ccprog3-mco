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

    public CoffeeTruck(String location) {
        this.location = location;
        this.inventory = new ArrayList<StorageBin>();
        this.coffeeRecipe = new CoffeeRecipe();
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

    public int getBinCount() {
        return maxBins;
    }

}
