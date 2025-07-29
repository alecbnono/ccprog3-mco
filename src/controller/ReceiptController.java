package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.CoffeeBusiness;

import view.ReceiptPanel;
import view.RootView;

/**
 * ReceiptController
 */
public class ReceiptController extends AbstractPageController {

    private ReceiptPanel receiptPanel;

    public ReceiptController(CoffeeBusiness model, RootView view, MasterController controller) {
        super(model, view, controller);
        receiptPanel = new ReceiptPanel();

        ActionListener navigateInteractionsMenu = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.getController("InteractionsMenu").goTo();
            }
        };

        receiptPanel.addInteractionsMenuListener(navigateInteractionsMenu);
    }

    @Override
    public String getPageName() {
        return "Receipt";
    }

    @Override
    public void goTo() {
        model.clearSelectedTruck();
        receiptPanel.setOutputString(controller.getCurrentReceipt());
        view.getFrame().setPage(receiptPanel);
    }

}
