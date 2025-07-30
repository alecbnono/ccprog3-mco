package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.CoffeeBusiness;
import model.CoffeeTruck;
import view.InteractionsMenuPanel;
import view.RootView;

/**
 * Controls the behavior of the Interactions Menu screen, where the user can:
 * <ul>
 *     <li>Select a truck</li>
 *     <li>Navigate to other pages like Main Menu, Display Prices, Inventory, etc.</li>
 * </ul>
 * It connects the {@link InteractionsMenuPanel} view with the {@link CoffeeBusiness} model.
 */
public class InteractionsMenuController extends AbstractPageController {

    /** Panel for interacting with truck-related actions. */
    private InteractionsMenuPanel interactionsMenuPanel;

    /**
     * Constructs an {@code InteractionsMenuController} and initializes the
     * navigation and combo box listeners for various actions.
     *
     * @param model      the business model containing truck data
     * @param view       the main application frame/view
     * @param controller the master controller to delegate navigation
     */
    public InteractionsMenuController(CoffeeBusiness model, RootView view, MasterController controller) {
        super(model, view, controller);

        interactionsMenuPanel = new InteractionsMenuPanel();

        // Listener for selecting a truck from the dropdown
        ActionListener selectTruck = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.setSelectedTruck(interactionsMenuPanel.getSelectedString());
            }
        };

        // Navigate to Main Menu
        ActionListener navigateMainMenu = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.setSelectedTruck(interactionsMenuPanel.getSelectedString());
                controller.getController("MainMenu").goTo();
            }
        };

        // Navigate to View Prices
        ActionListener navigateViewPrices = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.setSelectedTruck(interactionsMenuPanel.getSelectedString());
                controller.getController("DisplayPrices").goTo();
            }
        };

        // Navigate to View Inventory
        ActionListener navigateViewInventory = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.setSelectedTruck(interactionsMenuPanel.getSelectedString());
                controller.getController("DisplayInventory").goTo();
            }
        };

        // Navigate to Simulate Truck
        ActionListener navigateSimulateTruck = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.setSelectedTruck(interactionsMenuPanel.getSelectedString());
                controller.getController("SimulateTruck").goTo();
            }
        };

        // Navigate to Change Truck Location
        ActionListener navigateChangeLocation = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.setSelectedTruck(interactionsMenuPanel.getSelectedString());
                controller.getController("SetLocation").goTo();
            }
        };

        // Register listeners to the panel
        interactionsMenuPanel.addSimulateTruckListener(navigateSimulateTruck);
        interactionsMenuPanel.addChangeLocationListener(navigateChangeLocation);
        interactionsMenuPanel.addViewPricesListener(navigateViewPrices);
        interactionsMenuPanel.addViewInventoryListener(navigateViewInventory);
        interactionsMenuPanel.addComboBoxListener(selectTruck);
        interactionsMenuPanel.addMainMenuListener(navigateMainMenu);
    }

    /**
     * Generates a list of all truck locations to be displayed in the combo box.
     *
     * @return an array of truck location strings
     */
    private String[] listTrucks() {
        ArrayList<String> truckNames = new ArrayList<String>();

        for (CoffeeTruck truck : model.getTrucks()) {
            truckNames.add(truck.getLocation());
        }

        return truckNames.toArray(new String[truckNames.size()]);
    }

    /**
     * Returns the name identifier of this page.
     *
     * @return the string "InteractionsMenu"
     */
    @Override
    public String getPageName() {
        return "InteractionsMenu";
    }

    /**
     * Displays the Interactions Menu panel, populates the truck list,
     * and resets current operation and receipt information in the master controller.
     */
    @Override
    public void goTo() {
        controller.setCurrentOperation("InteractionMenu");
        controller.setCurrentReceipt("");
        interactionsMenuPanel.addTruckList(listTrucks());
        view.getFrame().setPage(interactionsMenuPanel);
    }
}
