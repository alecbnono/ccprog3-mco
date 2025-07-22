package model;

public class StorageBin {
    private Item item;

    public StorageBin(Item item) {
        this.item = item;
    }

    public boolean isEmpty() {
        return item == null;
    }

    public boolean isDepleted() {
        return item != null && item.isDepleted();
    }

    public Item getItem() {
        return item;
    }

    public boolean restock(double amount) {
        return item != null && item.restock(amount);
    }

    public boolean consume(double amount) {
        return item != null && item.consume(amount);
    }

    public boolean hasItem(String name) {
        return item != null && item.getName().equalsIgnoreCase(name);
    }

    public boolean canConsume(double amount) {
        return item != null && item.getQuantity() >= amount;
    }
}
