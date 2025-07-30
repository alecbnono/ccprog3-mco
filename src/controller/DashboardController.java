package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.*;
import view.DashboardPanel;
import view.RootView;

/**
 * Controller for the dashboard page in the coffee truck management system.
 * <p>
 * This class handles displaying an overview of deployed trucks, inventory totals,
 * and aggregate sales. It also connects the dashboard view with user interactions,
 * such as navigating back to the main menu.
 * </p>
 */
public class DashboardController extends AbstractPageController {

    /** The panel representing the dashboard view. */
    private DashboardPanel dashboardPanel;

    /** Predefined array of regular inventory types tracked across all trucks. */
    private Binable[] regularInventoryTypes = {
            new CoffeeBeans(0),
            new Water(0),
            new Milk(0),
            new SmallCup(0),
            new MediumCup(0),
            new LargeCup(0)
    };

    /** Predefined array of special inventory types tracked across special trucks. */
    private Binable[] specialInventoryTypes = {
            new HazelnutSyrup(0),
            new VanillaSyrup(0),
            new ChocolateSyrup(0),
            new AlmondSyrup(0),
            new SucroseSyrup(0)
    };

    /**
     * Constructs a DashboardController that initializes the dashboard panel,
     * displays truck deployment info, inventory summary, and aggregate sales.
     * Adds a listener to navigate back to the main menu.
     *
     * @param model      the main CoffeeBusiness model
     * @param view       the root view of the application
     * @param controller the master controller
     */
    public DashboardController(CoffeeBusiness model, RootView view, MasterController controller) {
        super(model, view, controller);
        dashboardPanel = new DashboardPanel();

        // Retrieve truck counts
        int specialCount = model.getSpecificTruckCount("Special");
        int regularCount = model.getSpecificTruckCount("Regular");

        // Prepare truck deployment summary
        StringBuilder truckOutput = new StringBuilder();
        truckOutput.append(String.format("Trucks Deployed Total:  %d\n", regularCount + specialCount));
        truckOutput.append(String.format("- Regular Trucks:  %d\n", regularCount));
        truckOutput.append(String.format("- Special Trucks:  %d\n", specialCount));

        dashboardPanel.setTruckInfo(truckOutput.toString());

        ArrayList<CoffeeTruck> trucks = model.getTrucks();

        // Build inventory summary
        StringBuilder inventoryOutput = new StringBuilder();
        inventoryOutput.append(String.format("Inventory Overview (All Trucks):\n"));

        // Sum regular inventory across all trucks
        for (Binable item : regularInventoryTypes) {
            double total = 0;
            for (CoffeeTruck truck : trucks) {
                total += truck.getInventory().getTotalAmount(item.getType());
            }

            if (item instanceof CoffeeCup) {
                inventoryOutput.append(String.format("- %-20s %7.0f %s\n", item.getType(), total, item.getUnit()));
            } else {
                inventoryOutput.append(String.format("- %-20s %7.2f %s\n", item.getType(), total, item.getUnit()));
            }
        }

        // Sum special inventory across all special trucks
        for (Binable item : specialInventoryTypes) {
            double total = 0;
            for (CoffeeTruck truck : trucks) {
                if (truck instanceof SpecialCoffeeTruck) {
                    total += ((SpecialCoffeeTruck) truck).getSpecialInventory().getTotalAmount(item.getType());
                }
            }


            inventoryOutput.append(String.format("- %-20s %7.2f %s\n", item.getType(), total, item.getUnit()));

        }

        dashboardPanel.setInventoryInfo(inventoryOutput.toString());

        // Display total sales
        dashboardPanel.setSalesInfo(model.getTransactionList().getAggregateSales());

        // Set up listener to go back to main menu
        ActionListener navigateMainMenu = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.getController("MainMenu").goTo();
            }
        };

        ActionListener navigateTransactions = new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                controller.getController("TransactionList").goTo();

            }
        };
        dashboardPanel.addTransactionsListener(navigateTransactions);
        dashboardPanel.addMainMenuListener(navigateMainMenu);
    }

    /**
     * Returns the name of this page controller.
     *
     * @return the string "Dashboard"
     */
    @Override
    public String getPageName() {
        return "Dashboard";
    }

    /**
     * Navigates to the dashboard view. Clears the currently selected truck and
     * sets the current operation context.
     */
    @Override
    public void goTo() {
        controller.setCurrentOperation("ViewDashboard");
        view.getFrame().setPage(dashboardPanel);
    }
}
