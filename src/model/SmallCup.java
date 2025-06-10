package model;

public class SmallCup implements Cup{
    private final double VolumeinflOz = 8;
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
