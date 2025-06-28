package model;

/**
 * Represents a regular type of coffee truck.
 */
public class RegularCoffeeTruck extends CoffeeTruck {

    /**
     * Constructs a RegularCoffeeTruck with 6 empty bins.
     *
     * @param location location of the truck
     */
    public RegularCoffeeTruck(String location) {
        super(location);
        this.type = "regular";
        this.maxBins = 6;

        for (int i = 0; i < maxBins; i++) {
            inventory.add(new StorageBin());
        }
    }

}
