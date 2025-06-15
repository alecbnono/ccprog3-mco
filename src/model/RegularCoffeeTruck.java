package model;

import java.util.Scanner;

/**
 * RegularCoffeeTruck
 */
public class RegularCoffeeTruck extends CoffeeTruck {

    CoffeeTruck coffeeTruck = new CoffeeTruck();

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
    public int getsmallCup() {
        return smallCup;
    }
    public int getmediumCup() {
        return mediumCup;
    }
    public int getlargeCup() {
        return largeCup;
    }
    public float getcoffeeBeans() {
        return coffeeBeans;
    }
    public float getmilk() {
        return milk;
    }
    public float getwater() {
        return water;
    }
    public void setsmallCup(int smallCup) {
        this.smallCup = smallCup;
    }
    public void setmediumCup(int mediumCup) {
        this.mediumCup = mediumCup;
    }
    public void setlargeCup(int largeCup) {
        this.largeCup = largeCup;
    }
    public void setcoffeeBeans(float coffeeBeans) {
        this.coffeeBeans = coffeeBeans;
    }
    public void setmilk(float milk) {
        this.milk = milk;
    }
    public void setwater(float water) {
        this.water = water;
    }
}
