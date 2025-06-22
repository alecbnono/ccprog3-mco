package model;

import java.util.ArrayList;

/**
 * CoffeeBusiness
 */
public class CoffeeBusiness {

    private double sales;
    private ArrayList<CoffeeTruck> Trucks;

    public CoffeeBusiness() {
        this.Trucks = new ArrayList<CoffeeTruck>();
        this.sales = 0;
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
}
