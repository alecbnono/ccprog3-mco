package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.CoffeeBusiness;

import view.MainMenuPanel;
import view.RootView;

/**
 * MainMenuController
 */
public class MainMenuController extends AbstractPageController {

    private MainMenuPanel mainMenuPanel;

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
                if (model.getTruckCount() != 0) {
                    controller.getController("InteractionsMenu").goTo();
                } else {
                    JOptionPane.showMessageDialog(mainMenuPanel, "No Trucks Yet! Please add trucks first",
                            "Failed", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        };

        ActionListener navigateViewDashBoard = new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (model.getTruckCount() != 0) {
                    controller.getController("ViewDashBoard").goTo();
                } else {
                    JOptionPane.showMessageDialog(mainMenuPanel, "No Trucks Yet! Please add trucks first",
                            "Failed", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        };

        mainMenuPanel.addCreateTruckListener(navigateCreateTruck);
        mainMenuPanel.addManageTrucksListener(navigateInteractionsMenu);
        mainMenuPanel.addViewDashboardListener(navigateViewDashBoard);
    }

    @Override
    public String getPageName() {
        return "MainMenu";
    }

    @Override
    public void goTo() {
        view.getFrame().setPage(mainMenuPanel);
        model.clearSelectedTruck();
    }

}
