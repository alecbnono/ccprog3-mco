package controller;

import model.CoffeeBusiness;
import view.RootView;

/**
 * An abstract base class for all page-specific controllers in the application.
 * <p>
 * This class defines shared references to the model, view, and master controller,
 * and requires all subclasses to specify the page name and navigation behavior.
 * </p>
 */
public abstract class AbstractPageController {

    /** The CoffeeBusiness model representing the application's core logic and data. */
    protected CoffeeBusiness model;

    /** The main RootView which holds all UI components and panels. */
    protected RootView view;

    /** The central controller that coordinates switching between different page controllers. */
    protected MasterController controller;

    /**
     * Constructs an AbstractPageController with references to the model, view, and master controller.
     *
     * @param model      the CoffeeBusiness model instance
     * @param view       the RootView containing all UI pages
     * @param controller the master controller for coordinating page navigation
     */
    public AbstractPageController(CoffeeBusiness model, RootView view, MasterController controller) {
        this.view = view;
        this.controller = controller;
        this.model = model;
    }

    /**
     * Returns the name of the page this controller represents.
     *
     * @return the page name
     */
    public abstract String getPageName();

    /**
     * Performs the actions required to navigate to this page.
     * Typically involves updating the view to display the corresponding panel.
     */
    public abstract void goTo();
}
