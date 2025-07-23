package controller;

import view.CreateTruckPanel;
import view.RootView;

/**
 * CreateTruckController
 */
public class CreateTruckController extends AbstractPageController {

    private CreateTruckPanel createTruckPanel;

    public CreateTruckController(RootView view, MasterController controller) {
        super(view, controller);
        createTruckPanel = new CreateTruckPanel();
    }

    @Override
    public String getPageName() {
        return "CreateTruck";
    }

    @Override
    public void goTo() {
        view.getFrame().setPage(createTruckPanel);
    }
}
