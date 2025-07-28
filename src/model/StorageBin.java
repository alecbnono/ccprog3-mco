package model;

import java.util.ArrayList;

public class StorageBin {
    private ArrayList<Binable> inventory;
    private int maxBins;

    public StorageBin(int maxBins) {
        this.inventory = new ArrayList<Binable>();
        this.maxBins = maxBins;
    }

    // move to controller
    private Binable generateItem(String itemName, double amount) {
        Binable item = switch (itemName.toLowerCase()) {
            case "coffee beans" -> new CoffeeBeans(amount);
            case "water" -> new Water(amount);
            case "milk" -> new Milk(amount);
            case "small cup" -> new SmallCup((int) amount);
            case "medium cup" -> new MediumCup((int) amount);
            case "large cup" -> new LargeCup((int) amount);
            case "hazelnut" -> new HazelnutSyrup((int) amount);
            case "chocolate" -> new ChocolateSyrup((int) amount);
            case "vanilla" -> new VanillaSyrup((int) amount);
            case "almond" -> new AlmondSyrup((int) amount);
            case "sucrose" -> new SucroseSyrup((int) amount);
            default -> null;
        };
        return item;
    }

    public ArrayList<Binable> getInventory() {
        return inventory;
    }

    public boolean setItem(String itemName, int binNumber, double amount) {
        if (inventory.size() <= maxBins && binNumber <= maxBins) {
            inventory.add(binNumber - 1, generateItem(itemName, amount));
            return true;
        }
        return false;
    }

    public boolean restock(String itemName, double amount) {
        double remaining = amount;

        for (Binable bin : inventory) {
            if (bin.getType().equalsIgnoreCase(itemName)) {
                double available = bin.getMaxAmount() - bin.getAmount();
                double add = Math.min(available, remaining);

                if (add > 0) {
                    boolean success = bin.restock(amount);
                    if (success) {
                        remaining -= add;
                    }
                }
            }

            if (remaining <= 0)
                return true;
        }
        return false;
    }

    public boolean consume(String itemName, double amount) {
        double remaining = amount;

        for (Binable bin : inventory) {
            if (bin.getType().equalsIgnoreCase(itemName)) {
                double available = bin.getAmount();
                double use = Math.min(available, remaining);
                bin.consume(use);
                remaining -= use;
            }

            if (remaining <= 0)
                return true;
        }
        return false;
    }
}
