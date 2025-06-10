package model;

import java.io.Serializable;

public class LargeCup implements Cup{
    private final double VolumeinflOz = 16;
    private int quantity;

    @Override
    public double getVolumeinflOz() {
        return VolumeinflOz;
    }
    @Override
    public int  getQuantity() {
        return quantity;
    }
    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
