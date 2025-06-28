package model;

import java.util.ArrayList;

/**
 * CoffeeBusiness
 */
public class CoffeeBusiness {

    private double cappuccinoSales;
    private double americanoSales;
    private double latteSales;
    private ArrayList<CoffeeTruck> Trucks;
    private PriceList priceList;

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

    public CoffeeTruck getTruck(int truckNo) {
        return this.Trucks.get(truckNo);
    }

    public int getTruckCount() {
        return Trucks.size();
    }

    public int getSpecificTruckCount(String type) {
        int count = 0;

        for (CoffeeTruck coffeeTruck : Trucks) {
            if (coffeeTruck.getType().equals(type.toLowerCase())) {
                count++;
            }
        }
        return count;
    }

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

    public void addSales(String name, double price) {

        switch (name.toLowerCase()) {
            case "americano":
                americanoSales += price;
            case "cappuccino":
                cappuccinoSales += price;
            case "latte":
                latteSales += price;
        }
    }

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
