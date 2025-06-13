package model;

import java.io.Serializable;

public class Cup extends Item{

    private String size;
    private int capacity;

    public Cup(String size, int capacity) {
        super();
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
