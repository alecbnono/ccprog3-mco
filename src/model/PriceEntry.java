package model;

public class PriceEntry {
    private String product;
    private String size;
    private String truck;
    private double price;

    public PriceEntry(String product, String size, double price) {
        this.product = product;
        this.size = size;
        this.price = price;
    }

    public PriceEntry(String product, String size) {
        this.product = product;
        this.size = size;
        this.price = 0;
        this.truck = "regular";
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

    public String getSize() {
        return size;
    }

    public String getSizeFull() {

        return switch (size) {
            case "S" -> "small";
            case "M" -> "medium";
            case "L" -> "large";
            default -> "small";
        };
    }

    public String getTruck() {
        return truck;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setTruck(String truck) {
        this.truck = truck;
    }
}
