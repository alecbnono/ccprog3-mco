package model;

/**
 * Represents a pricing entry for a coffee product.
 */
public class PriceEntry {
    private String product;
    private String size;
    private String truck;
    private double price;

    /**
     * Constructs a PriceEntry with a product, size, and price.
     *
     * @param product product name
     * @param size    size of product
     * @param price   price value
     */
    public PriceEntry(String product, String size, double price) {
        this.product = product;
        this.size = size;
        this.price = price;
    }

    /**
     * Constructs a PriceEntry with a product and size.
     * Price is set to 0 and truck is "regular".
     *
     * @param product product name
     * @param size    size of product
     */
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
