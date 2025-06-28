package model;

import java.util.ArrayList;

/**
 * Manages the business logic of the coffee truck operation.
 * Maintains a list of trucks and a price list.
 */
public class CoffeeBusiness {

    private double cappuccinoSales;
    private double americanoSales;
    private double latteSales;
    private ArrayList<CoffeeTruck> Trucks;
    private PriceList priceList;

    /**
     * Constructs a CoffeeBusiness with an empty truck list and default price list.
     */
    public CoffeeBusiness() {
        this.Trucks = new ArrayList<CoffeeTruck>();
        this.priceList = new PriceList();
        this.cappuccinoSales = 0;
        this.americanoSales = 0;
        this.latteSales = 0;
    }

    public ArrayList<PriceEntry> getPriceList() {
        return this.priceList.getPriceEntries();
    }

    /**
     * Returns a specific truck by its index.
     *
     * @param truckNo index of the truck
     * @return the CoffeeTruck at the given index
     */
    public CoffeeTruck getTruck(int truckNo) {
        return this.Trucks.get(truckNo);
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
            if (coffeeTruck.getType().equals(type.toLowerCase())) {
                count++;
            }
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
        if (type.toLowerCase().equals("regular")) {
            Trucks.add(new RegularCoffeeTruck(location));
        } else if (type.toLowerCase().equals("special")) {
            // insert special coffee truck
        }
    }

    public double getTotalSales() {
        double sales = cappuccinoSales + americanoSales + latteSales;
        return sales;
    }

    /**
     * Adds a sales amount to the corresponding coffee product.
     *
     * @param name  the name of the product ("americano", "cappuccino", or "latte")
     * @param price the sales amount to be added
     */
    public void addSales(String name, double price) {

        switch (name.toLowerCase()) {
            case "americano":
                americanoSales += price;
                break;
            case "cappuccino":
                cappuccinoSales += price;
                break;
            case "latte":
                latteSales += price;
                break;
        }
    }

    /**
     * Returns the total sales accumulated for a specific coffee product.
     *
     * @param name the name of the product ("americano", "cappuccino", or "latte")
     * @return the total sales for the specified product, or 0 if the name is
     *         invalid
     */
    public double getSales(String name) {

        switch (name.toLowerCase()) {
            case "americano":
                return americanoSales;
            case "cappuccino":
                return cappuccinoSales;
            case "latte":
                return latteSales;
            default:
                return 0;
        }
    }
}
