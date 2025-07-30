package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.CoffeeBusiness;

import view.SetLocationPanel;
import view.RootView;

/**
 * SetLocationController
 */
public class SetLocationController extends AbstractPageController {

    private SetLocationPanel setLocationPanel;

    public SetLocationController(CoffeeBusiness model, RootView view, MasterController controller) {
        super(model, view, controller);
        setLocationPanel = new SetLocationPanel();

        ActionListener navigateInteractionsMenu = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.getController("InteractionsMenu").goTo();
            }
        };

        ActionListener submitButton = new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String newLocation = setLocationPanel.getNewLocation();

                boolean hasTruckLocation = newLocation != null && !newLocation.trim().isEmpty();
                boolean isLocationTaken = hasTruckLocation && model.isLocationTaken(newLocation);

                if (!hasTruckLocation) {
                    JOptionPane.showMessageDialog(setLocationPanel,
                            "Please enter a valid truck location.",
                            "Missing Location", JOptionPane.INFORMATION_MESSAGE);
                } else if (isLocationTaken) {
                    JOptionPane.showMessageDialog(setLocationPanel,
                            "Truck location is already taken.",
                            "Location Unavailable", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    model.getSelectedTruck().setLocation(newLocation);
                    controller.getController("InteractionsMenu").goTo();
                }

            }
        };

        setLocationPanel.addInteractionsMenuListener(navigateInteractionsMenu);
        setLocationPanel.addSetLocationListener(submitButton);
    }

    @Override
    public String getPageName() {
        return "SetLocation";
    }

    @Override
    public void goTo() {
        view.getFrame().setPage(setLocationPanel);
    }

}
