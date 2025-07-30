package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import model.CoffeeBusiness;
import model.SpecialCoffeeTruck;
import model.StorageBin;
import view.RootView;
import view.SetBinsPanel;

/**
 * Controller for setting up the bin inventory of a coffee truck.
 *
 * <p>This controller manages the population of {@code StorageBin} objects
 * with selected items and amounts, depending on the truck type (Regular or Special).
 * After setting bins, it navigates to the next appropriate page based on the operation mode.</p>
 */
public class SetBinsController extends AbstractPageController {

    /** Number of regular inventory bins. */
    private static final int REGULAR_BINS = 8;

    /** Number of special inventory bins for special trucks. */
    private static final int SPECIAL_BINS = 2;

    /** The panel associated with this controller. */
    private SetBinsPanel setBinsPanel;

    /**
     * Constructs a {@code SetBinsController} and initializes listeners for the Set Bins panel.
     *
     * @param model      the business logic model
     * @param view       the root view (frame manager)
     * @param controller the master controller for application navigation
     */
    public SetBinsController(CoffeeBusiness model, RootView view, MasterController controller) {
        super(model, view, controller);

        setBinsPanel = new SetBinsPanel();

        // Listener for proceeding to SetPrices or DisplayInventory after setting bins
        ActionListener navigateSetPrices = new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (validateInputs(model.getSelectedTruck().getType())) {

                    StorageBin regularBin = new StorageBin(REGULAR_BINS);

                    ArrayList<JSpinner> spinners = setBinsPanel.getSpinners();
                    ArrayList<JComboBox<String>> selectors = setBinsPanel.getComboBoxes();

                    // Populate regular bin
                    for (int i = 0; i < REGULAR_BINS; i++) {
                        JSpinner spinner = spinners.get(i);
                        JComboBox<String> combo = selectors.get(i);
                        SpinnerNumberModel spinnerModel = (SpinnerNumberModel) spinner.getModel();

                        if (!combo.getSelectedItem().equals(""))
                            regularBin.setItem((String) combo.getSelectedItem(), i + 1,
                                    (Integer) spinnerModel.getValue());
                    }

                    model.getSelectedTruck().setInventory(regularBin);

                    // Handle special bins if truck is special
                    if (model.getSelectedTruck().getType().equals("Special")) {

                        StorageBin specialBin = new StorageBin(SPECIAL_BINS);

                        for (int i = REGULAR_BINS; i < REGULAR_BINS + SPECIAL_BINS; i++) {
                            JSpinner spinner = spinners.get(i);
                            JComboBox<String> combo = selectors.get(i);
                            SpinnerNumberModel spinnerModel = (SpinnerNumberModel) spinner.getModel();

                            if (!combo.getSelectedItem().equals(""))
                                specialBin.setItem((String) combo.getSelectedItem(), i - REGULAR_BINS + 1,
                                        (Integer) spinnerModel.getValue());
                        }

                        ((SpecialCoffeeTruck) model.getSelectedTruck()).setSpecialInventory(specialBin);
                    }

                    // Navigate to appropriate next screen
                    if (controller.getCurrentOperation().equals("CreateTruck")) {
                        controller.getController("SetPrices").goTo();
                    } else {
                        controller.getController("DisplayInventory").goTo();
                    }
                }
            }
        };

        setBinsPanel.addSetBinsListener(navigateSetPrices);
    }

    /**
     * Validates the bin inputs for correctness based on item types and quantity limits.
     *
     * @param truckType the type of truck (e.g., "Regular", "Special")
     * @return {@code true} if all inputs are valid; {@code false} otherwise
     */
    private boolean validateInputs(String truckType) {

        ArrayList<JSpinner> spinners = setBinsPanel.getSpinners();
        ArrayList<JComboBox<String>> selectors = setBinsPanel.getComboBoxes();

        int bins = truckType.equals("Special") ? REGULAR_BINS + SPECIAL_BINS : REGULAR_BINS;

        boolean isValid = true;

        for (int i = 0; i < bins; i++) {
            JSpinner spinner = spinners.get(i);
            JComboBox<String> comboBox = selectors.get(i);
            String selected = (String) comboBox.getSelectedItem();

            int value = (int) spinner.getValue();
            int max = getMax(selected);

            if (value > max || value < 0) {
                isValid = false;
            }
        }

        return isValid;
    }

    /**
     * Returns the maximum allowed quantity for a given item type.
     *
     * @param item the name of the item
     * @return the maximum allowable quantity
     */
    private int getMax(String item) {
        switch (item) {
            case "Small Cup":
                return 80;
            case "Medium Cup":
                return 64;
            case "Large Cup":
                return 40;
            case "Coffee Beans":
                return 1008;
            case "Milk":
            case "Water":
            case "Hazelnut":
            case "Vanilla":
            case "Chocolate":
            case "Almond":
            case "Sucrose":
                return 640;
            default:
                return 1008;
        }
    }

    /**
     * Returns the name of this controller's page.
     *
     * @return the string "SetBins"
     */
    @Override
    public String getPageName() {
        return "SetBins";
    }

    /**
     * Loads the Set Bins panel into the frame and updates its text fields.
     */
    @Override
    public void goTo() {
        view.getFrame().setPage(setBinsPanel);
        setBinsPanel.setSelectedTruckText(model.getSelectedTruck().getLocation());
        setBinsPanel.setTruckTypeText(model.getSelectedTruck().getType());
    }
}
