package model;

public class StorageBin {
    private Item storedItem;
    private int maxQuantity;
    public StorageBin(Item storedItem, int maxQuantity) {
        this.storedItem = storedItem;
        this.maxQuantity = maxQuantity;
    }
    public boolean emptyBox() {
        return storedItem == null;
    }
    public boolean setBox(Item item) {
        if (storedItem == null) {
            storedItem = item;
            return true;
        }
        else return false;
    }

    public Item getBox() {
        return storedItem;
    }

}
