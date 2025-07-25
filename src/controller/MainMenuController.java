package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.CoffeeBusiness;

import view.MainMenuPanel;
import view.RootView;

/**
 * MainMenuController
 */
public class MainMenuController extends AbstractPageController {

    protected MainMenuPanel mainMenuPanel;

    public MainMenuController(CoffeeBusiness model, RootView view, MasterController controller) {
        super(model, view, controller);
        mainMenuPanel = new MainMenuPanel();

        ActionListener navigateCreateTruck = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.getController("CreateTruck").goTo();
            }
        };

        ActionListener navigateInteractionsMenu = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.getController("InteractionsMenu").goTo();
            }
        };

        mainMenuPanel.addCreateTruckListener(navigateCreateTruck);
        mainMenuPanel.addManageTrucksListener(navigateInteractionsMenu);
    }

    @Override
    public String getPageName() {
        return "MainMenu";
    }

    @Override
    public void goTo() {
        view.getFrame().setPage(mainMenuPanel);
    }

}
