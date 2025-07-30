package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.CoffeeBusiness;
import view.CreateTruckPanel;
import view.RootView;

/**
 * Controller responsible for handling the logic behind the "Create Truck" page.
 * <p>
 * It connects the CreateTruckPanel UI with the underlying CoffeeBusiness model and
 * validates user inputs such as truck type and location before allowing navigation
 * to the next page (SetBins).
 * </p>
 */
public class CreateTruckController extends AbstractPageController {

    /** The panel associated with creating a new truck. */
    private CreateTruckPanel createTruckPanel;

    /**
     * Constructs a CreateTruckController with access to the model, view, and master controller.
     * Initializes the CreateTruckPanel and registers the listener for truck creation.
     *
     * @param model      the CoffeeBusiness model
     * @param view       the main application view
     * @param controller the master controller managing all page controllers
     */
    public CreateTruckController(CoffeeBusiness model, RootView view, MasterController controller) {
        super(model, view, controller);
        createTruckPanel = new CreateTruckPanel();

        // Define action when "Create Truck" button is pressed
        ActionListener navigateSetBins = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String truckType = createTruckPanel.getTruckType();
                String truckLocation = createTruckPanel.getTruckLocation();

                boolean hasTruckType = truckType != null;
                boolean hasTruckLocation = truckLocation != null && !truckLocation.trim().isEmpty();
                boolean isLocationTaken = hasTruckLocation && model.isLocationTaken(truckLocation);

                // Show appropriate error messages if input is invalid
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
                    // Valid input: create the truck and navigate to SetBins page
                    model.createTruck(truckLocation, truckType);
                    controller.getController("SetBins").goTo();
                }
            }
        };

        createTruckPanel.addCreateTruckListener(navigateSetBins);
    }

    /**
     * Returns the name of the page this controller represents.
     *
     * @return the string "CreateTruck"
     */
    @Override
    public String getPageName() {
        return "CreateTruck";
    }

    /**
     * Navigates to the CreateTruck page by setting the appropriate panel in the view.
     */
    @Override
    public void goTo() {
        controller.setCurrentOperation("CreateTruck");
        view.getFrame().setPage(createTruckPanel);
    }

}
