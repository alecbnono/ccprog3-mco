package model;

public abstract class AddOn {
    protected double amount;
    protected final double MAX_AMOUNT = 640.0;

    public AddOn() {
        this.amount = 0;
    }

    public AddOn(double initialAmount) {
        this.amount = Math.min(initialAmount, MAX_AMOUNT);
    }

    public double getAmount() {
        return amount;
    }

    public double getMaxAmount() {
        return MAX_AMOUNT;
    }

    public boolean isDepleted() {
        return amount <= 0;
    }

    public boolean restock(double amount) {
        if (this.amount + amount > MAX_AMOUNT)
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

    public void fillCompletely() {
        this.amount = MAX_AMOUNT;
    }

    public abstract String getFlavor();
}
