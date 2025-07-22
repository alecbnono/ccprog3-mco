package controller;

import view.InteractionsMenuPanel;
import view.RootView;

/**
 * InteractionsMenuController
 */
public class InteractionsMenuController extends AbstractPageController implements PageControllerInterface {

    private InteractionsMenuPanel interactionsMenuPanel;

    public InteractionsMenuController(RootView view, MasterController controller) {
        super(view, controller);

        interactionsMenuPanel = new InteractionsMenuPanel();
    }

    public void goTo() {
        view.getFrame().setPage(interactionsMenuPanel);
    }
}
