package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.*;
import view.DashboardPanel;
import view.RootView;

/**
 * DashboardController
 */
public class DashboardController extends AbstractPageController {

    private DashboardPanel dashboardPanel;
    private Binable[] regularInventoryTypes = {
            new CoffeeBeans(0),
            new Water(0),
            new Milk(0),
            new SmallCup(0),
            new MediumCup(0),
            new LargeCup(0)
    };

    private Binable[] specialInventoryTypes = {
            new HazelnutSyrup(0),
            new VanillaSyrup(0),
            new ChocolateSyrup(0),
            new AlmondSyrup(0),
            new SucroseSyrup(0)
    };

    public DashboardController(CoffeeBusiness model, RootView view, MasterController controller) {
        super(model, view, controller);
        dashboardPanel = new DashboardPanel();

        int specialCount = model.getSpecificTruckCount("Special");
        int regularCount = model.getSpecificTruckCount("Regular");

        StringBuilder truckOutput = new StringBuilder();
        truckOutput.append(String.format("Trucks Deployed Total:  %d\n", regularCount + specialCount));
        truckOutput.append(String.format("- Regular Trucks:  %d\n", regularCount));
        truckOutput.append(String.format("- Special Trucks:  %d\n", specialCount));

        dashboardPanel.setTruckInfo(truckOutput.toString());

        ArrayList<CoffeeTruck> trucks = model.getTrucks();

        StringBuilder inventoryOutput = new StringBuilder();

        inventoryOutput.append(String.format("Inventory Overview (All Trucks):\n"));

        for (Binable item : regularInventoryTypes) {
            double total = 0;

            for (CoffeeTruck truck : trucks) {
                total += truck.getInventory().getTotalAmount(item.getType());
            }

            if (item instanceof CoffeeCup) {
                inventoryOutput.append(String.format("- %-20s %7.0f %s\n", item.getType(), total, item.getUnit()));
            } else {
                inventoryOutput.append(String.format("- %-20s %7.2f %s\n", item.getType(), total, item.getUnit()));
            }
        }

        for (Binable item : specialInventoryTypes) {
            double total = 0;

            for (CoffeeTruck truck : trucks) {
                if (truck instanceof SpecialCoffeeTruck) {
                    total += ((SpecialCoffeeTruck) truck).getSpecialInventory().getTotalAmount(item.getType());
                }
            }

            inventoryOutput.append(String.format("- %-20s %7.2f %s\n", item.getType(), total, item.getUnit()));
        }

        dashboardPanel.setInventoryInfo(inventoryOutput.toString());

        dashboardPanel.setSalesInfo(model.getTransactionList().getAggregateSales());

        ActionListener navigateMainMenu = new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                controller.getController("MainMenu").goTo();

            }
        };

        ActionListener navigateTransactions = new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                controller.getController("TransactionList").goTo();

            }
        };
        dashboardPanel.addTransactionsListener(navigateTransactions);
        dashboardPanel.addMainMenuListener(navigateMainMenu);
    }

    @Override
    public String getPageName() {
        return "Dashboard";
    }

    @Override
    public void goTo() {
        controller.setCurrentOperation("ViewDashboard");
        view.getFrame().setPage(dashboardPanel);
    }

}
