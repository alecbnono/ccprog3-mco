package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import model.CoffeeBusiness;
import model.SpecialCoffeeTruck;
import view.RootView;
import view.SetBinsPanel;

/**
 * SetBinsController
 */
public class SetBinsController extends AbstractPageController {

    private SetBinsPanel setBinsPanel;

    public SetBinsController(CoffeeBusiness model, RootView view, MasterController controller) {
        super(model, view, controller);

        setBinsPanel = new SetBinsPanel();

        ActionListener navigateSetPrices = new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (validateInputs(model.getSelectedTruck().getType()) == true) {
                    ArrayList<JSpinner> spinners = setBinsPanel.getSpinners();
                    ArrayList<JComboBox<String>> selectors = setBinsPanel.getComboBoxes();

                    for (int i = 0; i < 8; i++) {

                        JSpinner spinner = spinners.get(i);
                        JComboBox<String> combo = selectors.get(i);
                        SpinnerNumberModel spinnerModel = (SpinnerNumberModel) spinner.getModel();

                        if (!combo.getSelectedItem().equals(""))
                            model.getSelectedTruck().getInventory().setItem((String) combo.getSelectedItem(), i + 1,
                                    (Integer) spinnerModel.getValue());
                    }

                    if (model.getSelectedTruck().getType().equals("Special")) {

                        for (int i = 8; i < 10; i++) {

                            JSpinner spinner = spinners.get(i);
                            JComboBox<String> combo = selectors.get(i);
                            SpinnerNumberModel spinnerModel = (SpinnerNumberModel) spinner.getModel();

                            if (!combo.getSelectedItem().equals(""))
                                ((SpecialCoffeeTruck) model.getSelectedTruck()).getSpecialBin().setItem(
                                        (String) combo.getSelectedItem(), i + 1,
                                        (Integer) spinnerModel.getValue());
                        }
                    }

                    controller.getController("SetPrices").goTo();
                } else {

                }
            }
        };

        setBinsPanel.addSetBinsListener(navigateSetPrices);
        setBinsPanel.addSetBinsListener(navigateSetPrices);
    }

    private boolean validateInputs(String truckType) {

        ArrayList<JSpinner> spinners = setBinsPanel.getSpinners();
        ArrayList<JComboBox<String>> selectors = setBinsPanel.getComboBoxes();

        int bins;

        if (truckType.equals("Special")) {
            bins = 10;
        } else {
            bins = 8;
        }

        boolean isValid = true;

        for (int i = 0; i < bins; i++) {
            JSpinner spinner = spinners.get(i);
            JComboBox<String> comboBox = selectors.get(i);
            String selected = (String) comboBox.getSelectedItem();

            int value = (int) spinner.getValue();
            int max = getMax(selected);

            if (value > max) {
                isValid = false;
            } else if (value < 0) {
                isValid = false;
            }
        }

        return isValid;

    }

    private int getMax(String item) {

        int max;
        switch (item) {
            case "Small Cup":
                max = 80;
                break;
            case "Medium Cup":
                max = 64;
                break;
            case "Large Cup":
                max = 40;
                break;
            case "Coffee Beans":
                max = 1008;
                break;
            case "Milk":
            case "Water":
            case "Hazelnut":
            case "Vanilla":
            case "Chocolate":
            case "Almond":
            case "Sucrose":
                max = 640;
                break;
            default:
                max = 1008;
                break;
        }
        return max;
    }

    @Override
    public String getPageName() {
        return "SetBins";
    }

    @Override
    public void goTo() {
        view.getFrame().setPage(setBinsPanel);
        setBinsPanel.setSelectedTruckText(model.getSelectedTruck().getLocation());
        setBinsPanel.setTruckTypeText(model.getSelectedTruck().getType());
    }
}
