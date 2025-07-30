package model;

import java.util.ArrayList;

/**
 * Represents a storage unit in a coffee truck that holds a limited number of ingredients or items.
 * Each storage bin can contain multiple types of items (e.g., coffee beans, water, cups, syrups),
 * up to a maximum number of bins.
 */
public class StorageBin {

    private ArrayList<Binable> inventory;
    private int maxBins;

    /**
     * Constructs a StorageBin with a specified maximum number of bins.
     *
     * @param maxBins the maximum number of items this bin can hold
     */
    public StorageBin(int maxBins) {
        this.inventory = new ArrayList<>();
        this.maxBins = maxBins;
    }

    /**
     * Returns the current inventory of this storage bin.
     *
     * @return an ArrayList of Binable items
     */
    public ArrayList<Binable> getInventory() {
        return inventory;
    }

    /**
     * Sets a new item into the storage bin at the specified bin number.
     * Only works if the binNumber is within the allowed maximum.
     *
     * @param itemName  the name of the item (e.g., "water", "small cup")
     * @param binNumber the bin position (1-indexed)
     * @param amount    the amount of the item to store
     * @return true if the item was successfully added, false otherwise
     */
    public boolean setItem(String itemName, int binNumber, double amount) {
        if (inventory.size() <= maxBins && binNumber <= maxBins) {
            inventory.add(binNumber - 1, generateItem(itemName, amount));
            return true;
        }
        return false;
    }

    /**
     * Calculates the total amount of a specific item type across all bins.
     *
     * @param itemName the name of the item
     * @return the total amount of the specified item
     */
    public double getTotalAmount(String itemName) {
        double total = 0;
        for (Binable bin : inventory) {
            if (bin.getType().equalsIgnoreCase(itemName)) {
                total += bin.getAmount();
            }
        }
        return total;
    }

    /**
     * Restocks the specified amount of an item by distributing it across available bins
     * that already contain the same item type and have space.
     *
     * @param itemName the name of the item to restock
     * @param amount   the total amount to restock
     * @return true if the entire amount was restocked, false if not enough space
     */
    public boolean restock(String itemName, double amount) {
        double remaining = amount;
        for (Binable bin : inventory) {
            if (bin.getType().equalsIgnoreCase(itemName)) {
                double available = bin.getMaxAmount() - bin.getAmount();
                double add = Math.min(available, remaining);

                if (add > 0) {
                    boolean success = bin.restock(add);
                    if (success) {
                        remaining -= add;
                    }
                }
            }
            if (remaining <= 0)
                return true;
        }
        return remaining <= 0;
    }

    /**
     * Consumes the specified amount of an item from the bins.
     * Items are drawn from multiple bins if necessary.
     *
     * @param itemName the name of the item to consume
     * @param amount   the amount to consume
     * @return true if the required amount was successfully consumed, false if insufficient quantity
     */
    public boolean consume(String itemName, double amount) {
        double totalAvailable = 0;

        for (Binable bin : inventory) {
            if (bin.getType().equalsIgnoreCase(itemName)) {
                totalAvailable += bin.getAmount();
            }
        }

        if (totalAvailable < amount)
            return false;

        double remaining = amount;
        for (Binable bin : inventory) {
            if (bin.getType().equalsIgnoreCase(itemName)) {
                double available = bin.getAmount();
                double use = Math.min(available, remaining);
                bin.consume(use);
                remaining -= use;

                if (remaining <= 0) {
                    return true;
                }
            }
        }
        return remaining <= 0;
    }

    /**
     * Creates a Binable item instance based on a name and amount.
     * NOTE: This method is marked for relocation to controller layer as per MVC principle.
     *
     * @param itemName the name of the item
     * @param amount   the amount to be stored
     * @return a new Binable item, or null if the name doesn't match any known item
     */
    // TODO: Move this to controller as per MVC separation of concerns
    private Binable generateItem(String itemName, double amount) {
        return switch (itemName.toLowerCase()) {
            case "coffee beans" -> new CoffeeBeans(amount);
            case "water" -> new Water(amount);
            case "milk" -> new Milk(amount);
            case "small cup" -> new SmallCup((int) amount);
            case "medium cup" -> new MediumCup((int) amount);
            case "large cup" -> new LargeCup((int) amount);
            case "hazelnut" -> new HazelnutSyrup((int) amount);
            case "chocolate" -> new ChocolateSyrup((int) amount);
            case "vanilla" -> new VanillaSyrup((int) amount);
            case "almond" -> new AlmondSyrup((int) amount);
            case "sucrose" -> new SucroseSyrup((int) amount);
            default -> null;
        };
    }
}
