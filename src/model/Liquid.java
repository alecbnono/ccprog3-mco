package model;

public class Liquid extends Item {

    public Liquid(String name, double quantity) {

        super(quantity, 640);

        // defaults to water if wrong name passed
        if (name.toLowerCase().equals("milk") ||
                name.toLowerCase().equals("water")) {
            this.name = name;
        } else {
            this.name = "Water";
        }

        this.unit = "fl. oz.";
    }

    public Liquid(String name) {

        super(0, 640);

        // defaults to water if wrong name passed
        if (name.toLowerCase().equals("milk") ||
                name.toLowerCase().equals("water")) {
            this.name = name;
        } else {
            this.name = "Water";
        }

        this.unit = "fl. oz.";
    }
}
