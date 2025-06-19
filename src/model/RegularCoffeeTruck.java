package model;

import java.util.Scanner;

/**
 * RegularCoffeeTruck
 */
public class RegularCoffeeTruck extends CoffeeTruck {

    public RegularCoffeeTruck(String location) {
        super(location);
        this.type = type;
        this.maxBins = 6;
    }

}
