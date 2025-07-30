package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import model.CoffeeBusiness;
import model.PriceEntry;
import model.PriceList;
import view.DisplayPricesPanel;
import view.RootView;

/**
 * Controller for handling the display and navigation logic
 * related to the truck's price list.
 * <p>
 * This controller shows a table of product prices, and allows the user
 * to either update the prices or return to the interactions menu.
 * </p>
 */
public class DisplayPricesController extends AbstractPageController {

    /** The panel responsible for displaying price data. */
    private DisplayPricesPanel displayPricesPanel;

    /**
     * Constructs a DisplayPricesController and sets up event listeners
     * for navigating to update prices or return to the main menu.
     *
     * @param model      the business logic model
     * @param view       the root view
     * @param controller the master controller for page switching
     */
    public DisplayPricesController(CoffeeBusiness model, RootView view, MasterController controller) {
        super(model, view, controller);
        displayPricesPanel = new DisplayPricesPanel();

        // Go to Interactions Menu
        ActionListener navigateInteractionsMenu = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.getController("InteractionsMenu").goTo();
            }
        };

        // Go to Set Prices panel
        ActionListener navigateSetPrices = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.getController("SetPrices").goTo();
            }
        };

        displayPricesPanel.addUpdatePricesListener(navigateSetPrices);
        displayPricesPanel.addInteractionsMenuListener(navigateInteractionsMenu);
    }

    /**
     * Builds the table model for displaying prices based on the truck's price list.
     * The number of rows shown varies depending on whether the truck is a special type.
     *
     * @param list the {@link PriceList} containing all the pricing information
     * @return a {@code DefaultTableModel} with product, size, and formatted price
     */
    private DefaultTableModel buildPriceTableModel(PriceList list) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Product");
        model.addColumn("Size");
        model.addColumn("Price");

        int counter = 9;

        // Show an extra price if the truck is special
        if (this.model.getSelectedTruck().getType().equals("special")) {
            counter += 1;
        }

        for (int i = 0; i < counter; i++) {
            PriceEntry entry = list.getPriceEntries().get(i);
            model.addRow(new Object[] {
                    entry.getProduct(),
                    entry.getSize(),
                    String.format("₱%.2f", entry.getPrice())
            });
        }

        return model;
    }

    /**
     * Returns the name of the page handled by this controller.
     *
     * @return the string "DisplayPrices"
     */
    @Override
    public String getPageName() {
        return "DisplayPrices";
    }

    /**
     * Navigates to the display prices screen and injects the generated price table.
     */
    @Override
    public void goTo() {
        displayPricesPanel.addPriceTable(buildPriceTableModel(model.getPriceList()));
        view.getFrame().setPage(displayPricesPanel);
    }

}
