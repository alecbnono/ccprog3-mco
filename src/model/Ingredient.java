package model;

public interface Ingredient {
    String getName();
    double getQuantity();
    boolean restock(double amount);
    boolean consume(double amount);
}
