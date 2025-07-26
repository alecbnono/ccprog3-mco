package model;

/**
 * Abstract representation of a coffee cup, which can be restocked or consumed in a storage system.
 * This class implements the {@code Binable} interface.
 */
public abstract class CoffeeCup implements Binable {

    /** Current quantity of this cup in storage */
    protected int amount;

    /** Maximum quantity that can be stored */
    protected int maxAmount;

    /**
     * Constructs an empty coffee cup inventory.
     */
    public CoffeeCup() {
        this.amount = 0;
    }

    /**
     * Constructs a coffee cup inventory with a specified amount.
     *
     * @param amount the initial amount of cups
     */
    public CoffeeCup(int amount) {
        this.amount = amount;
    }

    /**
     * Returns the size category of the cup (e.g., Small, Medium, Large).
     *
     * @return the size label of the cup
     */
    public abstract String getSize();

    /**
     * Returns the liquid capacity of the cup in ounces.
     *
     * @return the volume capacity in fluid ounces
     */
    public abstract double getCapacity();

    /**
     * {@inheritDoc}
     * Returns a string like "Small Cup", "Medium Cup", etc.
     */
    @Override
    public String getType() {
        return getSize() + " Cup";
    }

    /**
     * {@inheritDoc}
     * Always returns "pcs" (pieces) for coffee cups.
     */
    @Override
    public String getUnit() {
        return "pcs";
    }

    /**
     * {@inheritDoc}
     * Gets the current number of cups in stock.
     */
    @Override
    public double getAmount() {
        return amount;
    }

    /**
     * Gets the maximum capacity of this type of cup in storage.
     *
     * @return the maximum amount of cups that can be stored
     */
    public double getMaxAmount() {
        return maxAmount;
    }

    /**
     * {@inheritDoc}
     * Adds the given number of cups to inventory, if it does not exceed the max capacity.
     *
     * @param amount the number of cups to add
     * @return {@code true} if restock is successful; {@code false} otherwise
     */
    @Override
    public boolean restock(double amount) {
        if (this.amount + (int) amount > maxAmount)
            return false;
        this.amount += (int) amount;
        return true;
    }

    /**
     * {@inheritDoc}
     * Removes the given number of cups from inventory if available.
     *
     * @param amount the number of cups to consume
     * @return {@code true} if there are enough cups to consume; {@code false} otherwise
     */
    @Override
    public boolean consume(double amount) {
        if (this.amount >= (int) amount) {
            this.amount -= (int) amount;
            return true;
        }
        return false;
    }
}
