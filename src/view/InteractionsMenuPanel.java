package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * InteractionsMenuPanel
 */
public class InteractionsMenuPanel extends JPanel {
    private Color grayRed;
    private Color lightRed;
    private Color pastelGrayOrange;
    private Color brown;
    private Color darkBrown;
    private JButton mainMenuButton;
    private JButton simulateTruckButton;
    private JButton viewTruckButton;
    private JButton restockButton;
    private JButton changeInventoryButton;
    private JButton viewPricesButton;
    private JButton changeLocationButton;
    private JLabel title;
    private String[] truckList = { "" }; // test data
    private JComboBox<String> truckListComboBox;

    public InteractionsMenuPanel() {
        grayRed = new Color(194, 133, 131);
        lightRed = new Color(248, 218, 217);
        pastelGrayOrange = new Color(216, 175, 157);
        brown = new Color(108, 78, 49);
        darkBrown = new Color(96, 63, 38);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60)); // padding
        this.setOpaque(false);

        title = new JLabel("Manage Existing Trucks");
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainMenuButton = new JButton("Main Menu");
        simulateTruckButton = new JButton("Simulate Truck");
        viewTruckButton = new JButton("View Truck Information");
        restockButton = new JButton("Restock/Maintain Truck");
        changeInventoryButton = new JButton("Change Truck Inventory");
        viewPricesButton = new JButton("View/Update Truck Prices");
        changeLocationButton = new JButton("Change Truck Location");

        truckListComboBox = new JComboBox<>(truckList);

        mainMenuButton.setFont(new Font("Arial", Font.BOLD, 20));
        simulateTruckButton.setFont(new Font("Arial", Font.BOLD, 20));
        viewTruckButton.setFont(new Font("Arial", Font.BOLD, 20));
        changeInventoryButton.setFont(new Font("Arial", Font.BOLD, 20));
        restockButton.setFont(new Font("Arial", Font.BOLD, 20));
        viewPricesButton.setFont(new Font("Arial", Font.BOLD, 20));
        changeLocationButton.setFont(new Font("Arial", Font.BOLD, 20));
        truckListComboBox.setFont(new Font("Arial", Font.BOLD, 20));

        Dimension buttonSize = new Dimension(325, 50);

        truckListComboBox.setMaximumSize(new Dimension(250, 50));

        mainMenuButton.setMaximumSize(buttonSize);
        simulateTruckButton.setMaximumSize(buttonSize);
        viewTruckButton.setMaximumSize(buttonSize);
        restockButton.setMaximumSize(buttonSize);
        changeInventoryButton.setMaximumSize(buttonSize);
        viewPricesButton.setMaximumSize(buttonSize);
        changeLocationButton.setMaximumSize(buttonSize);

        mainMenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        simulateTruckButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewTruckButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        restockButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        changeInventoryButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewPricesButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        changeLocationButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(title);
        this.add(Box.createRigidArea(new Dimension(0, 30)));
        this.add(truckListComboBox);
        this.add(Box.createRigidArea(new Dimension(0, 30)));
        this.add(simulateTruckButton);
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(viewTruckButton);
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(restockButton);
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(changeInventoryButton);
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(viewPricesButton);
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(changeLocationButton);
        this.add(Box.createRigidArea(new Dimension(0, 50)));
        this.add(mainMenuButton);
    }

    public void addTruckList(String[] truckList) {
        truckListComboBox.removeAllItems();
        for (String truck : truckList) {
            truckListComboBox.addItem(truck);
        }
    }

    public String getSelectedString() {
        return (String) truckListComboBox.getSelectedItem();
    }

    public void addComboBoxListener(ActionListener listener) {
        truckListComboBox.addActionListener(listener);
    }

    public void addSimulateTruckListener(ActionListener listener) {
        simulateTruckButton.addActionListener(listener);
    }

    public void addViewTruckListener(ActionListener listener) {
        viewTruckButton.addActionListener(listener);
    }

    public void addRestockListener(ActionListener listener) {
        restockButton.addActionListener(listener);
    }

    public void addViewPricesListener(ActionListener listener) {
        viewPricesButton.addActionListener(listener);
    }

    public void addChangeLocationListener(ActionListener listener) {
        changeLocationButton.addActionListener(listener);
    }

    public void addMainMenuListener(ActionListener listener) {
        mainMenuButton.addActionListener(listener);
    }
}
