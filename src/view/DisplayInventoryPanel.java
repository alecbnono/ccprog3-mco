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
 * DisplayInventoryPanel
 */
public class DisplayInventoryPanel extends JPanel {
    private Color grayRed;
    private Color lightRed;
    private Color pastelGrayOrange;
    private Color brown;
    private Color darkBrown;
    private Color lightGray;
    private Color peachyOrange;
    private Color gray;
    private JButton updateInventoryButton;
    private JButton restockInventoryButton;
    private JButton mainMenuButton;
    private JTable inventoryTable;
    private JLabel title;
    private JScrollPane tableScrollPane;

    public DisplayInventoryPanel() {
        grayRed = new Color(194, 133, 131);
        lightRed = new Color(248, 218, 217);
        pastelGrayOrange = new Color(216, 175, 157);
        brown = new Color(108, 78, 49);
        darkBrown = new Color(96, 63, 38);
        lightGray = new Color(217, 217, 217);
        peachyOrange = new Color(255, 243, 224);
        gray = new Color(115, 115, 115);
        Dimension buttonSize = new Dimension(325, 50);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60)); // padding
        this.setOpaque(false);

        title = new JLabel("Current Truck Inventory");
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setForeground(grayRed);

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

        mainMenuButton = new JButton("Main Menu");
        mainMenuButton.setFont(new Font("Arial", Font.BOLD, 20));
        mainMenuButton.setForeground(darkBrown);
        mainMenuButton.setBackground(pastelGrayOrange);
        mainMenuButton.setMaximumSize(buttonSize);
        mainMenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        updateInventoryButton = new JButton("Update Inventory");
        updateInventoryButton.setFont(new Font("Arial", Font.BOLD, 20));
        updateInventoryButton.setForeground(darkBrown);
        updateInventoryButton.setBackground(pastelGrayOrange);
        updateInventoryButton.setMaximumSize(buttonSize);
        updateInventoryButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        restockInventoryButton = new JButton("Restock Inventory");
        restockInventoryButton.setFont(new Font("Arial", Font.BOLD, 20));
        restockInventoryButton.setForeground(darkBrown);
        restockInventoryButton.setBackground(pastelGrayOrange);
        restockInventoryButton.setMaximumSize(buttonSize);
        restockInventoryButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(title);
        this.add(Box.createRigidArea(new Dimension(0, 30)));
        this.add(tableScrollPane);
        this.add(Box.createRigidArea(new Dimension(0, 30)));
        this.add(restockInventoryButton);
        this.add(Box.createRigidArea(new Dimension(0, 30)));
        this.add(updateInventoryButton);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(mainMenuButton);
    }

    public void addInventoryTable(TableModel tableModel) {
        inventoryTable.setModel(tableModel);
        inventoryTable.revalidate();
        inventoryTable.repaint();
        this.revalidate();
        this.repaint();
    }

    public void addUpdateInventoryListener(ActionListener listener) {
        updateInventoryButton.addActionListener(listener);
    }

    public void addRestockInventoryListener(ActionListener listener) {
        restockInventoryButton.addActionListener(listener);
    }

    public void addMainMenuListener(ActionListener listener) {
        mainMenuButton.addActionListener(listener);
    }
}
