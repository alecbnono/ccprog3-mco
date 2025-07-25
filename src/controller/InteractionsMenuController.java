package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.CoffeeBusiness;
import view.InteractionsMenuPanel;
import view.RootView;

/**
 * InteractionsMenuController
 */
public class InteractionsMenuController extends AbstractPageController {

    private InteractionsMenuPanel interactionsMenuPanel;

    public InteractionsMenuController(CoffeeBusiness model, RootView view, MasterController controller) {
        super(model, view, controller);

        interactionsMenuPanel = new InteractionsMenuPanel();

        ActionListener navigateMainMenu = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.getController("MainMenu").goTo();
            }
        };

        interactionsMenuPanel.addMainMenuListener(navigateMainMenu);
    }

    @Override
    public String getPageName() {
        return "InteractionsMenu";
    }

    @Override
    public void goTo() {
        view.getFrame().setPage(interactionsMenuPanel);
    }
}
