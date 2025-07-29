package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;

import model.CoffeeBusiness;
import model.CoffeeTruck;
import model.StorageBin;
import model.Binable;
import model.PriceEntry;
import model.PriceList;
import model.SpecialCoffeeTruck;
import model.TransactionList;
import view.DisplayInventoryPanel;
import view.RootView;

/**
 * DisplayInventoryController
 */
public class DisplayInventoryController extends AbstractPageController {

    private DisplayInventoryPanel displayInventoryPanel;

    public DisplayInventoryController(CoffeeBusiness model, RootView view, MasterController controller) {
        super(model, view, controller);
        displayInventoryPanel = new DisplayInventoryPanel();

        ActionListener navigateMainMenu = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.getController("MainMenu").goTo();
            }
        };

        ActionListener navigateRestock = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.getController("Restock").goTo();
            }
        };

        ActionListener navigateUpdateInventory = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.getController("SetBins").goTo();
            }
        };

        displayInventoryPanel.addRestockInventoryListener(navigateRestock);
        displayInventoryPanel.addUpdateInventoryListener(navigateUpdateInventory);
        displayInventoryPanel.addMainMenuListener(navigateMainMenu);
    }

    private DefaultTableModel buildInventoryTableModel() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Item");
        model.addColumn("Amount");
        model.addColumn("Unit");
        ArrayList<Binable> bins = this.model.getSelectedTruck().getInventory().getInventory();

        for (Binable binable : bins) {
            model.addRow(
                    new Object[] { binable.getType(), String.format("%.2f", binable.getAmount()), binable.getUnit() });
        }

        if (this.model.getSelectedTruck().getType().equals("Special")) {
            ArrayList<Binable> specialBins = ((SpecialCoffeeTruck) this.model.getSelectedTruck()).getSpecialInventory()
                    .getInventory();

            for (Binable binable : specialBins) {
                model.addRow(
                        new Object[] { binable.getType(), binable.getAmount(), binable.getUnit() });
            }
        }

        return model;

    }

    @Override
    public String getPageName() {
        return "DisplayInventory";
    }

    @Override
    public void goTo() {
        displayInventoryPanel.addInventoryTable(buildInventoryTableModel());
        view.getFrame().setPage(displayInventoryPanel);
    }

}
