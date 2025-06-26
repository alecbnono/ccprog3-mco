package model;
import java.util.ArrayList;

public class PriceList {
    private ArrayList<PriceEntry> Prices;

    public PriceList() {
        this.Prices = new ArrayList<>();
    }

    public void addPriceEntry(PriceEntry entry) {
        Prices.add(entry);
    }

    public PriceList getRegularPrices(){
        PriceList regularList = new PriceList();
        for (PriceEntry entry : Prices) {
            regularList.addPriceEntry(entry);
        }
        return regularList;
    }

    public void updateRegularPrices() {
        for (PriceEntry entry : Prices) {
            if (entry.getType() != null && entry.getType().equals("regular")) {
                entry.updatePrice(entry.getPrice() * 1.05); // increase by 5%
            }
        }
    }
}
