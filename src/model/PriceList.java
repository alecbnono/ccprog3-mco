package model;

import java.util.ArrayList;

/**
 * Manages the full list of product prices for various drink types and sizes.
 * <p>
 * Each price is stored as a {@link PriceEntry}, and this class provides lookup and modification methods.
 * </p>
 */
public class PriceList {

    /** List of all pricing entries for drinks and add-ons. */
    private ArrayList<PriceEntry> Prices;

    /**
     * Constructs a PriceList with an initially empty list of price entries.
     */
    public PriceList() {
        this.Prices = new ArrayList<>();
    }

    /**
     * Returns the full list of price entries.
     *
     * @return an ArrayList of {@link PriceEntry} objects
     */
    public ArrayList<PriceEntry> getPriceEntries() {
        return Prices;
    }

    /**
     * Adds a new price entry to the list.
     *
     * @param entry the {@link PriceEntry} to add
     */
    public void addPriceEntry(PriceEntry entry) {
        Prices.add(entry);
    }

    /**
     * Retrieves the price for a specific drink and cup size.
     *
     * @param drinkName name of the drink (e.g., "Latte", "Americano")
     * @param cupSize   size abbreviation ("S", "M", "L")
     * @return the price if found; -1.0 if not found
     */
    public double getPrice(String drinkName, String cupSize) {
        for (PriceEntry priceEntry : Prices) {
            if (priceEntry.getProduct().equalsIgnoreCase(drinkName) &&
                    priceEntry.getSize().equalsIgnoreCase(cupSize)) {
                return priceEntry.getPrice();
            }
        }
        return -1.0;
    }

    /**
     * Retrieves the price for an add-on (e.g., syrups).
     * <p>
     * Assumes the product is stored under the name "Add-Ons" in the price list.
     * </p>
     *
     * @return the add-on price if found; -1.0 if not found
     */
    public double getAddOnPrice() {
        for (PriceEntry priceEntry : Prices) {
            if (priceEntry.getProduct().equalsIgnoreCase("Add-Ons")) {
                return priceEntry.getPrice();
            }
        }
        return -1.0;
    }
}
