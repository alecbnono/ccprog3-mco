package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainMenuPanel;
import view.RootView;

/**
 * MainMenuController
 */
public class MainMenuController extends AbstractPageController implements PageControllerInterface {

    protected MainMenuPanel mainMenuPanel;

    public MainMenuController(RootView view, MasterController controller) {
        super(view, controller);
        mainMenuPanel = new MainMenuPanel();

        ActionListener navigateCreateTruck = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.getCreateTruckController().goTo();
            }
        };

        ActionListener navigateInteractionsMenu = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.getInteractionsMenuController().goTo();
            }
        };

        mainMenuPanel.addCreateTruckListener(navigateCreateTruck);
        mainMenuPanel.addManageTrucksListener(navigateInteractionsMenu);
    }

    public void goTo() {
        view.getFrame().setPage(mainMenuPanel);
    }

}
