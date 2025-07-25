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
    public SpecialCoffeeTruck(String location, CoffeeBusiness business) {
        super(location, business);
    }

    @Override
    public String getType() {
        return "Special";
    }

    public boolean serveCustomCoffee(String drinkName, String size, double ratio) {

        CoffeeDrink drink = coffeeMaker.makeCustomDrink(drinkName, size, ratio);
        CoffeeCup cup;

        if (drink != null) {

            cup = drink.getCupUsed();
            business.getPriceList();

            business.getTransactionList().addReceipt(new Receipt(this.location, drink, 100.0));
            return true;
        }
        return false;

    }

}
