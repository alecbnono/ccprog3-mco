package model;

public abstract class Item {

    protected String name;
    protected String unit;
    protected double quantity;

    public Item() {
        this.name = "";
        this.unit = "";
        this.quantity = 0;
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
        return quantity <= 0;
    }
    public boolean restock(double amount){
        if(amount <= 0){
            return false;
        }
        else {
            quantity += amount;
            return true;
        }
    }
    public boolean consume(double amount){
        if(amount <= 0 || quantity < amount){
            return false;
        }
        else {
            quantity -= amount;
            return true;
        }
    }
}
