package model;

/**
 * CoffeeMaker
 */
public class CoffeeMaker {

    private StorageBin inventory;

    public CoffeeMaker(StorageBin inventory) {
        this.inventory = inventory;
    }

    private Espresso makeCustomEspresso(double ratio) {
        return new CustomBrew(inventory, ratio);
    }

    private Espresso makeEspresso(String type) {
        Espresso espresso = switch (type) {
            case "Light" -> new LightBrew(inventory);
            case "Standard" -> new StandardBrew(inventory);
            case "Strong" -> new StrongBrew(inventory);
            default -> null;
        };

        return espresso;
    }

    private CoffeeDrink selectDrink(String drinkName) {
        CoffeeDrink drink = switch (drinkName) {
            case "Americano" -> new Americano(inventory);
            case "Latte" -> new Latte(inventory);
            case "Cappuccino" -> new Cappuccino(inventory);
            default -> null;
        };
        return drink;
    }

    public CoffeeCup selectCup(String size) {
        CoffeeCup cup = switch (size) {
            case "Small" -> new SmallCup();
            case "Medium" -> new MediumCup();
            case "Large" -> new LargeCup();
            default -> null;
        };
        return cup;
    }

    public CoffeeDrink makeDrink(String drinkName, String cupSize, String brewType) {

        CoffeeDrink drink = selectDrink(drinkName);

        if (drink.prepare(selectCup(cupSize), makeEspresso(brewType)))
            return drink;

        return null;
    }

    public CoffeeDrink makeCustomDrink(String drinkName, String cupSize, double espressoRatio) {

        CoffeeDrink drink = selectDrink(drinkName);

        if (drink.prepare(selectCup(cupSize), makeCustomEspresso(espressoRatio)))
            return drink;

        return null;
    }
}
