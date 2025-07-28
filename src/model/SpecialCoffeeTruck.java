package model;

/**
 * Represents a regular type of coffee truck.
 */
public class SpecialCoffeeTruck extends CoffeeTruck {

    private StorageBin specialInventory;

    /**
     * Constructs a RegularCoffeeTruck with 6 empty bins.
     *
     * @param location location of the truck
     */
    public SpecialCoffeeTruck(String location, CoffeeBusiness business) {
        super(location, business);
        specialInventory = new StorageBin(2);
    }

    @Override
    public String getType() {
        return "Special";
    }

    public StorageBin getSpecialInventory() {
        return specialInventory;
    }

    public void setSpecialInventory(StorageBin specialInventory) {
        this.specialInventory = specialInventory;
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
