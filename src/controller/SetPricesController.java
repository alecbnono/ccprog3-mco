package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JSpinner;

import model.CoffeeBusiness;
import model.PriceEntry;
import model.PriceList;
import view.RootView;
import view.SetPricesPanel;

/**
 * The {@code SetPricesController} class handles logic for the Set Prices page
 * in the coffee truck management system. It enables users to define the price
 * of different drink types and sizes as well as add-ons, and stores the pricing
 * in the {@code CoffeeBusiness} model.
 *
 * <p>This controller validates user input, builds a {@code PriceList} object
 * using data from the UI spinners, and either proceeds to the appropriate next
 * page or shows an error message if inputs are invalid.</p>
 *
 * <p>It also displays contextual information about the selected truck when the page is visited.</p>
 *
 * @author
 */
public class SetPricesController extends AbstractPageController {

    /** The panel representing the Set Prices view. */
    private SetPricesPanel setPricesPanel;

    /**
     * Constructs a new {@code SetPricesController}.
     *
     * @param model       the {@code CoffeeBusiness} model containing business logic and data
     * @param view        the root application view
     * @param controller  the master controller managing all page controllers
     */
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

                // Process drink and size combinations
                for (String drink : drinks) {
                    for (String size : sizes) {
                        JSpinner spinner = spinners.get(i);
                        if ((int) spinner.getValue() <= 0) {
                            isValid = false;
                        } else {
                            priceList.addPriceEntry(new PriceEntry(drink, size, (int) spinner.getValue()));
                        }
                        i++;
                    }
                }

                // Process add-on price
                if ((int) spinners.get(i).getValue() <= 0) {
                    isValid = false;
                } else {
                    priceList.addPriceEntry(new PriceEntry("Add-Ons", "", (int) spinners.get(i).getValue()));
                }

                // Save and navigate if valid
                if (isValid) {
                    model.setPriceList(priceList);
                    if (controller.getCurrentOperation().equals("CreateTruck")) {
                        controller.getController("MainMenu").goTo();
                    } else {
                        controller.getController("DisplayPrices").goTo();
                    }
                } else {
                    JOptionPane.showMessageDialog(setPricesPanel,
                            "Invalid Prices",
                            "Missing Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        };

        setPricesPanel.addSetPricesListener(navigateSetPrices);
    }

    /**
     * Returns the name of this page for routing purposes.
     *
     * @return the string "SetPrices"
     */
    @Override
    public String getPageName() {
        return "SetPrices";
    }

    /**
     * Navigates to the Set Prices page, initializing truck-specific details.
     */
    @Override
    public void goTo() {
        view.getFrame().setPage(setPricesPanel);
        setPricesPanel.setSelectedTruckText(model.getSelectedTruck().getLocation());
        setPricesPanel.setTruckTypeText(model.getSelectedTruck().getType());
    }
}
