package controller;

import view.CreateTruckPanel;
import view.RootView;

/**
 * CreateTruckController
 */
public class CreateTruckController extends AbstractPageController implements PageControllerInterface {

    private CreateTruckPanel createTruckPanel;

    public CreateTruckController(RootView view, MasterController controller) {
        super(view, controller);
        createTruckPanel = new CreateTruckPanel();
    }

    public void goTo() {
        view.getFrame().setPage(createTruckPanel);
    }
}
