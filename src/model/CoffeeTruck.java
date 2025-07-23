package model;

import java.util.ArrayList;

/**
 * Represents a coffee truck with a specific location, type, inventory, and
 * recipe handler.
 */
public abstract class CoffeeTruck {
    protected String location;
    protected ArrayList<StorageBin> inventory;
    protected int maxBins;
    protected CoffeeMaker coffeeMaker;

    /**
     * Constructs a CoffeeTruck at a specified location.
     *
     * @param location the truck's location
     */
    public CoffeeTruck(String location) {
        this.location = location;
        this.inventory = new ArrayList<StorageBin>();
        this.coffeeMaker = new CoffeeMaker();
        this.maxBins = 8;
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

    /**
     * Gets a specific storage bin by index.
     *
     * @param boxNo the index of the bin
     * @return the corresponding StorageBin or null
     */
    public StorageBin getBin(int boxNo) {
        if (boxNo >= 0 && boxNo < maxBins) {
            return inventory.get(boxNo);
        }
        return null;
    }

    /**
     * Returns the total number of bins in the truck.
     *
     * @return bin count
     */
    public int getBinCount() {
        return maxBins;
    }

    /**
     * Serves a specific coffee based on type and size.
     *
     * @param type the coffee type (e.g., "latte")
     * @param size the drink size
     * @return true if coffee was successfully served
     */
    // for type: "cappuccino", "americano", "latte"
    // for size: "small", "medium", "large"
    public boolean serveCoffee(String type, String size) {

        return false;
    }
}
