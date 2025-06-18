package model;

import java.util.ArrayList;

public class CoffeeRecipe {
    private final double BEAN_RATIO = 1.0 / 19.0;
    private final double  FLOZ_TO_GRAMS = 28.34962;

    private double getFlOz(String size){
        return switch(size.toLowerCase()){
            case "small" -> 8;
            case "medium" -> 12;
            case "large" -> 16;
            default -> 0;
        };
    }

    private boolean brewEspresso(StorageBin[] inventory, double fluidOz){
        double EspressoGrams = fluidOz * FLOZ_TO_GRAMS;
        double CoffeeGrams = EspressoGrams * BEAN_RATIO;
        double WaterGrams = EspressoGrams - CoffeeGrams;

    }
    public boolean makeAmericano(StorageBin[] inventory, String size){
        double cupSize = getFlOz(size);
    }
}
