package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.CoffeeBusiness;
import model.CoffeeTruck;
import view.InteractionsMenuPanel;
import view.RootView;

/**
 * InteractionsMenuController
 */
public class InteractionsMenuController extends AbstractPageController {

    private InteractionsMenuPanel interactionsMenuPanel;

    public InteractionsMenuController(CoffeeBusiness model, RootView view, MasterController controller) {
        super(model, view, controller);

        interactionsMenuPanel = new InteractionsMenuPanel();

        ActionListener selectTruck = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.setSelectedTruck(interactionsMenuPanel.getSelectedString());
            }
        };

        ActionListener navigateMainMenu = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.setSelectedTruck(interactionsMenuPanel.getSelectedString());
                controller.getController("MainMenu").goTo();
            }
        };

        ActionListener navigateViewPrices = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.setSelectedTruck(interactionsMenuPanel.getSelectedString());
                controller.getController("DisplayPrices").goTo();
            }
        };

        ActionListener navigateViewInventory = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.setSelectedTruck(interactionsMenuPanel.getSelectedString());
                controller.getController("DisplayInventory").goTo();
            }
        };

        ActionListener navigateSimulateTruck = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.setSelectedTruck(interactionsMenuPanel.getSelectedString());
                controller.getController("SimulateTruck").goTo();
            }
        };

        interactionsMenuPanel.addSimulateTruckListener(navigateSimulateTruck);
        interactionsMenuPanel.addViewPricesListener(navigateViewPrices);
        interactionsMenuPanel.addViewInventoryListener(navigateViewInventory);
        interactionsMenuPanel.addComboBoxListener(selectTruck);
        interactionsMenuPanel.addMainMenuListener(navigateMainMenu);
    }

    private String[] listTrucks() {

        ArrayList<String> truckNames = new ArrayList<String>();

        for (CoffeeTruck truck : model.getTrucks()) {
            truckNames.add(truck.getLocation());
        }

        return truckNames.toArray(new String[truckNames.size()]);
    }

    @Override
    public String getPageName() {
        return "InteractionsMenu";
    }

    @Override
    public void goTo() {
        controller.setCurrentOperation("InteractionMenu");
        interactionsMenuPanel.addTruckList(listTrucks());
        view.getFrame().setPage(interactionsMenuPanel);
    }
}
