package model;

import java.util.ArrayList;

/**
 * The {@code CoffeeTruck} class represents an abstract base for coffee truck instances
 * in the coffee business system. It defines the shared properties and behaviors
 * of coffee trucks, such as location, inventory, and drink service logic.
 * <p>
 * Concrete subclasses (e.g., {@code RegularCoffeeTruck}, {@code SpecialCoffeeTruck})
 * are expected to specify the truck type.
 * </p>
 *
 * Each truck manages its own {@link StorageBin} inventory and uses a {@link CoffeeMaker}
 * to prepare drinks. The truck is also associated with a parent {@link CoffeeBusiness}
 * for accessing shared pricing and transaction records.
 *
 * @author
 */
public abstract class CoffeeTruck {

    /** The geographic or display location of the truck. */
    protected String location;

    /** The inventory of ingredients and cups specific to this truck. */
    protected StorageBin inventory;

    /** The maximum number of bins supported by the truck. */
    protected int maxBins;

    /** The {@link CoffeeMaker} used to prepare drinks on this truck. */
    protected CoffeeMaker coffeeMaker;

    /** Reference to the parent {@link CoffeeBusiness} that owns this truck. */
    protected CoffeeBusiness business;

    /**
     * Constructs a {@code CoffeeTruck} at a specified location and links it to a business.
     * Initializes a new {@link StorageBin} with a default capacity and sets up the {@link CoffeeMaker}.
     *
     * @param location the location identifier for this truck
     * @param business the {@link CoffeeBusiness} managing this truck
     */
    public CoffeeTruck(String location, CoffeeBusiness business) {
        this.location = location;
        this.inventory = new StorageBin(8);
        this.coffeeMaker = new CoffeeMaker(inventory);
        this.maxBins = 8;
        this.business = business;
    }

    /**
     * Returns the location of this coffee truck.
     *
     * @return the truck location as a {@code String}
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets a new location for the coffee truck.
     *
     * @param location the new location to assign
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Returns the type of the truck (e.g., "regular", "special").
     * This must be implemented by all subclasses.
     *
     * @return the truck type as a {@code String}
     */
    public abstract String getType();

    /**
     * Returns the current inventory used by the truck.
     *
     * @return the {@link StorageBin} object
     */
    public StorageBin getInventory() {
        return inventory;
    }

    /**
     * Replaces the inventory for this truck and updates the {@link CoffeeMaker} to use it.
     *
     * @param storageBin the new {@link StorageBin} to assign
     */
    public void setInventory(StorageBin storageBin) {
        this.inventory = storageBin;
        this.coffeeMaker.setInventory(storageBin);
    }

    /**
     * Serves a coffee drink based on the specified drink name, cup size, and espresso type.
     * <p>
     * If the drink can be prepared successfully (ingredients and cup available), this method:
     * <ul>
     *   <li>Generates a {@link Receipt}</li>
     *   <li>Calculates price using the business’s {@link PriceList}</li>
     *   <li>Adds the transaction to the global {@link TransactionList}</li>
     * </ul>
     *
     * @param drinkName     the name of the drink (e.g., "Latte")
     * @param size          the size of the cup (e.g., "Small", "Medium", "Large")
     * @param espressoType  the type of espresso (e.g., "Light", "Standard", "Strong")
     * @return a {@link Receipt} for the transaction, or {@code null} if preparation failed
     */
    public Receipt serveCoffee(String drinkName, String size, String espressoType) {
        CoffeeDrink drink = coffeeMaker.makeDrink(drinkName, size, espressoType);
        CoffeeCup cup;

        if (drink != null) {
            cup = drink.getCupUsed();
            Receipt receipt = new Receipt(
                    this.location,
                    drink,
                    business.getPriceList().getPrice(drinkName, cup.getSize())
            );

            business.getTransactionList().addReceipt(receipt);
            return receipt;
        }
        return null;
    }
}
