package model;

public class Cup {

    private String size;
    private int capacity;

    public Cup(String size, int capacity) {
        this.size = size;
        this.capacity = capacity;
    }
    public String getSize() {
        return size;
    }
    public int  getCapacity() {
        return capacity;
    }
}
