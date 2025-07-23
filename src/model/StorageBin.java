package model;

public class StorageBin {
    private Ingredient ingredient;

    public StorageBin(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public StorageBin() {
        this.ingredient = null;
    }

    public boolean isEmpty() {
        return ingredient == null;
    }

    public boolean isDepleted() {
        return ingredient != null && ingredient.isDepleted();
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public boolean restock(double amount) {
        return ingredient != null && ingredient.restock(amount);
    }

    public boolean consume(double amount) {
        return ingredient != null && ingredient.consume(amount);
    }

    public boolean hasIngredient(String name) {
        return ingredient != null && ingredient.getType().equalsIgnoreCase(name);
    }

    public boolean canConsume(double amount) {
        return ingredient != null && ingredient.getAmount() >= amount;
    }
}
