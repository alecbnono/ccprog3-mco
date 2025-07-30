package model;

/**
 * Represents a special type of coffee truck that can serve custom espresso ratios,
 * add-ons, and extra shots. This truck uses an additional inventory bin for special ingredients.
 */
public class SpecialCoffeeTruck extends CoffeeTruck {

    private StorageBin specialInventory;

    /**
     * Constructs a {@code SpecialCoffeeTruck} with 6 regular bins and 1 special bin.
     *
     * @param location the location of this truck
     * @param business the reference to the main CoffeeBusiness logic
     */
    public SpecialCoffeeTruck(String location, CoffeeBusiness business) {
        super(location, business);
        specialInventory = new StorageBin(2);
    }

    /**
     * Returns the truck type.
     *
     * @return the string "Special"
     */
    @Override
    public String getType() {
        return "Special";
    }

    /**
     * Gets the special inventory bin used for custom espresso shots or add-ons.
     *
     * @return the special inventory bin
     */
    public StorageBin getSpecialInventory() {
        return specialInventory;
    }

    /**
     * Sets the special inventory and updates the coffee maker with it.
     *
     * @param specialInventory the new special inventory bin
     */
    public void setSpecialInventory(StorageBin specialInventory) {
        this.specialInventory = specialInventory;
        this.coffeeMaker.setSpecialInventory(specialInventory);
    }

    /**
     * Serves a coffee drink with a specific espresso ratio and generates a receipt.
     *
     * @param drinkName     the name of the coffee drink
     * @param size          the size of the cup (e.g., "Small", "Medium", "Large")
     * @param espressoRatio the espresso ratio to be used in the drink
     * @return a receipt for the transaction, or null if the drink could not be made
     */
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

    /**
     * Applies an add-on product (e.g., milk, syrup) and generates a receipt.
     *
     * @param addOnName the name of the add-on to apply
     * @return a receipt for the add-on, or null if the add-on could not be made
     */
    public Receipt applyAddOn(String addOnName) {
        AddOn addOn = coffeeMaker.makeAddOn(addOnName);

        if (addOn != null) {
            Receipt receipt = new Receipt(this.location, addOn, business.getPriceList().getAddOnPrice());
            business.getTransactionList().addReceipt(receipt);
            return receipt;
        }
        return null;
    }

    /**
     * Applies an extra espresso shot of a specific type and generates a receipt.
     *
     * @param espressoType the espresso type (e.g., "Standard", "Strong")
     * @return a receipt for the extra shot, or null if it could not be made
     */
    public Receipt applyExtraShot(String espressoType) {
        Espresso shot = coffeeMaker.makeEspresso(espressoType);

        if (shot != null) {
            Receipt receipt = new Receipt(this.location, shot, business.getPriceList().getAddOnPrice());
            business.getTransactionList().addReceipt(receipt);
            return receipt;
        }
        return null;
    }

    /**
     * Applies an extra espresso shot with a custom ratio and generates a receipt.
     *
     * @param espressoRatio the espresso ratio (bean-to-water percentage) for the shot
     * @return a receipt for the extra shot, or null if it could not be made
     */
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
