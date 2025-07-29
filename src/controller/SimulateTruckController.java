package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.CoffeeBusiness;
import model.CoffeeTruck;
import view.SimulateTruckPanel;
import view.RootView;

/**
 * SimulateTruckController
 */
public class SimulateTruckController extends AbstractPageController {

    private SimulateTruckPanel simulateTruckPanel;

    public SimulateTruckController(CoffeeBusiness model, RootView view, MasterController controller) {
        super(model, view, controller);

        simulateTruckPanel = new SimulateTruckPanel();

        ActionListener submitButton = new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        };

        ActionListener navigateInteractionsMenu = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.getController("InteractionsMenu").goTo();
            }
        };

        simulateTruckPanel.addInteractionsMenuListener(navigateInteractionsMenu);
    }

    @Override
    public String getPageName() {
        return "SimulateTruck";
    }

    @Override
    public void goTo() {
        simulateTruckPanel.setMenu(model.getSelectedTruck().getType());
        view.getFrame().setPage(simulateTruckPanel);
    }
}
