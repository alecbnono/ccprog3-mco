package model;

public class Liquid {

    private int quantity;
    private String name;
    private int capacity;

    public Liquid(int quantity, String name, int capacity) {
        this.quantity = quantity;
        this.name = name;
        this.capacity = capacity;
    }
    public int getQuantity() {
        return quantity;
    }
    public String getName() {
        return name;
    }
    public int getCapacity() {
        return capacity;
    }
}
