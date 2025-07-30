package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.CoffeeBusiness;
import model.CoffeeTruck;
import model.Receipt;
import model.SpecialCoffeeTruck;
import view.SimulateTruckPanel;
import view.RootView;

/**
 * SimulateTruckController
 */
public class SimulateTruckController extends AbstractPageController {

    private SimulateTruckPanel simulateTruckPanel;
    /**
     * Constructs a new SimulateTruckController.
     *
     * @param model       The CoffeeBusiness model containing the selected truck and inventory.
     * @param view        The RootView used for GUI navigation and updates.
     * @param controller  The MasterController responsible for application-wide control.
     *
     * Initializes the SimulateTruckPanel and registers action listeners
     * for user interactions, including submitting an order and returning to the interactions menu.
     */
    public SimulateTruckController(CoffeeBusiness model, RootView view, MasterController controller) {
        super(model, view, controller);

        simulateTruckPanel = new SimulateTruckPanel();

        ActionListener submitButton = new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String drink = simulateTruckPanel.getDrinkName();
                String size = simulateTruckPanel.getCupName();
                StringBuilder outputBuilder = new StringBuilder();
                Receipt receipt;

                boolean isValid = true;

                if (model.getSelectedTruck().getType().equalsIgnoreCase("Regular")) {

                    CoffeeTruck currentTruck = model.getSelectedTruck();
                    receipt = currentTruck.serveCoffee(drink, size, "Standard");

                    if (receipt == null) {
                        JOptionPane.showMessageDialog(simulateTruckPanel,
                                "Failed to prepare drink. Please check inventory.",
                                "Failed", JOptionPane.INFORMATION_MESSAGE);
                        isValid = false;
                    } else {
                        outputBuilder.append(String.format("%s\n", receipt.toString()));
                    }
                }

                else if (model.getSelectedTruck().getType().equalsIgnoreCase("Special")) {

                    SpecialCoffeeTruck currentTruck = (SpecialCoffeeTruck) model.getSelectedTruck();

                    String baseShot = simulateTruckPanel.getBaseShot();
                    int baseRatio = simulateTruckPanel.getBaseRatio();

                    String addOnSyrup = simulateTruckPanel.getAddOn();

                    String addOnShot = simulateTruckPanel.getAddOnShot();
                    int addOnRatio = simulateTruckPanel.getAddOnRatio();

                    // base coffee
                    if (baseShot.equals("Custom")) {
                        receipt = currentTruck.serveCoffee(drink, size, baseRatio);
                    } else {
                        receipt = currentTruck.serveCoffee(drink, size, baseShot);
                    }

                    if (receipt == null) {
                        JOptionPane.showMessageDialog(simulateTruckPanel,
                                "Failed to prepare base coffee. Please check inventory.",
                                "Failed", JOptionPane.INFORMATION_MESSAGE);

                        isValid = false;
                    } else {
                        outputBuilder.append(String.format("%s\n", receipt.toString()));
                    }

                    // add-on syrup
                    if (!addOnSyrup.isEmpty() && isValid) {
                        receipt = currentTruck.applyAddOn(addOnSyrup);
                        if (receipt == null) {

                            JOptionPane.showMessageDialog(simulateTruckPanel,
                                    "Failed to apply syrup add-on. Please check inventory.",
                                    "Failed", JOptionPane.INFORMATION_MESSAGE);
                            isValid = false;
                        } else {
                            outputBuilder.append(String.format("- Add-On: -\n", receipt.toString()));
                            outputBuilder.append(String.format("%s\n", receipt.toString()));
                        }
                    }

                    // add-on espresso shot
                    if (!addOnShot.isEmpty() && isValid) {
                        if (!addOnShot.equals("Custom")) {
                            receipt = currentTruck.applyExtraShot(addOnShot);
                        } else {
                            receipt = currentTruck.applyExtraShot(addOnRatio);
                        }

                        if (receipt == null) {

                            JOptionPane.showMessageDialog(simulateTruckPanel,
                                    "Failed to apply extra shot. Please check inventory.",
                                    "Failed", JOptionPane.INFORMATION_MESSAGE);
                            isValid = false;
                        } else {
                            outputBuilder.append(String.format("- Add-On: -\n", receipt.toString()));
                            outputBuilder.append(String.format("%s\n", receipt.toString()));
                        }
                    }

                }

                if (isValid) {
                    controller.setCurrentReceipt(outputBuilder.toString());
                    controller.getController("Receipt").goTo();
                }

            }
        };

        ActionListener navigateInteractionsMenu = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.getController("InteractionsMenu").goTo();
            }
        };

        simulateTruckPanel.addSubmitButtonListener(submitButton);
        simulateTruckPanel.addInteractionsMenuListener(navigateInteractionsMenu);
    }
    /**
     * Returns the name identifier for this page/controller.
     *
     * @return "SimulateTruck" — the page name string used for controller routing.
     */
    @Override
    public String getPageName() {
        return "SimulateTruck";
    }
    /**
     * Sets up and displays the simulation panel.
     * <p>
     * The panel layout is updated based on the selected truck's type
     * (either "Regular" or "Special"), enabling or disabling features accordingly.
     * </p>
     */
    @Override
    public void goTo() {
        simulateTruckPanel.setMenu(model.getSelectedTruck().getType());
        view.getFrame().setPage(simulateTruckPanel);
    }
}
