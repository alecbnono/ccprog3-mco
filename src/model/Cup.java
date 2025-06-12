package model;

public class Cup {
    private int quantity;
    private double VolumeinflOz;

    public Cup(int quantity, double  VolumeinflOz) {
        this.quantity = quantity;
        this.VolumeinflOz = VolumeinflOz;
    }

    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public double getVolumeinflOz(){
        return VolumeinflOz;
    }
    public void setVolumeinflOz(double VolumeinflOz){
        this.VolumeinflOz = VolumeinflOz;
    }
}
