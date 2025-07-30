package model;

/**
 * Represents a regular type of coffee truck.
 * <p>
 * This class extends {@link CoffeeTruck} and provides a specific truck type
 * label ("Regular"). It inherits all behavior from the parent class and only
 * customizes the type identifier.
 * </p>
 */
public class RegularCoffeeTruck extends CoffeeTruck {

    /**
     * Constructs a {@code RegularCoffeeTruck} with the specified location
     * and a reference to the {@link CoffeeBusiness} managing it.
     * The truck is initialized with 6 empty bins by the superclass.
     *
     * @param location the operating location of the truck
     * @param business the coffee business this truck belongs to
     */
    public RegularCoffeeTruck(String location, CoffeeBusiness business) {
        super(location, business);
    }

    /**
     * Returns the type of the truck as a string.
     *
     * @return "Regular" as the truck type
     */
    @Override
    public String getType() {
        return "Regular";
    }
}
