package model;

import java.util.ArrayList;

public class CoffeeRecipe {
    private final double BEAN_RATIO = 1.0 / 19.0;
    private final double FLOZ_TO_GRAMS = 28.34962;

    private double getCupOz(String size) {
        return switch (size.toLowerCase()) {
            case "small" -> 8;
            case "medium" -> 12;
            case "large" -> 16;
            default -> 0;
        };
    }

    private boolean consumeChecker(ArrayList<StorageBin> inventory, String itemName, double amount, boolean doConsume) {
        if (!doConsume) {
            double totalAvailable = 0;
            for (StorageBin bin : inventory) {
                if (bin.hasItem(itemName)) {
                    double q = bin.getBox().getQuantity();
                    totalAvailable += q;
                }
            }
            return totalAvailable >= amount;
        } else {
            double remaining = amount;
            for (StorageBin bin : inventory) {
                if (bin.hasItem(itemName)) {
                    double available = bin.getBox().getQuantity();
                    double toConsume = Math.min(remaining, available);
                    if (toConsume > 0) {
                        bin.consume(toConsume);
                        remaining -= toConsume;
                        if (remaining <= 0) return true;
                    }
                }
            }
            return false;
        }
    }

    private boolean consume(ArrayList<StorageBin> inventory, String[] itemNames, double[] amounts) {
        // Step 1: Check all items are available
        for (int i = 0; i < itemNames.length; i++) {
            if (!consumeChecker(inventory, itemNames[i], amounts[i], false)) {
                return false;
            }
        }

        // Step 2: Consume all items (only if all are available)
        for (int i = 0; i < itemNames.length; i++) {
            boolean success = consumeChecker(inventory, itemNames[i], amounts[i], true);
            if (!success) {
                return false;
            }
        }

        return true;
    }

    public boolean makeAmericano(ArrayList<StorageBin> inventory, String drinkSize) {
        double cupOunces = getCupOz(drinkSize);
        double espresso = cupOunces / 3;
        double CBgrams = espresso * BEAN_RATIO * FLOZ_TO_GRAMS;
        double water = (cupOunces - espresso) + (1 - BEAN_RATIO) * espresso;
        return consume(inventory, new String[] { "coffee beans", "water", drinkSize.toLowerCase() + " Cup" },
                new double[] { CBgrams, water, 1 });
    }

    public boolean makeLatte(ArrayList<StorageBin> inventory, String drinkSize) {
        double cupOunces = getCupOz(drinkSize);
        double espresso = cupOunces / 5;
        double CBgrams = espresso * BEAN_RATIO * FLOZ_TO_GRAMS;
        double water = espresso * (1 - BEAN_RATIO);
        double milk = cupOunces - espresso;
        return consume(inventory, new String[] { "coffee beans", "water", "milk", drinkSize.toLowerCase() + " Cup" },
                new double[] { CBgrams, water, milk, 1 });
    }

    public boolean makeCappuccino(ArrayList<StorageBin> inventory, String drinkSize) {
        double cupOunces = getCupOz(drinkSize);
        double espresso = cupOunces / 3;
        double CBgrams = espresso * BEAN_RATIO * FLOZ_TO_GRAMS;
        double water = espresso * (1 - BEAN_RATIO);
        double milk = cupOunces - espresso;
        return consume(inventory, new String[] { "coffee beans", "water", "milk", drinkSize.toLowerCase() + " Cup" },
                new double[] { CBgrams, water, milk, 1 });
    }
}
