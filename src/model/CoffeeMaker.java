package model;

/**
 * CoffeeMaker
 */
public class CoffeeMaker {

    private StorageBin inventory;
    private StorageBin specialInventory;

    public CoffeeMaker(StorageBin inventory) {
        this.inventory = inventory;
    }

    public void setInventory(StorageBin inventory) {
        this.inventory = inventory;
    }

    public void setSpecialInventory(StorageBin inventory) {
        this.specialInventory = inventory;
    }

    public Espresso makeEspresso(double ratio) {
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

    private CoffeeDrink selectDrink(String drinkName) {
        CoffeeDrink drink = switch (drinkName) {
            case "Americano" -> new Americano(inventory);
            case "Latte" -> new Latte(inventory);
            case "Cappuccino" -> new Cappuccino(inventory);
            default -> null;
        };
        return drink;
    }

    public AddOn selectAddOn(String drinkName) {
        AddOn drink = switch (drinkName) {
            case "Hazelnut" -> new HazelnutSyrup();
            case "Vanilla" -> new VanillaSyrup();
            case "Chocolate" -> new ChocolateSyrup();
            case "Almond" -> new AlmondSyrup();
            case "Sucrose" -> new SucroseSyrup();
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

    public CoffeeDrink makeDrink(String drinkName, String cupSize, double espressoRatio) {

        CoffeeDrink drink = selectDrink(drinkName);

        if (drink.prepare(selectCup(cupSize), makeEspresso(espressoRatio)))
            return drink;

        return null;
    }

    public AddOn makeAddOn(String addOnName) {

        AddOn addOn = selectAddOn(addOnName);

        if (specialInventory.consume(addOnName, 1))
            return addOn;

        return null;
    }

}
