package model;

/**
 * Represents a regular type of coffee truck.
 */
public class SpecialCoffeeTruck extends CoffeeTruck {

    /**
     * Constructs a RegularCoffeeTruck with 6 empty bins.
     *
     * @param location location of the truck
     */
    public SpecialCoffeeTruck(String location) {
        super(location);
    }

    @Override
    public String getType() {
        return "Special";
    }

}
