package model;

/**
 * Represents a storage container for an inventory item.
 */
public class StorageBin {
    private Item storedItem;
    private double maxQuantity;

    /**
     * Constructs a StorageBin with a specified item.
     *
     * @param item item to store
     */
    public StorageBin(Item item) {
        this.maxQuantity = item.getMaxQuantity();
        this.storedItem = item;
    }

    /**
     * Constructs an empty StorageBin.
     */
    public StorageBin() {
        this.maxQuantity = 0;
        this.storedItem = null;
    }

    public boolean emptyBox() {
        this.maxQuantity = 0;
        storedItem = null;
        return true;
    }

    public boolean setBox(Item item) {
        this.maxQuantity = item.getMaxQuantity();
        if (storedItem != null)
            return false;
        storedItem = item;
        return true;
    }

    public Item getBox() {
        return storedItem;
    }

    public boolean isEmpty() {
        return storedItem == null;
    }

    public boolean isDepleted() {
        return storedItem != null && storedItem.isDepleted();
    }

    public boolean restock(double amount) {
        if (storedItem == null)
            return false;
        return storedItem.restock(amount);
    }

    public boolean consume(double amount) {
        if (storedItem == null)
            return false;
        return storedItem.consume(amount);
    }

    public boolean canConsume(double amount) {
        return storedItem != null && storedItem.getQuantity() >= amount;
    }

    public boolean hasItem(String itemName) {
        return storedItem != null && storedItem.getName().toLowerCase().equalsIgnoreCase(itemName);
    }
}
