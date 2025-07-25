package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JSpinner;

import model.CoffeeBusiness;
import model.PriceEntry;
import model.PriceList;
import view.RootView;
import view.SetPricesPanel;

/**
 * SetPricesController
 */
public class SetPricesController extends AbstractPageController {

    private SetPricesPanel setPricesPanel;

    public SetPricesController(CoffeeBusiness model, RootView view, MasterController controller) {
        super(model, view, controller);

        setPricesPanel = new SetPricesPanel();

        ActionListener navigateSetPrices = new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                ArrayList<JSpinner> spinners = setPricesPanel.getSpinners();
                String[] drinks = setPricesPanel.getDrinks();
                String[] sizes = setPricesPanel.getSizes();
                PriceList priceList = new PriceList();

                int i = 0;
                boolean isValid = true;

                for (String drink : drinks) {
                    for (String size : sizes) {
                        JSpinner spinner = spinners.get(i);
                        if ((int) spinner.getValue() <= 0) {
                            isValid = false;
                        } else {
                            priceList.addPriceEntry(new PriceEntry(drink, size, "Regular"));
                        }
                    }
                }

                if (isValid == true) {
                    model.setPriceList(priceList);
                    controller.getController("MainMenu").goTo();
                }
            }
        };

        setPricesPanel.addSetPricesListener(navigateSetPrices);
    }

    @Override
    public String getPageName() {
        return "SetPrices";
    }

    @Override
    public void goTo() {
        view.getFrame().setPage(setPricesPanel);
        setPricesPanel.setSelectedTruckText(model.getSelectedTruck().getLocation());
        setPricesPanel.setTruckTypeText(model.getSelectedTruck().getType());
    }
}
