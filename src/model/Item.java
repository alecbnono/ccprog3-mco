package model;

public abstract class Item {

    private String name;
    private String unit;
    private double quantity;

    public Item(){

    }
    public String getName() {
        return name;
    }
    public double getQuantity() {
        return quantity;
    }
    public String getUnit() {
        return unit;
    }
    public boolean isDepleted(){
        return true;
        //fill
    }
    public boolean restock(){
        return true;
        //fill
    }
    public boolean consume(){
        return true;
        //fill
    }
}
