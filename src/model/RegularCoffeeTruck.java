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
    public RegularCoffeeTruck(String location, CoffeeBusiness business) {
        super(location, business);
    }

    @Override
    public String getType() {
        return "Regular";
    }

}
