package model;
import java.util.ArrayList;

/**
 * CoffeeTruck
 */
public abstract class CoffeeTruck {
    protected String location;
    protected String type;
    protected ArrayList<StorageBin> Inventory;

    public CoffeeTruck(String location, String type) {
        this.location = location;
        this.type = type;
        this.Inventory = new ArrayList<>();
    }

    public void addInventory(StorageBin storageBin) {
        this.Inventory.add(storageBin);
    }
}
