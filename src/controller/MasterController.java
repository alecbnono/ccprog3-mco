package controller;

import java.util.ArrayList;

import view.RootView;

/**
 * MasterController
 */
public class MasterController {

    private ArrayList<AbstractPageController> controllers;

    public MasterController(RootView view) {

        this.controllers = new ArrayList<AbstractPageController>();

        controllers.add(new MainMenuController(view, this));
        controllers.add(new CreateTruckController(view, this));
        controllers.add(new InteractionsMenuController(view, this));

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
