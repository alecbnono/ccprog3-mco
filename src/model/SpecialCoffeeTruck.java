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
        this.coffeeMaker.setSpecialInventory(specialInventory);
    }

    public Receipt serveCoffee(String drinkName, String size, double espressoRatio) {

        CoffeeDrink drink = coffeeMaker.makeDrink(drinkName, size, espressoRatio);
        CoffeeCup cup;

        if (drink != null) {

            cup = drink.getCupUsed();
            Receipt receipt = new Receipt(this.location, drink,
                    business.getPriceList().getPrice(drinkName, cup.getSize()));

            business.getTransactionList().addReceipt(receipt);
            return receipt;
        }
        return null;
    }

    public Receipt applyAddOn(String addOnName) {

        AddOn addOn = coffeeMaker.makeAddOn(addOnName);

        if (addOn != null) {
            Receipt reciept = new Receipt(this.location, addOn, business.getPriceList().getAddOnPrice());

            business.getTransactionList().addReceipt(reciept);
            return reciept;
        }
        return null;
    }

    public Receipt applyExtraShot(String espressoType) {

        Espresso shot = coffeeMaker.makeEspresso(espressoType);

        if (shot != null) {
            Receipt receipt = new Receipt(this.location, shot, business.getPriceList().getAddOnPrice());

            business.getTransactionList().addReceipt(receipt);
            return receipt;
        }
        return null;
    }

    public Receipt applyExtraShot(double espressoRatio) {

        Espresso shot = coffeeMaker.makeEspresso(espressoRatio);

        if (shot != null) {
            Receipt receipt = new Receipt(this.location, shot, business.getPriceList().getAddOnPrice());

            business.getTransactionList().addReceipt(receipt);
            return receipt;
        }
        return null;
    }

}
