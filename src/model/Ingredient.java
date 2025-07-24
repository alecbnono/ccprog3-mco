package model;

public abstract class Ingredient implements Container {

    protected double amount;
    protected double maxAmount;

    public Ingredient() {
        this.amount = 0;
    }

    public Ingredient(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public double getMaxAmount() {
        return maxAmount;
    }

    public boolean isDepleted() {
        return amount <= 0;
    }

    public boolean restock(double amount) {
        if (this.amount + amount > maxAmount)
            return false;
        this.amount += amount;
        return true;
    }

    public boolean consume(double amount) {
        if (this.amount >= amount) {
            this.amount -= amount;
            return true;
        }
        return false;
    }

}
