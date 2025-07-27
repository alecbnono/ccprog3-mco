package model;

import java.util.ArrayList;

/**
 * Manages the business logic of the coffee truck operation.
 * Maintains a list of trucks and a price list.
 */
public class CoffeeBusiness {

    private ArrayList<CoffeeTruck> Trucks;
    private PriceList priceList;
    private TransactionList transactionList;
    private CoffeeTruck selectedTruck;

    /**
     * Constructs a CoffeeBusiness with an empty truck list and default price list.
     */
    public CoffeeBusiness() {
        this.Trucks = new ArrayList<CoffeeTruck>();
        this.priceList = new PriceList();
        this.transactionList = new TransactionList();
    }

    public PriceList getPriceList() {
        return priceList;
    }

    public void setPriceList(PriceList priceList) {
        this.priceList = priceList;
    }

    public TransactionList getTransactionList() {
        return transactionList;
    }

    /**
     * Returns a specific truck by its index.
     *
     * @param truckNo index of the truck
     * @return the CoffeeTruck at the given index
     */
    public ArrayList<CoffeeTruck> getTrucks() {
        return this.Trucks;
    }

    /**
     * Returns the total number of trucks.
     *
     * @return truck count
     */
    public int getTruckCount() {
        return Trucks.size();
    }

    /**
     * Returns the number of trucks of a specific type.
     *
     * @param type truck type (e.g., "regular")
     * @return number of matching trucks
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
     * Creates a truck of a specified type and adds it to the business.
     *
     * @param location location of the truck
     * @param type     truck type ("regular" or "special")
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

    public CoffeeTruck getSelectedTruck() {
        return selectedTruck;
    }

    public boolean setSelectedTruck(String truck) {
        for (CoffeeTruck coffeeTruck : Trucks) {
            if (coffeeTruck.getLocation().equals(truck)) {
                this.selectedTruck = coffeeTruck;
                return true;
            }
        }
        return false;
    }

    public void clearSelectedTruck() {
        this.selectedTruck = null;
    }

}
