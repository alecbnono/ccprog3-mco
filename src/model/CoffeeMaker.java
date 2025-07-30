package model;

/**
 * The {@code CoffeeMaker} class acts as a factory and utility class for preparing
 * coffee drinks and their components such as espresso, cups, and add-ons.
 * <p>
 * It uses one or more {@link StorageBin} instances as ingredient inventories.
 * It supports both predefined and custom espresso brews, as well as various drink
 * types and cup sizes.
 * </p>
 *
 * This class plays a central role in assembling drink orders in the coffee truck system.
 *
 * @author
 */
public class CoffeeMaker {

    /** The primary inventory for regular ingredients like water, milk, cups. */
    private StorageBin inventory;

    /** A secondary inventory used for special items like flavored syrups. */
    private StorageBin specialInventory;

    /**
     * Constructs a {@code CoffeeMaker} with the specified ingredient inventory.
     *
     * @param inventory the main {@link StorageBin} for coffee ingredients
     */
    public CoffeeMaker(StorageBin inventory) {
        this.inventory = inventory;
    }

    /**
     * Sets or replaces the primary inventory.
     *
     * @param inventory the new {@link StorageBin} to use
     */
    public void setInventory(StorageBin inventory) {
        this.inventory = inventory;
    }

    /**
     * Sets or replaces the special inventory used for add-ons.
     *
     * @param inventory the special {@link StorageBin} for syrups and extras
     */
    public void setSpecialInventory(StorageBin inventory) {
        this.specialInventory = inventory;
    }

    /**
     * Creates a custom espresso with a user-defined brew ratio.
     *
     * @param ratio the espresso-to-water ratio (e.g., 1.5 for stronger brews)
     * @return a new {@link CustomBrew} instance
     */
    public Espresso makeEspresso(double ratio) {
        return new CustomBrew(inventory, ratio);
    }

    /**
     * Creates a predefined espresso based on a standard brew type.
     *
     * @param type the brew type ("Light", "Standard", "Strong")
     * @return an {@link Espresso} object, or {@code null} if the type is unrecognized
     */
    public Espresso makeEspresso(String type) {
        Espresso espresso = switch (type) {
            case "Light" -> new LightBrew(inventory);
            case "Standard" -> new StandardBrew(inventory);
            case "Strong" -> new StrongBrew(inventory);
            default -> null;
        };

        return espresso;
    }

    /**
     * Selects and returns a coffee drink instance based on the drink name.
     *
     * @param drinkName the name of the drink (e.g., "Americano", "Latte")
     * @return the corresponding {@link CoffeeDrink}, or {@code null} if unknown
     */
    private CoffeeDrink selectDrink(String drinkName) {
        CoffeeDrink drink = switch (drinkName) {
            case "Americano" -> new Americano(inventory);
            case "Latte" -> new Latte(inventory);
            case "Cappuccino" -> new Cappuccino(inventory);
            default -> null;
        };
        return drink;
    }

    /**
     * Selects and returns an add-on object based on the name.
     *
     * @param drinkName the name of the add-on (e.g., "Vanilla", "Hazelnut")
     * @return an {@link AddOn} instance, or {@code null} if not found
     */
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

    /**
     * Selects the appropriate coffee cup size.
     *
     * @param size the size of the cup ("Small", "Medium", "Large")
     * @return a corresponding {@link CoffeeCup} instance, or {@code null} if size is unknown
     */
    public CoffeeCup selectCup(String size) {
        CoffeeCup cup = switch (size) {
            case "Small" -> new SmallCup();
            case "Medium" -> new MediumCup();
            case "Large" -> new LargeCup();
            default -> null;
        };
        return cup;
    }

    /**
     * Prepares a predefined coffee drink using a named brew type and cup size.
     *
     * @param drinkName the drink to prepare (e.g., "Latte")
     * @param cupSize   the cup size ("Small", "Medium", "Large")
     * @param brewType  the espresso brew type ("Light", "Standard", "Strong")
     * @return the prepared {@link CoffeeDrink}, or {@code null} if preparation failed
     */
    public CoffeeDrink makeDrink(String drinkName, String cupSize, String brewType) {
        CoffeeDrink drink = selectDrink(drinkName);

        if (drink.prepare(selectCup(cupSize), makeEspresso(brewType)))
            return drink;

        return null;
    }

    /**
     * Prepares a coffee drink using a custom espresso brew ratio.
     *
     * @param drinkName      the drink to prepare
     * @param cupSize        the cup size
     * @param espressoRatio  the custom espresso-to-liquid ratio
     * @return the prepared {@link CoffeeDrink}, or {@code null} if preparation failed
     */
    public CoffeeDrink makeDrink(String drinkName, String cupSize, double espressoRatio) {
        CoffeeDrink drink = selectDrink(drinkName);

        if (drink.prepare(selectCup(cupSize), makeEspresso(espressoRatio)))
            return drink;

        return null;
    }

    /**
     * Prepares an add-on (e.g., syrup) if the special inventory has enough stock.
     *
     * @param addOnName the name of the add-on to prepare
     * @return an {@link AddOn} object if successful; {@code null} if stock is insufficient
     */
    public AddOn makeAddOn(String addOnName) {
        AddOn addOn = selectAddOn(addOnName);

        if (specialInventory.consume(addOnName, 1))
            return addOn;

        return null;
    }
}
