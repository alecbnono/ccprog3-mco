package model;

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

    private boolean consumeChecker(StorageBin[] inventory, String itemName, double amount, boolean doConsume) {
        for (StorageBin bin : inventory) {
            if (bin.hasItem(itemName)) {
                if (doConsume) {
                    return bin.consume(amount);
                } else {
                    return bin.canConsume(amount);
                }
            }
        }
        return false;
    }

    private boolean consume(StorageBin[] inventory, String[] itemNames, double[] amounts) {
        for (int i = 0; i < itemNames.length; i++) {
            if (!consumeChecker(inventory, itemNames[i], amounts[i], false)) {
                return false;
            }
        }
        for (int i = 0; i < itemNames.length; i++) {
            consumeChecker(inventory, itemNames[i], amounts[i], true);
        }

        return true;
    }

    public boolean makeAmericano(StorageBin[] inventory, String itemName) {
        double cupOunces = getCupOz(itemName);
        double espresso = cupOunces / 3;
        double CBgrams = espresso * BEAN_RATIO * FLOZ_TO_GRAMS;
        double water = (cupOunces - espresso) + (1 - BEAN_RATIO) * espresso;
        return consume(inventory, new String[] { "coffee beans", "water" }, new double[] { CBgrams, water });
    }

    public boolean makeLatte(StorageBin[] inventory, String itemName) {
        double cupOunces = getCupOz(itemName);
        double espresso = cupOunces / 5;
        double CBgrams = espresso * BEAN_RATIO * FLOZ_TO_GRAMS;
        double water = espresso * (1 - BEAN_RATIO);
        double milk = cupOunces - espresso;
        return consume(inventory, new String[] { "coffee beans", "water", "milk" },
                new double[] { CBgrams, water, milk });
    }

    public boolean makeCappuccino(StorageBin[] inventory, String itemName) {
        double cupOunces = getCupOz(itemName);
        double espresso = cupOunces / 3;
        double CBgrams = espresso * BEAN_RATIO * FLOZ_TO_GRAMS;
        double water = espresso * (1 - BEAN_RATIO);
        double milk = cupOunces - espresso;
        return consume(inventory, new String[] { "coffee beans", "water", "milk" },
                new double[] { CBgrams, water, milk });
    }
}
