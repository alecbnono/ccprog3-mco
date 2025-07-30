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
 * Represents the panel that displays and manages the current prices of the coffee truck items.
 * <p>
 * This panel includes:
 * <ul>
 *     <li>A title label indicating the purpose of the panel</li>
 *     <li>A table for displaying price data</li>
 *     <li>A button to update the prices</li>
 *     <li>A button to navigate back to the previous menu</li>
 * </ul>
 * The design uses a coffee-themed color palette for a consistent aesthetic.
 * </p>
 *
 * @author
 */
public class DisplayPricesPanel extends JPanel {

    // === Color Scheme ===
    private Color grayRed;
    private Color pastelGrayOrange;
    private Color darkBrown;
    private Color peachyOrange;
    private Color gray;

    // === UI Components ===
    private JButton updatePricesButton;
    private JButton interactionsMenuButton;
    private JTable pricesTable;
    private JLabel title;
    private JScrollPane tableScrollPane;

    /**
     * Constructs a DisplayPricesPanel and sets up its layout, color scheme,
     * and UI components such as the title, table, and buttons.
     */
    public DisplayPricesPanel() {
        // Initialize colors
        grayRed = new Color(194, 133, 131);
        pastelGrayOrange = new Color(216, 175, 157);
        darkBrown = new Color(96, 63, 38);
        peachyOrange = new Color(255, 243, 224);
        gray = new Color(115, 115, 115);
        Dimension buttonSize = new Dimension(325, 50);

        // Layout setup
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));
        this.setOpaque(false);

        // Title label
        title = new JLabel("Current Truck Prices");
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setForeground(grayRed);

        // Table setup
        pricesTable = new JTable();
        JTableHeader header = pricesTable.getTableHeader();
        pricesTable.setFont(new Font("Arial", Font.PLAIN, 16));
        pricesTable.setRowHeight(28);
        pricesTable.setFillsViewportHeight(true);
        pricesTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        pricesTable.setForeground(darkBrown);
        pricesTable.setBackground(peachyOrange);
        pricesTable.setGridColor(gray);
        header.setBackground(peachyOrange);
        header.setForeground(darkBrown);
        header.setBorder(BorderFactory.createLineBorder(gray));

        tableScrollPane = new JScrollPane(pricesTable);
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

        updatePricesButton = new JButton("Update Truck Prices");
        updatePricesButton.setFont(new Font("Arial", Font.BOLD, 20));
        updatePricesButton.setForeground(darkBrown);
        updatePricesButton.setBackground(pastelGrayOrange);
        updatePricesButton.setMaximumSize(buttonSize);
        updatePricesButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add components to the panel
        this.add(title);
        this.add(Box.createRigidArea(new Dimension(0, 30)));
        this.add(tableScrollPane);
        this.add(Box.createRigidArea(new Dimension(0, 30)));
        this.add(updatePricesButton);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(interactionsMenuButton);
    }

    /**
     * Sets the data model of the prices table.
     *
     * @param tableModel the TableModel containing truck price data
     */
    public void addPriceTable(TableModel tableModel) {
        pricesTable.setModel(tableModel);
        pricesTable.revalidate();
        pricesTable.repaint();
        this.revalidate();
        this.repaint();
    }

    /**
     * Attaches an ActionListener to the "Update Truck Prices" button.
     *
     * @param listener the ActionListener triggered when the button is clicked
     */
    public void addUpdatePricesListener(ActionListener listener) {
        updatePricesButton.addActionListener(listener);
    }

    /**
     * Attaches an ActionListener to the "Back" button for navigation.
     *
     * @param listener the ActionListener triggered when the button is clicked
     */
    public void addInteractionsMenuListener(ActionListener listener) {
        interactionsMenuButton.addActionListener(listener);
    }
}
