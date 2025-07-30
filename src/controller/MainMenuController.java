package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.CoffeeBusiness;
import view.MainMenuPanel;
import view.RootView;

/**
 * Controls the Main Menu screen of the coffee truck application.
 *
 * <p>This controller allows the user to:</p>
 * <ul>
 *     <li>Create a new coffee truck</li>
 *     <li>Manage existing trucks through the Interactions Menu</li>
 *     <li>View a business-wide dashboard</li>
 * </ul>
 *
 * <p>It handles button events on the {@link MainMenuPanel} and navigates
 * to the appropriate subpages via the {@link MasterController}.</p>
 */
public class MainMenuController extends AbstractPageController {

    /** The view panel representing the main menu. */
    private MainMenuPanel mainMenuPanel;

    /**
     * Constructs a {@code MainMenuController} that connects the model,
     * view, and master controller. Also sets up listeners for user interaction.
     *
     * @param model      the business logic layer
     * @param view       the main UI framework
     * @param controller the master navigation controller
     */
    public MainMenuController(CoffeeBusiness model, RootView view, MasterController controller) {
        super(model, view, controller);
        mainMenuPanel = new MainMenuPanel();

        // Listener to navigate to the Create Truck page
        ActionListener navigateCreateTruck = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.getController("CreateTruck").goTo();
            }
        };

        // Listener to navigate to Interactions Menu (only if at least 1 truck exists)
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

        // Listener to navigate to Dashboard page
        ActionListener navigateDashBoard = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.getController("DashBoard").goTo();
            }
        };

        // Attach all listeners to the panel's buttons
        mainMenuPanel.addCreateTruckListener(navigateCreateTruck);
        mainMenuPanel.addManageTrucksListener(navigateInteractionsMenu);
        mainMenuPanel.addViewDashboardListener(navigateDashBoard);
    }

    /**
     * Returns the name identifier of this page.
     *
     * @return the string "MainMenu"
     */
    @Override
    public String getPageName() {
        return "MainMenu";
    }

    /**
     * Displays the Main Menu screen.
     * Clears any selected truck and resets the current operation context.
     */
    @Override
    public void goTo() {
        model.clearSelectedTruck();
        controller.setCurrentOperation("");
        view.getFrame().setPage(mainMenuPanel);
    }
}
