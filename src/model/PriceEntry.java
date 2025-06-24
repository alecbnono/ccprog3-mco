package model;

public class PriceEntry {
    private String product;
    private String type;
    private String truck;
    private double price;

    public PriceEntry(String product, double price) {
        this.product = product;
        this.price = price;
    }

    public boolean updatePrice(double price) {
        if (price >= 0) {
            this.price = price;
            return true;
        }
        return false;
    }

    public double getPrice() {
        return price;
    }

    public String getProduct() {
        return product;
    }

    public String getType() {
        return type;
    }

    public String getTruck() {
        return truck;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTruck(String truck) {
        this.truck = truck;
    }
}
