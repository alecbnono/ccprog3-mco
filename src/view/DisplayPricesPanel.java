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
 * DisplayPricesPanel
 */
public class DisplayPricesPanel extends JPanel {
    private Color grayRed;
    private Color lightRed;
    private Color pastelGrayOrange;
    private Color brown;
    private Color darkBrown;
    private Color lightGray;
    private Color peachyOrange;
    private Color gray;
    private JButton updatePricesButton;
    private JButton interactionsMenuButton;
    private JTable pricesTable;
    private JLabel title;
    private JScrollPane tableScrollPane;

    public DisplayPricesPanel() {
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

        title = new JLabel("Current Truck Prices");
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setForeground(grayRed);

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

        this.add(title);
        this.add(Box.createRigidArea(new Dimension(0, 30)));
        this.add(tableScrollPane);
        this.add(Box.createRigidArea(new Dimension(0, 30)));
        this.add(updatePricesButton);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(interactionsMenuButton);
    }

    public void addPriceTable(TableModel tableModel) {
        pricesTable.setModel(tableModel);
        pricesTable.revalidate();
        pricesTable.repaint();
        this.revalidate();
        this.repaint();
    }

    public void addUpdatePricesListener(ActionListener listener) {
        updatePricesButton.addActionListener(listener);
    }

    public void addInteractionsMenuListener(ActionListener listener) {
        interactionsMenuButton.addActionListener(listener);
    }
}
