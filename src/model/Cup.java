package model;

import java.io.Serializable;

public class Cup extends Item{

    private String size;
    private int capacity;

    public Cup(String size, int capacity) {
        this.size = size;
        this.name = size + " Cup";
        this.unit = "pcs";
        this.quantity = switch(size.toLowerCase()){
            case "large" -> 40;
            case "medium" -> 64;
            case "small" -> 80;
            default -> 0;
        };
        this.capacity = capacity;
    }
    public String getSize() {
        return size;
    }
    public int  getCapacity() {
        return capacity;
    }
}
