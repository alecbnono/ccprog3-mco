package model;

public class Liquid extends Item{

    public Liquid(String name, double quantity) {
        this.name = name;
        this.quantity = quantity;
        this.unit = "fl. oz.";
    }
}
