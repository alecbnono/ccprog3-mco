package model;

public class SmallCup {
    private final double VolumeinflOz = 8;
    private int quantity;

    public double getVolumeinflOz() {
        return VolumeinflOz;
    }
    public int  getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
