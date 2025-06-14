package model;

public class StorageBox {
    private Item storedItem;

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
