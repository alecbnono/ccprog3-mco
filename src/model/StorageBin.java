package model;

public class StorageBin {
    private Item storedItem;
    private int maxQuantity;

    public StorageBin(Item storedItem, int maxQuantity) {
        this.storedItem = storedItem;
        this.maxQuantity = maxQuantity;
    }
    public boolean emptyBox() {
        storedItem = null;
        return true;
    }

    public boolean setBox(Item item) {
        if (storedItem != null) return false;
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
        if (storedItem == null) return false;
        return storedItem.restock(amount);
    }

    public boolean consume(double amount) {
        if (storedItem == null) return false;
        return storedItem.consume(amount);
    }
    public boolean canConsume(double amount) {
        return storedItem != null && storedItem.getQuantity() >= amount;
    }

    public boolean hasItem(String itemName) {
        return storedItem != null && storedItem.getName().equalsIgnoreCase(itemName);
    }
}
