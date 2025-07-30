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

                boolean hasTruckType = truckType != null;
                boolean hasTruckLocation = truckLocation != null && !truckLocation.trim().isEmpty();
                boolean isLocationTaken = hasTruckLocation && model.isLocationTaken(truckLocation);

                if (!hasTruckType && !hasTruckLocation) {
                    JOptionPane.showMessageDialog(createTruckPanel,
                            "Please select a truck type and enter a valid location.",
                            "Missing Information", JOptionPane.INFORMATION_MESSAGE);
                } else if (!hasTruckType) {
                    JOptionPane.showMessageDialog(createTruckPanel,
                            "Please select a truck type.",
                            "Missing Truck Type", JOptionPane.INFORMATION_MESSAGE);
                } else if (!hasTruckLocation) {
                    JOptionPane.showMessageDialog(createTruckPanel,
                            "Please enter a valid truck location.",
                            "Missing Location", JOptionPane.INFORMATION_MESSAGE);
                } else if (isLocationTaken) {
                    JOptionPane.showMessageDialog(createTruckPanel,
                            "Truck location is already taken.",
                            "Location Unavailable", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    model.createTruck(truckLocation, truckType);
                    controller.getController("SetBins").goTo();
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
