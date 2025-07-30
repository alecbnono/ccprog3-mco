package view;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
/**
 * Represents the panel that displays the current inventory of a coffee truck.
 * <p>
 * This panel features:
 * <ul>
 *     <li>A title label</li>
 *     <li>A table for displaying inventory data</li>
 *     <li>Buttons for updating inventory and navigating back</li>
 * </ul>
 * Designed with a custom coffee-themed color scheme and layout.
 * </p>
 *
 * @author
 */
public class DisplayInventoryPanel extends JPanel {

    // === Color Theme ===
    private Color grayRed;
    private Color pastelGrayOrange;
    private Color darkBrown;
    private Color peachyOrange;
    private Color gray;

    // === UI Components ===
    private JButton updateInventoryButton;
    private JButton restockInventoryButton;  // (Declared but unused in constructor)
    private JButton interactionsMenuButton;
    private JTable inventoryTable;
    private JLabel title;
    private JScrollPane tableScrollPane;

    /**
     * Constructs a DisplayInventoryPanel with initialized components and layout.
     * <p>
     * The panel includes a styled table for inventory, a title,
     * and buttons for updating inventory and navigating back to the previous menu.
     * </p>
     */
    public DisplayInventoryPanel() {
        // Initialize colors
        grayRed = new Color(194, 133, 131);
        pastelGrayOrange = new Color(216, 175, 157);
        darkBrown = new Color(96, 63, 38);
        peachyOrange = new Color(255, 243, 224);
        gray = new Color(115, 115, 115);
        Dimension buttonSize = new Dimension(325, 50);

        // Panel layout setup
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));
        this.setOpaque(false);

        // Title label
        title = new JLabel("Current Truck Inventory");
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setForeground(grayRed);

        // Inventory table setup
        inventoryTable = new JTable();
        JTableHeader header = inventoryTable.getTableHeader();
        inventoryTable.setFont(new Font("Arial", Font.PLAIN, 16));
        inventoryTable.setRowHeight(28);
        inventoryTable.setFillsViewportHeight(true);
        inventoryTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        inventoryTable.setForeground(darkBrown);
        inventoryTable.setBackground(peachyOrange);
        inventoryTable.setGridColor(gray);
        header.setBackground(peachyOrange);
        header.setForeground(darkBrown);
        header.setBorder(BorderFactory.createLineBorder(gray));

        tableScrollPane = new JScrollPane(inventoryTable);
        tableScrollPane.setPreferredSize(new Dimension(500, 250));
        tableScrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
        tableScrollPane.setBackground(peachyOrange);

        // Buttons
        interactionsMenuButton = new JButton("Back");
        interactionsMenuButton.setFont(new Font("Arial", Font.BOLD, 20));
        interactionsMenuButton.setForeground(darkBrown);
        interactionsMenuButton.setBackground(pastelGrayOrange);
        interactionsMenuButton.setMaximumSize(buttonSize);
        interactionsMenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        updateInventoryButton = new JButton("Update Inventory");
        updateInventoryButton.setFont(new Font("Arial", Font.BOLD, 20));
        updateInventoryButton.setForeground(darkBrown);
        updateInventoryButton.setBackground(pastelGrayOrange);
        updateInventoryButton.setMaximumSize(buttonSize);
        updateInventoryButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add components to panel
        this.add(title);
        this.add(Box.createRigidArea(new Dimension(0, 30)));
        this.add(tableScrollPane);
        this.add(Box.createRigidArea(new Dimension(0, 30)));
        this.add(updateInventoryButton);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(interactionsMenuButton);
    }

    /**
     * Sets the data model of the inventory table.
     *
     * @param tableModel the TableModel containing inventory data
     */
    public void addInventoryTable(TableModel tableModel) {
        inventoryTable.setModel(tableModel);
        inventoryTable.revalidate();
        inventoryTable.repaint();
        this.revalidate();
        this.repaint();
    }

    /**
     * Attaches an ActionListener to the "Update Inventory" button.
     *
     * @param listener the ActionListener triggered when the button is clicked
     */
    public void addUpdateInventoryListener(ActionListener listener) {
        updateInventoryButton.addActionListener(listener);
    }

    /**
     * Attaches an ActionListener to the "Back" button to return to the previous menu.
     *
     * @param listener the ActionListener triggered when the button is clicked
     */
    public void addInteractionsMenuListener(ActionListener listener) {
        interactionsMenuButton.addActionListener(listener);
    }
}
