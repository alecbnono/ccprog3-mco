package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import model.CoffeeBusiness;

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

                ArrayList<JSpinner> spinners = setBinsPanel.getSpinners();
                ArrayList<JComboBox<String>> selectors = setBinsPanel.getComboBoxes();

                boolean isValid = true;
                for (int i = 0; i < 8; i++) {

                    JSpinner spinner = spinners.get(i);
                    JComboBox<String> combo = selectors.get(i);

                    if (combo.getSelectedIndex() == 0) {
                        isValid = false;
                    }

                    SpinnerNumberModel spinnerModel = (SpinnerNumberModel) spinner.getModel();
                    int value = (int) spinnerModel.getValue();
                    int max = ((Number) spinnerModel.getMaximum()).intValue();
                    int min = 0;

                    if (value < min) {
                        spinnerModel.setValue(min); // Clamp underflow
                    } else if (value > max) {
                        spinnerModel.setValue(max); // Clamp overflow
                    }

                    if (!combo.getSelectedItem().equals(""))
                        model.getSelectedTruck().getInventory().setItem((String) combo.getSelectedItem(), i + 1,
                                (Integer) spinnerModel.getValue());

                }

                controller.getController("SetPrices").goTo();
            }
        };

        setBinsPanel.addSetBinsListener(navigateSetPrices);
        setBinsPanel.addSetBinsListener(navigateSetPrices);
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
