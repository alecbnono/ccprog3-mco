package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.CoffeeBusiness;

import view.CreateTruckPanel;
import view.RootView;

/**
 * CreateTruckController
 */
public class CreateTruckController extends AbstractPageController {

    private CreateTruckPanel createTruckPanel;

    public CreateTruckController(CoffeeBusiness model, RootView view, MasterController controller) {
        super(model, view, controller);
        createTruckPanel = new CreateTruckPanel();

        ActionListener navigateSetBins = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String truckType = createTruckPanel.getTruckType();
                String truckLocation = createTruckPanel.getTruckLocation();

                if (truckType != null && !(truckLocation.trim().isEmpty() || truckLocation == null)) {
                    model.createTruck(truckLocation, truckType);
                    controller.getController("SetBins").goTo();
                } else {
                    JOptionPane.showMessageDialog(createTruckPanel, "Invalid Name and/or No Selected Truck type",
                            "Failed", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        };

        createTruckPanel.addCreateTruckListener(navigateSetBins);

    }

    @Override
    public String getPageName() {
        return "CreateTruck";
    }

    @Override
    public void goTo() {
        controller.setCurrentOperation("CreateTruck");
        view.getFrame().setPage(createTruckPanel);
    }

}
