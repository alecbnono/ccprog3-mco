package model;

/**
 * Abstract representation of a coffee cup.
 */
public abstract class CoffeeCup extends Item {
    protected String size;
    protected int capacityOz;

    public CoffeeCup(String name) {
        super(name, 1, 1); // Always one unit per cup
    }


    public String getSize() {
        return size;
    }

    public int getCapacity() {
        return capacityOz;
    }

    @Override
    public double getQuantity() {
        return (int) quantity;
    }

    @Override
    public double getMaxQuantity() {
        return (int) maxQuantity;
    }

    @Override
    public boolean restock(double amount) {
        int intAmount = (int) amount;
        if (intAmount <= 0) return false;
        if (maxQuantity < quantity + intAmount) {
            quantity = maxQuantity;
        } else {
            quantity += intAmount;
        }
        return true;
    }

    @Override
    public boolean consume(double amount) {
        int intAmount = (int) amount;
        if (intAmount <= 0 || quantity < intAmount) return false;
        quantity -= intAmount;
        return true;
    }
}