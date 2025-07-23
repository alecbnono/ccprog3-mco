package controller;

import view.RootView;

/**
 * AbstractPageController
 */
public abstract class AbstractPageController {

    protected MasterController controller;
    protected RootView view;

    public AbstractPageController(RootView view, MasterController controller) {
        this.view = view;
        this.controller = controller;
    }

    public abstract String getPageName();

    public abstract void goTo();
}
