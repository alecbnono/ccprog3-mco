package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.CoffeeBusiness;

import view.TransactionListPanel;
import view.RootView;

/**
 * TransactionListController
 */
public class TransactionListController extends AbstractPageController {

    private TransactionListPanel transactionListPanel;

    public TransactionListController(CoffeeBusiness model, RootView view, MasterController controller) {
        super(model, view, controller);
        transactionListPanel = new TransactionListPanel();

        ActionListener navigateDashBoard = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.getController("DashBoard").goTo();
            }
        };

        ActionListener navigateMainMenu = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.getController("MainMenu").goTo();
            }
        };

        transactionListPanel.addDashboardListener(navigateDashBoard);
        transactionListPanel.addMainMenuListener(navigateMainMenu);
    }

    @Override
    public String getPageName() {
        return "TransactionList";
    }

    @Override
    public void goTo() {
        controller.setCurrentOperation("");
        transactionListPanel.addTransactionsTable(model.getTransactionList().buildAllTransactionsTableModel());
        view.getFrame().setPage(transactionListPanel);
    }

}
