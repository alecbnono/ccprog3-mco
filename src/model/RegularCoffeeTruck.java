package model;

import java.util.Scanner;

/**
 * RegularCoffeeTruck
 */
public class RegularCoffeeTruck extends CoffeeTruck {
    private int smallCup, mediumCup, largeCup;
    private float coffeeBeans, milk, water;
    public RegularCoffeeTruck() {
        this.smallCup = 80;
        this.mediumCup = 64;
        this.largeCup = 40;
        this.coffeeBeans = 1008;
        this.milk = 640;
        this.water = 640;
    }
}
