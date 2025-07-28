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
    private String currentOperation = "";

    public MasterController(CoffeeBusiness model, RootView view) {

        this.model = model;
        this.controllers = new ArrayList<AbstractPageController>();

        controllers.add(new MainMenuController(model, view, this));
        controllers.add(new CreateTruckController(model, view, this));
        controllers.add(new InteractionsMenuController(model, view, this));
        controllers.add(new SetBinsController(model, view, this));
        controllers.add(new SetPricesController(model, view, this));
        controllers.add(new DisplayPricesController(model, view, this));
        controllers.add(new DisplayInventoryController(model, view, this));

        this.getController("MainMenu").goTo();
    }

    public String getCurrentOperation() {
        return currentOperation;
    }

    public void setCurrentOperation(String currentOperation) {
        this.currentOperation = currentOperation;
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
