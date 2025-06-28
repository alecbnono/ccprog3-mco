package model;

import java.util.ArrayList;

/**
 * Manages the full list of product prices.
 */
public class PriceList {
    private ArrayList<PriceEntry> Prices;
    private static String[] menuItems = { "Americano", "Cappuccino", "Latte" };
    private static String[] menuSizes = { "S", "M", "L" };

    /**
     * Constructs a PriceList with default entries.
     */
    public PriceList() {
        this.Prices = new ArrayList<>();

        for (String item : menuItems) {
            for (String size : menuSizes) {
                PriceEntry entry = new PriceEntry(item, size);

                Prices.add(entry);
            }
        }
    }

    /**
     * Returns number of price entries for regular trucks.
     *
     * @return size of price list
     */
    public ArrayList<PriceEntry> getPriceEntries() {
        return Prices;
    }

    public int getRegularPricesCount() {
        return Prices.size();
    }

    public void addPriceEntry(PriceEntry entry) {
        Prices.add(entry);
    }

    /**
     * Updates all "regular" prices by increasing them by 5%.
     */
    public void updateRegularPrices() {
        for (PriceEntry entry : Prices) {
            if (entry.getTruck() != null && entry.getTruck().equals("regular")) {
                entry.updatePrice(entry.getPrice() * 1.05); // increase by 5%
            }
        }
    }
}
