package controller;

import java.util.ArrayList;

import view.RootView;
import model.CoffeeBusiness;

/**
 * The central navigation and coordination controller for the entire application.
 *
 * <p>It holds references to all individual page controllers and manages the
 * transition between different views (pages) of the coffee truck system.</p>
 *
 * <p>This controller also tracks the current operation and receipt status
 * to support contextual behavior across different views.</p>
 */
public class MasterController {

    /** The business logic model of the application. */
    private CoffeeBusiness model;

    /** A list of all controllers for individual pages/screens. */
    private ArrayList<AbstractPageController> controllers;

    /** The name of the current operation or mode (e.g., "InteractionMenu", ""). */
    private String currentOperation = "";

    /** A string representation of the most recent transaction receipt. */
    private String currentReceipt = "";

    /**
     * Constructs a {@code MasterController}, initializes all page controllers,
     * and opens the Main Menu by default.
     *
     * @param model the business model containing application state and data
     * @param view  the main view container (e.g., frame manager)
     */
    public MasterController(CoffeeBusiness model, RootView view) {
        this.model = model;
        this.controllers = new ArrayList<AbstractPageController>();

        // Register all controllers/pages
        controllers.add(new MainMenuController(model, view, this));
        controllers.add(new CreateTruckController(model, view, this));
        controllers.add(new InteractionsMenuController(model, view, this));
        controllers.add(new SetBinsController(model, view, this));
        controllers.add(new SetPricesController(model, view, this));
        controllers.add(new DisplayPricesController(model, view, this));
        controllers.add(new DisplayInventoryController(model, view, this));
        controllers.add(new SimulateTruckController(model, view, this));
        controllers.add(new ReceiptController(model, view, this));
        controllers.add(new SetLocationController(model, view, this));
        controllers.add(new DashboardController(model, view, this));
        controllers.add(new TransactionListController(model, view, this));

        // Show the main menu initially
        this.getController("MainMenu").goTo();
    }

    /**
     * Returns the current operation context (e.g., current page or mode).
     *
     * @return the name of the current operation
     */
    public String getCurrentOperation() {
        return currentOperation;
    }

    /**
     * Sets the current operation context.
     *
     * @param currentOperation the operation name to set
     */
    public void setCurrentOperation(String currentOperation) {
        this.currentOperation = currentOperation;
    }

    /**
     * Returns the currently active receipt string.
     *
     * @return the latest receipt contents
     */
    public String getCurrentReceipt() {
        return currentReceipt;
    }

    /**
     * Sets the current receipt string.
     *
     * @param currentReceipt the receipt contents to store
     */
    public void setCurrentReceipt(String currentReceipt) {
        this.currentReceipt = currentReceipt;
    }

    /**
     * Retrieves a controller by its page name (case-insensitive).
     *
     * @param name the name of the page (e.g., "MainMenu", "DisplayPrices")
     * @return the corresponding {@code AbstractPageController}, or {@code null} if not found
     */
    public AbstractPageController getController(String name) {
        for (AbstractPageController controller : controllers) {
            if (controller.getPageName().equalsIgnoreCase(name)) {
                return controller;
            }
        }
        return null;
    }
}
