package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;

import model.CoffeeBusiness;
import model.CoffeeTruck;
import model.StorageBin;
import model.Binable;
import model.PriceEntry;
import model.PriceList;
import model.SpecialCoffeeTruck;
import model.TransactionList;
import view.DisplayInventoryPanel;
import view.RootView;

/**
 * Controller responsible for managing the logic and interactions
 * on the Display Inventory screen.
 * <p>
 * This controller displays the current inventory of the selected truck,
 * and allows the user to navigate to either the update inventory screen
 * or return to the interactions menu.
 * </p>
 */
public class DisplayInventoryController extends AbstractPageController {

    /** The panel that displays the truck inventory. */
    private DisplayInventoryPanel displayInventoryPanel;

    /**
     * Constructs a DisplayInventoryController, sets up the panel and attaches
     * navigation listeners to the appropriate buttons.
     *
     * @param model      the CoffeeBusiness model containing the trucks and inventory
     * @param view       the root view used to switch screens
     * @param controller the master controller managing navigation between pages
     */
    public DisplayInventoryController(CoffeeBusiness model, RootView view, MasterController controller) {
        super(model, view, controller);
        displayInventoryPanel = new DisplayInventoryPanel();

        // Listener to go back to the Interactions Menu
        ActionListener navigateInteractionsMenu = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.getController("InteractionsMenu").goTo();
            }
        };

        // Listener to go to the Set Bins (Update Inventory) screen
        ActionListener navigateUpdateInventory = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.getController("SetBins").goTo();
            }
        };

        displayInventoryPanel.addUpdateInventoryListener(navigateUpdateInventory);
        displayInventoryPanel.addInteractionsMenuListener(navigateInteractionsMenu);
    }

    /**
     * Builds a table model containing the inventory data of the selected truck.
     * Includes both standard and special inventory if the truck is a special type.
     *
     * @return a {@code DefaultTableModel} representing the truck's inventory
     */
    private DefaultTableModel buildInventoryTableModel() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Item");
        model.addColumn("Amount");
        model.addColumn("Unit");

        // Regular inventory
        ArrayList<Binable> bins = this.model.getSelectedTruck().getInventory().getInventory();
        for (Binable binable : bins) {
            model.addRow(
                    new Object[] { binable.getType(), String.format("%.2f", binable.getAmount()), binable.getUnit() });
        }

        // Special inventory (if applicable)
        if (this.model.getSelectedTruck().getType().equals("Special")) {
            ArrayList<Binable> specialBins = ((SpecialCoffeeTruck) this.model.getSelectedTruck())
                    .getSpecialInventory().getInventory();

            for (Binable binable : specialBins) {
                model.addRow(new Object[] { binable.getType(), binable.getAmount(), binable.getUnit() });
            }
        }

        return model;
    }

    /**
     * Returns the unique page name for the controller.
     *
     * @return the string "DisplayInventory"
     */
    @Override
    public String getPageName() {
        return "DisplayInventory";
    }

    /**
     * Navigates to the inventory display panel and injects the table model.
     */
    @Override
    public void goTo() {
        displayInventoryPanel.addInventoryTable(buildInventoryTableModel());
        view.getFrame().setPage(displayInventoryPanel);
    }

}
