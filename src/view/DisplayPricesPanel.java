package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import model.TransactionList;

/**
 * DisplayPricesPanel
 */
public class DisplayPricesPanel extends JPanel {
    private JButton updatePricesButton;
    private JButton mainMenuButton;
    private JTable pricesTable;
    private JLabel title;
    private JScrollPane tableScrollPane;

    public DisplayPricesPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60)); // padding

        title = new JLabel("Current Truck Prices");
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        pricesTable = new JTable();
        pricesTable.setFont(new Font("Arial", Font.PLAIN, 16));
        pricesTable.setRowHeight(28);
        pricesTable.setFillsViewportHeight(true);
        pricesTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        tableScrollPane = new JScrollPane(pricesTable);
        tableScrollPane.setPreferredSize(new Dimension(500, 250));
        tableScrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainMenuButton = new JButton("Main Menu");
        updatePricesButton = new JButton("Update Truck Prices");

        mainMenuButton.setFont(new Font("Arial", Font.BOLD, 20));
        updatePricesButton.setFont(new Font("Arial", Font.BOLD, 20));

        Dimension buttonSize = new Dimension(325, 50);

        mainMenuButton.setMaximumSize(buttonSize);
        updatePricesButton.setMaximumSize(buttonSize);

        mainMenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        updatePricesButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(title);
        this.add(Box.createRigidArea(new Dimension(0, 30)));
        this.add(tableScrollPane);
        this.add(Box.createRigidArea(new Dimension(0, 30)));
        this.add(updatePricesButton);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(mainMenuButton);
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

    public void addMainMenuListener(ActionListener listener) {
        mainMenuButton.addActionListener(listener);
    }
}
