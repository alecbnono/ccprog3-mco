package controller;

import java.util.ArrayList;

import view.RootView;
import model.CoffeeBusiness;

/**
 * MasterController
 */
public class MasterController {

    private CoffeeBusiness model;
    private ArrayList<AbstractPageController> controllers;

    public MasterController(CoffeeBusiness model, RootView view) {

        this.model = model;
        this.controllers = new ArrayList<AbstractPageController>();

        controllers.add(new MainMenuController(model, view, this));
        controllers.add(new CreateTruckController(model, view, this));
        controllers.add(new InteractionsMenuController(model, view, this));
        controllers.add(new SetBinsController(model, view, this));
        controllers.add(new SetPricesController(model, view, this));

        this.getController("MainMenu").goTo();
    }

    public AbstractPageController getController(String name) {
        for (AbstractPageController controller : controllers) {
            if (controller.getPageName().equalsIgnoreCase(name)) {
                return controller;
            }
        }
        return null;
    }
}
