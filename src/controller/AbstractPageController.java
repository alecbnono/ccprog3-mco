package controller;

import model.CoffeeBusiness;
import view.RootView;

/**
 * AbstractPageController
 */
public abstract class AbstractPageController {

    protected CoffeeBusiness model;
    protected RootView view;
    protected MasterController controller;

    public AbstractPageController(CoffeeBusiness model, RootView view, MasterController controller) {
        this.view = view;
        this.controller = controller;
        this.model = model;
    }

    public abstract String getPageName();

    public abstract void goTo();
}
