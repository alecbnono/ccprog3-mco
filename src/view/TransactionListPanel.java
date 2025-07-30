package view;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

/**
 * TransactionListPanel
 */
public class TransactionListPanel extends JPanel {

    private Color grayRed;
    private Color pastelGrayOrange;
    private Color darkBrown;
    private Color peachyOrange;
    private Color gray;
    private JButton backButton;
    private JButton mainMenuButton;
    private JTable transactionsTable;
    private JScrollPane tableScrollPane;
    private JLabel title;

    public TransactionListPanel() {
        grayRed = new Color(194, 133, 131);
        pastelGrayOrange = new Color(216, 175, 157);
        darkBrown = new Color(96, 63, 38);
        peachyOrange = new Color(255, 243, 224);
        gray = new Color(115, 115, 115);
        Dimension buttonSize = new Dimension(350, 100);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60)); // padding
        this.setOpaque(false);

        title = new JLabel("Coffee Truck Management");
        title.setForeground(grayRed);
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        transactionsTable = new JTable();
        JTableHeader header = transactionsTable.getTableHeader();
        transactionsTable.setFont(new Font("Arial", Font.PLAIN, 16));
        transactionsTable.setRowHeight(28);
        transactionsTable.setFillsViewportHeight(true);
        transactionsTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        transactionsTable.setForeground(darkBrown);
        transactionsTable.setBackground(peachyOrange);
        transactionsTable.setGridColor(gray);
        header.setBackground(peachyOrange);
        header.setForeground(darkBrown);
        header.setBorder(BorderFactory.createLineBorder(gray));
        tableScrollPane = new JScrollPane(transactionsTable);
        tableScrollPane.setPreferredSize(new Dimension(500, 250));
        tableScrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
        tableScrollPane.setBackground(peachyOrange);

        mainMenuButton = new JButton("Main Menu");
        mainMenuButton.setFont(new Font("Arial", Font.BOLD, 20));
        mainMenuButton.setForeground(darkBrown);
        mainMenuButton.setBackground(pastelGrayOrange);
        mainMenuButton.setMaximumSize(buttonSize);
        mainMenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        backButton = new JButton("Dashboard");
        backButton.setFont(new Font("Arial", Font.BOLD, 20));
        backButton.setForeground(darkBrown);
        backButton.setBackground(pastelGrayOrange);
        backButton.setMaximumSize(buttonSize);
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(title);
        this.add(Box.createRigidArea(new Dimension(0, 30))); // spacing
        this.add(tableScrollPane);
        this.add(Box.createRigidArea(new Dimension(0, 30)));
        this.add(backButton);
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(mainMenuButton);
    }

    public void addTransactionsTable(TableModel tableModel) {
        transactionsTable.setModel(tableModel);
        transactionsTable.revalidate();
        transactionsTable.repaint();
        this.revalidate();
        this.repaint();
    }

    public void addDashboardListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }

    public void addMainMenuListener(ActionListener listener) {
        mainMenuButton.addActionListener(listener);
    }

}
