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
 * Represents the panel that allows users to manage various aspects of existing trucks,
 * including simulating sales, changing locations, managing inventory, and updating prices.
 * <p>
 * This panel includes:
 * <ul>
 *     <li>A combo box to select a specific truck</li>
 *     <li>Buttons for simulating operations, managing location, inventory, and prices</li>
 *     <li>A button to return to the main menu</li>
 * </ul>
 * The panel is styled with a coffee-themed color scheme and uses consistent layout
 * spacing and alignment for UI clarity.
 * </p>
 *
 * @author
 */
public class InteractionsMenuPanel extends JPanel {

    // === Color Scheme ===
    private Color pastelGrayOrange;
    private Color darkBrown;
    private Color peachyOrange;

    // === UI Components ===
    private JButton mainMenuButton;
    private JButton simulateTruckButton;
    private JButton viewTruckButton;
    private JButton restockButton;
    private JButton viewPricesButton;
    private JButton changeLocationButton;
    private JLabel title;
    private JComboBox<String> truckListComboBox;
    private String[] truckList = { "" }; // default/test data

    /**
     * Constructs an InteractionsMenuPanel and initializes the layout,
     * color palette, and interactive UI components.
     */
    public InteractionsMenuPanel() {
        // Initialize colors
        pastelGrayOrange = new Color(216, 175, 157);
        darkBrown = new Color(96, 63, 38);
        peachyOrange = new Color(255, 243, 224);
        Dimension buttonSize = new Dimension(325, 50);

        // Layout and padding
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));
        this.setOpaque(false);

        // Title label
        title = new JLabel("Manage Existing Trucks");
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Main Menu Button
        mainMenuButton = new JButton("Main Menu");
        mainMenuButton.setFont(new Font("Arial", Font.BOLD, 20));
        mainMenuButton.setForeground(darkBrown);
        mainMenuButton.setBackground(pastelGrayOrange);
        mainMenuButton.setMaximumSize(buttonSize);
        mainMenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Simulate Truck Button
        simulateTruckButton = new JButton("Simulate Truck");
        simulateTruckButton.setFont(new Font("Arial", Font.BOLD, 20));
        simulateTruckButton.setForeground(darkBrown);
        simulateTruckButton.setBackground(pastelGrayOrange);
        simulateTruckButton.setMaximumSize(buttonSize);
        simulateTruckButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Change Location Button
        changeLocationButton = new JButton("Change Truck Location");
        changeLocationButton.setFont(new Font("Arial", Font.BOLD, 20));
        changeLocationButton.setForeground(darkBrown);
        changeLocationButton.setBackground(pastelGrayOrange);
        changeLocationButton.setMaximumSize(buttonSize);
        changeLocationButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Manage Inventory Button
        restockButton = new JButton("Manage Inventory");
        restockButton.setFont(new Font("Arial", Font.BOLD, 20));
        restockButton.setForeground(darkBrown);
        restockButton.setBackground(pastelGrayOrange);
        restockButton.setMaximumSize(buttonSize);
        restockButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Manage Prices Button
        viewPricesButton = new JButton("Manage Prices");
        viewPricesButton.setFont(new Font("Arial", Font.BOLD, 20));
        viewPricesButton.setForeground(darkBrown);
        viewPricesButton.setBackground(pastelGrayOrange);
        viewPricesButton.setMaximumSize(buttonSize);
        viewPricesButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Truck ComboBox
        truckListComboBox = new JComboBox<>(truckList);
        truckListComboBox.setFont(new Font("Arial", Font.BOLD, 20));
        truckListComboBox.setForeground(darkBrown);
        truckListComboBox.setBackground(pastelGrayOrange);
        truckListComboBox.setMaximumSize(new Dimension(250, 50));

        // Add all components to panel with spacing
        this.add(title);
        this.add(Box.createRigidArea(new Dimension(0, 30)));
        this.add(truckListComboBox);
        this.add(Box.createRigidArea(new Dimension(0, 30)));
        this.add(simulateTruckButton);
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(changeLocationButton);
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(restockButton);
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(viewPricesButton);
        this.add(Box.createRigidArea(new Dimension(0, 50)));
        this.add(mainMenuButton);
    }

    /**
     * Updates the combo box with the provided list of truck names.
     *
     * @param truckList an array of truck identifiers to populate the combo box
     */
    public void addTruckList(String[] truckList) {
        truckListComboBox.removeAllItems();
        for (String truck : truckList) {
            truckListComboBox.addItem(truck);
        }
    }

    /**
     * Returns the currently selected truck identifier from the combo box.
     *
     * @return the selected truck as a String
     */
    public String getSelectedString() {
        return (String) truckListComboBox.getSelectedItem();
    }

    /**
     * Adds an ActionListener to the combo box that triggers when a truck is selected.
     *
     * @param listener the ActionListener for the combo box
     */
    public void addComboBoxListener(ActionListener listener) {
        truckListComboBox.addActionListener(listener);
    }

    /**
     * Adds an ActionListener to the "Simulate Truck" button.
     *
     * @param listener the ActionListener for simulating a truck
     */
    public void addSimulateTruckListener(ActionListener listener) {
        simulateTruckButton.addActionListener(listener);
    }

    /**
     * Adds an ActionListener to the "Manage Inventory" button.
     *
     * @param listener the ActionListener for managing inventory
     */
    public void addViewInventoryListener(ActionListener listener) {
        restockButton.addActionListener(listener);
    }

    /**
     * Adds an ActionListener to the "Manage Prices" button.
     *
     * @param listener the ActionListener for managing prices
     */
    public void addViewPricesListener(ActionListener listener) {
        viewPricesButton.addActionListener(listener);
    }

    /**
     * Adds an ActionListener to the "Change Truck Location" button.
     *
     * @param listener the ActionListener for changing location
     */
    public void addChangeLocationListener(ActionListener listener) {
        changeLocationButton.addActionListener(listener);
    }

    /**
     * Adds an ActionListener to the "Main Menu" button for navigation.
     *
     * @param listener the ActionListener for returning to the main menu
     */
    public void addMainMenuListener(ActionListener listener) {
        mainMenuButton.addActionListener(listener);
    }
}
