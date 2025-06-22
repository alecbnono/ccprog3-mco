package model;

/**
 * RegularCoffeeTruck
 */
public class RegularCoffeeTruck extends CoffeeTruck {

    public RegularCoffeeTruck(String location) {
        super(location);
        this.type = "regular";
        this.maxBins = 6;
    }

}
