package model;

import java.lang.invoke.SwitchPoint;

/**
 * CoffeeMaker
 */
public class CoffeeMaker {

    private StorageBin inventory;

    public CoffeeMaker(StorageBin inventory) {
        this.inventory = inventory;
    }

    public Espresso makeCustomEspresso(double ratio) {
        return new CustomBrew(inventory, ratio);
    }

    public Espresso makeEspresso(String type) {
        Espresso espresso = switch (type) {
            case "Light" -> new LightBrew(inventory);
            case "Standard" -> new StandardBrew(inventory);
            case "Strong" -> new StrongBrew(inventory);
            default -> null;
        };

        return espresso;
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

    public CoffeeDrink makeAmericano(String cupSize, String brewType) {

        CoffeeDrink drink = new Americano(inventory);

        if (drink.prepare(selectCup(cupSize), makeEspresso(brewType)))
            return drink;

        return null;
    }

    public CoffeeDrink makeLatte(String cupSize, String brewType) {

        CoffeeDrink drink = new Latte(inventory);

        if (drink.prepare(selectCup(cupSize), makeEspresso(brewType)))
            return drink;

        return null;
    }

    public CoffeeDrink makeCappuccino(String cupSize, String brewType) {

        CoffeeDrink drink = new Cappuccino(inventory);

        if (drink.prepare(selectCup(cupSize), makeEspresso(brewType)))
            return drink;

        return null;
    }
}
