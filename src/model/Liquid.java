package model;

/**
 * Represents a liquid ingredient like water or milk.
 */
public class Liquid extends Item {

    /**
     * Constructs a Liquid with a name and quantity.
     * Defaults to water if name is invalid.
     *
     * @param name     name of the liquid
     * @param quantity amount in fluid ounces
     */
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

    /**
     * Constructs a Liquid with a name and zero quantity.
     * Defaults to water if name is invalid.
     *
     * @param name name of the liquid
     */
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
