package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.CoffeeBusiness;

import view.SetLocationPanel;
import view.RootView;

/**
 * The {@code SetLocationController} class is responsible for managing the
 * logic behind the Set Location page in the Coffee Truck simulation system.
 * It connects the {@code SetLocationPanel} view with the underlying business model
 * and handles events triggered by the user.
 *
 * <p>It performs input validation for setting a new truck location,
 * ensuring it is non-empty and not already in use by another truck.</p>
 *
 * <p>This controller also navigates back to the Interactions Menu page after a successful operation.</p>
 *
 * @author
 */
public class SetLocationController extends AbstractPageController {

    /** The view panel for setting a truck's location. */
    private SetLocationPanel setLocationPanel;

    /**
     * Constructs a new {@code SetLocationController} instance with the given model, view, and master controller.
     *
     * @param model       the {@code CoffeeBusiness} model containing business logic and data
     * @param view        the root view of the application
     * @param controller  the master controller managing all page controllers
     */
    public SetLocationController(CoffeeBusiness model, RootView view, MasterController controller) {
        super(model, view, controller);
        setLocationPanel = new SetLocationPanel();

        // Listener to go back to Interactions Menu
        ActionListener navigateInteractionsMenu = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.getController("InteractionsMenu").goTo();
            }
        };

        // Listener for submitting new location
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

    /**
     * Returns the name of this page controller.
     *
     * @return the string "SetLocation"
     */
    @Override
    public String getPageName() {
        return "SetLocation";
    }

    /**
     * Navigates to the Set Location page by updating the view.
     */
    @Override
    public void goTo() {
        view.getFrame().setPage(setLocationPanel);
    }

}
