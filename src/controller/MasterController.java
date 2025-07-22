package controller;

import view.RootView;

/**
 * MasterController
 */
public class MasterController {

    private CreateTruckController createTruckController;
    private MainMenuController mainMenuController;
    private InteractionsMenuController interactionsMenuController;

    public MasterController(RootView view) {

        mainMenuController = new MainMenuController(view, this);
        createTruckController = new CreateTruckController(view, this);
        interactionsMenuController = new InteractionsMenuController(view, this);

        mainMenuController.goTo();

    }

    public MainMenuController getMainMenuController() {
        return mainMenuController;
    }

    public CreateTruckController getCreateTruckController() {
        return createTruckController;
    }

    public InteractionsMenuController getInteractionsMenuController() {
        return interactionsMenuController;
    }

}
