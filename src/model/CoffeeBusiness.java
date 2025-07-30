package model;

import java.util.ArrayList;

/**
 * The {@code CoffeeBusiness} class manages the core business logic of the coffee truck operation.
 * <p>
 * It maintains a list of {@link CoffeeTruck} instances, a shared {@link PriceList},
 * and a centralized {@link TransactionList}. This class is responsible for handling
 * operations such as creating trucks, tracking selected trucks, and managing pricing.
 * </p>
 *
 * @author
 */
public class CoffeeBusiness {

    /** The list of all coffee trucks registered in the business. */
    private ArrayList<CoffeeTruck> Trucks;

    /** The price list used for drinks across all trucks. */
    private PriceList priceList;

    /** The global transaction history of all sales across all trucks. */
    private TransactionList transactionList;

    /** The currently selected truck, used for UI or context-specific operations. */
    private CoffeeTruck selectedTruck;

    /**
     * Constructs a {@code CoffeeBusiness} instance with an empty truck list,
     * a default price list, and a new transaction list.
     */
    public CoffeeBusiness() {
        this.Trucks = new ArrayList<CoffeeTruck>();
        this.priceList = new PriceList();
        this.transactionList = new TransactionList();
    }

    /**
     * Returns the price list associated with this business.
     *
     * @return the {@link PriceList} object
     */
    public PriceList getPriceList() {
        return priceList;
    }

    /**
     * Sets the price list for this business.
     *
     * @param priceList the new {@link PriceList}
     */
    public void setPriceList(PriceList priceList) {
        this.priceList = priceList;
    }

    /**
     * Returns the central transaction list for all trucks.
     *
     * @return the {@link TransactionList}
     */
    public TransactionList getTransactionList() {
        return transactionList;
    }

    /**
     * Returns the list of all coffee trucks managed by this business.
     *
     * @return a list of {@link CoffeeTruck} objects
     */
    public ArrayList<CoffeeTruck> getTrucks() {
        return this.Trucks;
    }

    /**
     * Returns the total number of coffee trucks.
     *
     * @return the number of trucks
     */
    public int getTruckCount() {
        return Trucks.size();
    }

    /**
     * Checks whether a specific location is already occupied by a truck.
     *
     * @param location the location to check
     * @return {@code true} if the location is already used; {@code false} otherwise
     */
    public boolean isLocationTaken(String location) {
        for (CoffeeTruck coffeeTruck : Trucks) {
            if (coffeeTruck.getLocation().equals(location)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the number of trucks that match a specific type.
     *
     * @param type the type of truck (e.g., "regular", "special")
     * @return the count of matching trucks
     */
    public int getSpecificTruckCount(String type) {
        int count = 0;

        for (CoffeeTruck coffeeTruck : Trucks) {
            if (coffeeTruck.getType().equalsIgnoreCase(type))
                count++;
        }
        return count;
    }

    /**
     * Creates a new truck of a given type and location, then adds it to the business.
     * Also sets it as the currently selected truck.
     *
     * @param location the location of the new truck
     * @param type     the type of truck ("regular" or "special")
     */
    public void createTruck(String location, String type) {
        CoffeeTruck truck;
        if (type.equalsIgnoreCase("Regular")) {
            truck = new RegularCoffeeTruck(location, this);
        } else if (type.equalsIgnoreCase("Special")) {
            truck = new SpecialCoffeeTruck(location, this);
        } else {
            truck = null;
        }

        Trucks.add(truck);
        this.selectedTruck = truck;
    }

    /**
     * Returns the currently selected coffee truck.
     *
     * @return the selected {@link CoffeeTruck}, or {@code null} if none is selected
     */
    public CoffeeTruck getSelectedTruck() {
        return selectedTruck;
    }

    /**
     * Sets the selected truck based on a given location name.
     *
     * @param truck the location of the truck to select
     * @return {@code true} if a matching truck was found and selected; {@code false} otherwise
     */
    public boolean setSelectedTruck(String truck) {
        for (CoffeeTruck coffeeTruck : Trucks) {
            if (coffeeTruck.getLocation().equals(truck)) {
                this.selectedTruck = coffeeTruck;
                return true;
            }
        }
        return false;
    }

    /**
     * Clears the currently selected truck.
     */
    public void clearSelectedTruck() {
        this.selectedTruck = null;
    }
}
