package model;

import java.util.ArrayList;

/**
 * Manages the full list of product prices.
 */
public class PriceList {
    private ArrayList<PriceEntry> Prices;

    /**
     * Constructs a PriceList with default entries.
     */
    public PriceList() {
        this.Prices = new ArrayList<>();
    }

    /**
     * Returns number of price entries for regular trucks.
     *
     * @return size of price list
     */
    public ArrayList<PriceEntry> getPriceEntries() {
        return Prices;
    }

    public void addPriceEntry(PriceEntry entry) {
        Prices.add(entry);
    }

    public double getPrice(String drinkName, String cupSize) {

        for (PriceEntry priceEntry : Prices) {
            if (priceEntry.getProduct().equalsIgnoreCase(drinkName) &&
                    priceEntry.getSize().equalsIgnoreCase(cupSize)) {
                return priceEntry.getPrice();
            }
        }

        return -1.0;
    }
}
