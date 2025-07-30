package view;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 * Represents the Business Dashboard panel used in the JavaJeeps application.
 * <p>
 * Displays summarized information on:
 * <ul>
 *     <li>Trucks deployed</li>
 *     <li>Combined inventory levels</li>
 *     <li>Total sales statistics</li>
 * </ul>
 * Also includes a button to navigate back to the main menu.
 * </p>
 * <p>
 * Styled with a soft, coffee-themed palette using custom colors and fonts.
 * </p>
 *
 * @author
 */
public class DashboardPanel extends JPanel {

    // === Color Theme Variables ===
    private Color grayRed;
    private Color lightRed;
    private Color pastelGrayOrange;
    private Color brown;
    private Color darkBrown;

    // === UI Components ===
    private ImageIcon image;
    private ImageIcon asset1;

    private JButton mainMenuButton;
    private JTextArea totalSales;
    private JTextArea trucksDeployedInfo;
    private JTextArea allInventoriesInfo;
    private JLabel title;

    /**
     * The types of inventory shown in the dashboard.
     */
    private String[] inventoryTypes = {
            "Coffee Beans", "Water", "Milk", "Hazelnut", "Vanilla",
            "Chocolate", "Almond", "Sucrose", "Small Cup", "Medium Cup", "Large Cup"
    };

    /**
     * Constructs a DashboardPanel with initialized layout, styles,
     * and UI elements to display business data.
     */
    public DashboardPanel() {
        // Initialize color theme
        grayRed = new Color(194, 133, 131);
        lightRed = new Color(248, 218, 217);
        pastelGrayOrange = new Color(216, 175, 157);
        brown = new Color(108, 78, 49);
        darkBrown = new Color(96, 63, 38);

        Dimension buttonSize = new Dimension(350, 100);

        // Panel layout and padding
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));
        this.setOpaque(false);

        // Title
        title = new JLabel("Business Dashboard");
        title.setForeground(grayRed);
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Trucks deployed text area
        trucksDeployedInfo = new JTextArea();
        trucksDeployedInfo.setFont(new Font("Monospaced", Font.PLAIN, 16));
        trucksDeployedInfo.setEditable(false);
        trucksDeployedInfo.setOpaque(false);
        trucksDeployedInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        trucksDeployedInfo.setMaximumSize(new Dimension(550, 600));
        trucksDeployedInfo.setLineWrap(true);
        trucksDeployedInfo.setWrapStyleWord(true);

        // Inventory info text area
        allInventoriesInfo = new JTextArea();
        allInventoriesInfo.setFont(new Font("Monospaced", Font.PLAIN, 16));
        allInventoriesInfo.setEditable(false);
        allInventoriesInfo.setOpaque(false);
        allInventoriesInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        allInventoriesInfo.setMaximumSize(new Dimension(550, 600));
        allInventoriesInfo.setLineWrap(true);
        allInventoriesInfo.setWrapStyleWord(true);

        // Total sales text area
        totalSales = new JTextArea();
        totalSales.setFont(new Font("Monospaced", Font.PLAIN, 16));
        totalSales.setEditable(false);
        totalSales.setOpaque(false);
        totalSales.setAlignmentX(Component.CENTER_ALIGNMENT);
        totalSales.setMaximumSize(new Dimension(550, 600));
        totalSales.setLineWrap(true);
        totalSales.setWrapStyleWord(true);

        // Main menu button
        mainMenuButton = new JButton("Main Menu");
        mainMenuButton.setFont(new Font("Arial", Font.BOLD, 20));
        mainMenuButton.setForeground(darkBrown);
        mainMenuButton.setBackground(pastelGrayOrange);
        mainMenuButton.setMaximumSize(buttonSize);
        mainMenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add all components to panel
        this.add(title);
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(trucksDeployedInfo);
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(allInventoriesInfo);
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(totalSales);
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(mainMenuButton);
    }

    /**
     * Updates the truck deployment information displayed on the panel.
     *
     * @param output the formatted truck deployment details
     */
    public void setTruckInfo(String output) {
        trucksDeployedInfo.setText(output);
    }

    /**
     * Updates the inventory summary displayed on the panel.
     *
     * @param output the formatted inventory data
     */
    public void setInventoryInfo(String output) {
        allInventoriesInfo.setText(output);
    }

    /**
     * Updates the total sales information displayed on the panel.
     *
     * @param output the formatted sales summary
     */
    public void setSalesInfo(String output) {
        totalSales.setText(output);
    }

    /**
     * Adds an ActionListener to the "Main Menu" button.
     *
     * @param listener the ActionListener to be triggered on button click
     */
    public void addMainMenuListener(ActionListener listener) {
        mainMenuButton.addActionListener(listener);
    }
}
