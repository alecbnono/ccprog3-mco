package model;

public class Cup extends Item {

    private String size;
    private int capacity;

    // implemented to dynamically compute
    // maxQuantity based on cup size
    private static int getMaxQuantity(String size) {
        int temp = switch (size.toLowerCase()) {
            case "large" -> 40;
            case "medium" -> 64;
            case "small" -> 80;
            default -> 0;
        };

        return temp;
    }

    public Cup(String size, int quantity) {
        super(quantity, getMaxQuantity(size));
        this.size = size;
        this.name = size + " Cup";
        this.unit = "pcs";
        this.capacity = switch (size.toLowerCase()) {
            case "large" -> 8;
            case "medium" -> 12;
            case "small" -> 14;
            default -> 0;
        };
    }

    public Cup(String size) {
        super(0, getMaxQuantity(size));
        this.size = size;
        this.name = size + " Cup";
        this.unit = "pcs";
        this.capacity = switch (size.toLowerCase()) {
            case "large" -> 8;
            case "medium" -> 12;
            case "small" -> 14;
            default -> 0;
        };
    }

    // truncates decimals
    @Override
    public double getQuantity() {
        return (int) quantity;
    }

    // truncates decimals
    @Override
    public double getMaxQuantity() {
        return (int) maxQuantity;
    }

    // truncates decimals
    @Override
    public boolean restock(double amount) {
        int intAmount = (int) amount;

        if (intAmount <= 0) {
            return false;
        } else if (maxQuantity < quantity + intAmount) {
            quantity = maxQuantity;
            return true;
        } else {
            quantity += intAmount;
            return true;
        }
    }

    // truncates decimals
    @Override
    public boolean consume(double amount) {
        int intAmount = (int) amount;

        if (intAmount <= 0 || quantity < intAmount) {
            return false;
        } else {
            quantity -= intAmount;
            return true;
        }
    }

    public String getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
