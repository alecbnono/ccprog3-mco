package model;
import java.util.ArrayList;
/**
 * CoffeeTruck
 */
public class CoffeeTruck {
    protected String location;
    protected String type;
    protected ArrayList<StorageBin> storageBins;
    protected int maxBins;
    protected CoffeeRecipe coffeeRecipe;

    public CoffeeTruck(String location, String type) {
        this.location = location;
        this.type = type;
        this.maxBins = switch (type.toLowerCase()){
            case "regular" -> 8;
            case "special" -> 10;
            default -> 0;
        };
        this.storageBins = new ArrayList<>(maxBins);
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
            return inventory[boxNo];
        }
        return null;
    }






}