package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.Color;

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
    private JButton viewPricesButton;
    private JButton changeLocationButton;
    private JLabel title;
    private String[] truckList = { "" }; // test data
    private JComboBox<String> truckListComboBox;
    private Color peachyOrange;

    public InteractionsMenuPanel() {
        grayRed = new Color(194, 133, 131);
        lightRed = new Color(248, 218, 217);
        pastelGrayOrange = new Color(216, 175, 157);
        brown = new Color(108, 78, 49);
        darkBrown = new Color(96, 63, 38);
        peachyOrange = new Color(255, 243, 224);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60)); // padding
        this.setOpaque(false);

        title = new JLabel("Manage Existing Trucks");
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setForeground(grayRed);

        mainMenuButton = new JButton("Main Menu");
        simulateTruckButton = new JButton("Simulate Truck");
        changeLocationButton = new JButton("Change Truck Location");
        viewTruckButton = new JButton("View Truck Information");
        restockButton = new JButton("Manage Inventory");
        viewPricesButton = new JButton("Manage Prices");

        truckListComboBox = new JComboBox<>(truckList);
        truckListComboBox.setForeground(darkBrown);
        truckListComboBox.setBackground(peachyOrange);

        mainMenuButton.setFont(new Font("Arial", Font.BOLD, 20));
        mainMenuButton.setForeground(darkBrown);
        mainMenuButton.setBackground(pastelGrayOrange);

        simulateTruckButton.setFont(new Font("Arial", Font.BOLD, 20));
        simulateTruckButton.setForeground(darkBrown);
        simulateTruckButton.setBackground(pastelGrayOrange);

        viewTruckButton.setFont(new Font("Arial", Font.BOLD, 20));
        viewTruckButton.setForeground(darkBrown);
        viewTruckButton.setBackground(pastelGrayOrange);

        restockButton.setFont(new Font("Arial", Font.BOLD, 20));
        restockButton.setForeground(darkBrown);
        restockButton.setBackground(pastelGrayOrange);

        viewPricesButton.setFont(new Font("Arial", Font.BOLD, 20));
        viewPricesButton.setForeground(darkBrown);
        viewPricesButton.setBackground(pastelGrayOrange);

        changeLocationButton.setFont(new Font("Arial", Font.BOLD, 20));
        changeLocationButton.setForeground(darkBrown);
        changeLocationButton.setBackground(pastelGrayOrange);

        truckListComboBox.setFont(new Font("Arial", Font.BOLD, 20));
        truckListComboBox.setForeground(darkBrown);
        truckListComboBox.setBackground(pastelGrayOrange);

        Dimension buttonSize = new Dimension(325, 50);

        truckListComboBox.setMaximumSize(new Dimension(250, 50));

        mainMenuButton.setMaximumSize(buttonSize);
        simulateTruckButton.setMaximumSize(buttonSize);
        viewTruckButton.setMaximumSize(buttonSize);
        restockButton.setMaximumSize(buttonSize);
        viewPricesButton.setMaximumSize(buttonSize);
        changeLocationButton.setMaximumSize(buttonSize);

        mainMenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        simulateTruckButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewTruckButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        restockButton.setAlignmentX(Component.CENTER_ALIGNMENT);
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
        this.add(changeLocationButton);
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(restockButton);
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(viewPricesButton);
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

    public void addViewInventoryListener(ActionListener listener) {
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
