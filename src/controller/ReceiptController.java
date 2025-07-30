package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.CoffeeBusiness;
import view.ReceiptPanel;
import view.RootView;

/**
 * Controller responsible for handling interactions on the Receipt page.
 *
 * <p>This controller displays the most recent transaction receipt and allows
 * navigation back to the Interactions Menu.</p>
 */
public class ReceiptController extends AbstractPageController {

    /** The panel used to display the receipt. */
    private ReceiptPanel receiptPanel;

    /**
     * Constructs a {@code ReceiptController} and sets up event listeners for navigation.
     *
     * @param model      the business model containing application state and data
     * @param view       the main view container (e.g., frame manager)
     * @param controller the central {@code MasterController} for navigation
     */
    public ReceiptController(CoffeeBusiness model, RootView view, MasterController controller) {
        super(model, view, controller);
        receiptPanel = new ReceiptPanel();

        // Set up button to return to Interactions Menu
        ActionListener navigateInteractionsMenu = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.getController("InteractionsMenu").goTo();
            }
        };

        receiptPanel.addInteractionsMenuListener(navigateInteractionsMenu);
    }

    /**
     * Returns the name of this page controller.
     *
     * @return the string "Receipt"
     */
    @Override
    public String getPageName() {
        return "Receipt";
    }

    /**
     * Loads and displays the receipt content, and shows the Receipt panel in the main frame.
     */
    @Override
    public void goTo() {
        receiptPanel.setOutputString(controller.getCurrentReceipt());
        view.getFrame().setPage(receiptPanel);
    }
}
