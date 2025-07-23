package model;

import java.util.ArrayList;

/**
 * Defines recipes and logic for preparing different coffee drinks.
 */
public class CoffeeMaker {
    private final double BEAN_RATIO = 1.0 / 19.0;
    private final double FLOZ_TO_GRAMS = 28.34962;

    /**
     * Converts a cup size to its corresponding volume in fluid ounces.
     *
     * @param size the cup size ("small", "medium", "large")
     * @return fluid ounces for the given size
     */
    private double getCupOz(String size) {
        return switch (size.toLowerCase()) {
            case "small" -> 8;
            case "medium" -> 12;
            case "large" -> 16;
            default -> 0;
        };
    }

    private double getBeanRatio(String brew) {
        return switch (brew.toLowerCase()) {
            case "standard" -> 1.0 / 19.0;
            case "strong" -> 1.0 / 16.0;
            case "light" -> 1.0 / 21.0;
            default -> 1.0 / (Double.parseDouble(brew) + 1);
        };
    }

    /**
     * Checks and optionally consumes the required amount of a specific item.
     *
     * @param inventory list of storage bins
     * @param itemName  name of the item
     * @param amount    quantity to consume
     * @param doConsume whether to actually consume the item
     * @return true if sufficient quantity exists (and optionally consumed), false
     *         otherwise
     */
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
                        if (remaining <= 0)
                            return true;
                    }
                }
            }
            return false;
        }
    }

    /**
     * Attempts to consume all listed items in the given amounts.
     *
     * @param inventory list of storage bins
     * @param itemNames names of the items
     * @param amounts   amounts of each item
     * @return true if all items were successfully consumed
     */
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

    public double makeEspresso(double ounces, double ratio) {
        return ounces / ratio;
    }

    public double getCoffeeBeanGrams(double espresso, double beanRatio) {
        return espresso * beanRatio * FLOZ_TO_GRAMS;
    }

    public double getWater(double espresso, double beanRatio) {
        return (1 - beanRatio) * espresso;
    }

    public boolean makeDrink(ArrayList<StorageBin> inventory, String drinkSize, String order, String brew) {
        double cupOunces = getCupOz(drinkSize);
        double espresso = switch (order.toLowerCase()) {
            case "americano", "cappuccino" -> makeEspresso(cupOunces, 3.0);
            case "latte" -> makeEspresso(cupOunces, 5.0);
            default -> 0;
        };
        double beanRatio = getBeanRatio(brew);
        double CBgrams = getCoffeeBeanGrams(espresso, beanRatio);
        double water = switch (order.toLowerCase()) {
            case "americano" -> (cupOunces - espresso) + getWater(espresso, beanRatio);
            case "latte", "cappuccino" -> getWater(espresso, beanRatio);
            default -> 0;
        };
        double milk = switch (order.toLowerCase()) {
            case "latte", "cappuccino" -> cupOunces - espresso;
            default -> 0;
        };
        if (order.equalsIgnoreCase("americano")) {
            return consume(inventory, new String[] { "coffee beans", "water", drinkSize.toLowerCase() + " Cup" },
                    new double[] { CBgrams, water, 1 });
        } else {
            return consume(inventory,
                    new String[] { "coffee beans", "water", "milk", drinkSize.toLowerCase() + " Cup" },
                    new double[] { CBgrams, water, milk, 1 });
        }
    }
}
