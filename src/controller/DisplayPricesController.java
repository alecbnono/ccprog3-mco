package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.CoffeeBusiness;
import model.PriceEntry;
import model.PriceList;
import model.TransactionList;
import view.DisplayPricesPanel;
import view.RootView;

/**
 * DisplayPricesController
 */
public class DisplayPricesController extends AbstractPageController {

    private DisplayPricesPanel displayPricesPanel;

    public DisplayPricesController(CoffeeBusiness model, RootView view, MasterController controller) {
        super(model, view, controller);
        displayPricesPanel = new DisplayPricesPanel();

        ActionListener navigateMainMenu = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.getController("MainMenu").goTo();
            }
        };

        ActionListener navigateSetPrices = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.getController("SetPrices").goTo();
            }
        };

        displayPricesPanel.addUpdatePricesListener(navigateSetPrices);

        displayPricesPanel.addMainMenuListener(navigateMainMenu);
    }

    private DefaultTableModel buildPriceTableModel(PriceList list) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Product");
        model.addColumn("Size");
        model.addColumn("Price");

        for (PriceEntry entry : list.getPriceEntries()) {
            model.addRow(
                    new Object[] { entry.getProduct(), entry.getSize(), String.format("₱%.2f", entry.getPrice()) });
        }

        return model;
    }

    @Override
    public String getPageName() {
        return "DisplayPrices";
    }

    @Override
    public void goTo() {
        displayPricesPanel.addPriceTable(buildPriceTableModel(model.getPriceList()));
        view.getFrame().setPage(displayPricesPanel);
    }

}
