package model;

import java.util.ArrayList;

public class PriceList {
    private ArrayList<PriceEntry> Prices;
    private static String[] menuItems = { "Americano", "Cappuccino", "Latte" };
    private static String[] menuSizes = { "S", "M", "L" };

    public PriceList() {
        this.Prices = new ArrayList<>();

        for (String item : menuItems) {
            for (String size : menuSizes) {
                PriceEntry entry = new PriceEntry(item, size);

                Prices.add(entry);
            }
        }
    }

    public ArrayList<PriceEntry> getPriceEntries() {
        return Prices;
    }

    public int getRegularPricesCount() {
        return Prices.size();
    }

    public void addPriceEntry(PriceEntry entry) {
        Prices.add(entry);
    }

    public void updateRegularPrices() {
        for (PriceEntry entry : Prices) {
            if (entry.getTruck() != null && entry.getTruck().equals("regular")) {
                entry.updatePrice(entry.getPrice() * 1.05); // increase by 5%
            }
        }
    }
}
