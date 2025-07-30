package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.JTableHeader;

public class ViewTruckInfoPanel extends JPanel {
    private Color grayRed;
    private Color pastelGrayOrange;
    private Color darkBrown;
    private Color gray;
    private Color peachyOrange;
    private JButton mainMenuButton;
    private JLabel title;
    private JTable inventoryTable;
    private JTable pricesTable;
    private JScrollPane tableScrollPaneInventory;
    private JScrollPane tableScrollPanePrices;

    public ViewTruckInfoPanel() {
        grayRed = new Color(194, 133, 131);
        pastelGrayOrange = new Color(216, 175, 157);
        darkBrown = new Color(96, 63, 38);
        peachyOrange = new Color(255, 243, 224);
        gray = new Color(115, 115, 115);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60)); // padding
        this.setOpaque(false);

        title = new JLabel("Current Truck Info");
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setForeground(grayRed);

        Dimension buttonSize = new Dimension(325, 50);
        mainMenuButton = new JButton("Main Menu");
        mainMenuButton.setFont(new Font("Arial", Font.BOLD, 20));
        mainMenuButton.setForeground(darkBrown);
        mainMenuButton.setBackground(pastelGrayOrange);
        mainMenuButton.setMaximumSize(buttonSize);
        mainMenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        inventoryTable = new JTable();
        JTableHeader headerInv = inventoryTable.getTableHeader();
        inventoryTable.setFont(new Font("Arial", Font.PLAIN, 16));
        inventoryTable.setRowHeight(28);
        inventoryTable.setFillsViewportHeight(true);
        inventoryTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        inventoryTable.setForeground(darkBrown);
        inventoryTable.setBackground(peachyOrange);
        inventoryTable.setGridColor(gray);
        headerInv.setBackground(peachyOrange);
        headerInv.setForeground(darkBrown);
        headerInv.setBorder(BorderFactory.createLineBorder(gray));
        tableScrollPaneInventory = new JScrollPane(inventoryTable);
        tableScrollPaneInventory.setPreferredSize(new Dimension(500, 250));
        tableScrollPaneInventory.setAlignmentX(Component.CENTER_ALIGNMENT);
        tableScrollPaneInventory.setBackground(peachyOrange);

        pricesTable = new JTable();
        JTableHeader headerPrice = pricesTable.getTableHeader();
        pricesTable.setFont(new Font("Arial", Font.PLAIN, 16));
        pricesTable.setRowHeight(28);
        pricesTable.setFillsViewportHeight(true);
        pricesTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        pricesTable.setForeground(darkBrown);
        pricesTable.setBackground(peachyOrange);
        pricesTable.setGridColor(gray);
        headerPrice.setBackground(peachyOrange);
        headerPrice.setForeground(darkBrown);
        headerPrice.setBorder(BorderFactory.createLineBorder(gray));
        tableScrollPanePrices = new JScrollPane(pricesTable);
        tableScrollPanePrices.setPreferredSize(new Dimension(500, 250));
        tableScrollPanePrices.setAlignmentX(Component.CENTER_ALIGNMENT);
        tableScrollPanePrices.setBackground(peachyOrange);

        JPanel sideBySideTables = new JPanel();
        sideBySideTables.setLayout(new BoxLayout(sideBySideTables, BoxLayout.X_AXIS));
        sideBySideTables.setOpaque(false); // match parent
        sideBySideTables.add(tableScrollPaneInventory);
        sideBySideTables.add(Box.createRigidArea(new Dimension(30, 0))); // spacing between tables
        sideBySideTables.add(tableScrollPanePrices);

        this.add(sideBySideTables);
        this.add(Box.createRigidArea(new Dimension(0, 30)));
        this.add(mainMenuButton);
    }
}
