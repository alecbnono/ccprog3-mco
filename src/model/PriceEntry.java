package model;

/**
 * Represents a pricing entry for a coffee product.
 * <p>
 * This includes the product name, size (e.g., "S", "M", "L"), and the corresponding price.
 * </p>
 */
public class PriceEntry {
    /** The name of the coffee product (e.g., "Latte", "Americano"). */
    private String product;

    /** The size of the product ("S", "M", or "L"). */
    private String size;

    /** The price associated with this product and size. */
    private double price;

    /**
     * Constructs a PriceEntry with a product, size, and price.
     *
     * @param product product name (e.g., "Latte")
     * @param size    size of product ("S", "M", "L")
     * @param price   price value (must be ≥ 0)
     */
    public PriceEntry(String product, String size, double price) {
        this.product = product;
        this.size = size;
        this.price = price;
    }

    /**
     * Updates the price if the provided value is valid (non-negative).
     *
     * @param price the new price to set
     * @return {@code true} if update was successful; {@code false} otherwise
     */
    public boolean updatePrice(double price) {
        if (price >= 0) {
            this.price = price;
            return true;
        }
        return false;
    }

    /**
     * Returns the price of the product for the specified size.
     *
     * @return the price value
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns the name of the coffee product.
     *
     * @return the product name
     */
    public String getProduct() {
        return product;
    }

    /**
     * Returns the abbreviated size label ("S", "M", "L").
     *
     * @return the size abbreviation
     */
    public String getSize() {
        return size;
    }

    /**
     * Returns the full-size label (e.g., "small", "medium", "large")
     * based on the abbreviated size.
     *
     * @return the full descriptive size
     */
    public String getSizeFull() {
        return switch (size) {
            case "S" -> "small";
            case "M" -> "medium";
            case "L" -> "large";
            default -> "small"; // fallback in case of invalid input
        };
    }

    /**
     * Sets the size of the product.
     *
     * @param size the new size abbreviation ("S", "M", "L")
     */
    public void setSize(String size) {
        this.size = size;
    }
}
