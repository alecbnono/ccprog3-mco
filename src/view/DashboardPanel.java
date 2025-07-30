package view;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * DashboardPanel
 */
public class DashboardPanel extends JPanel {

    private Color grayRed;
    private Color pastelGrayOrange;
    private Color darkBrown;
    private Color peachyOrange;
    private Color gray;
    private ImageIcon image;
    private ImageIcon asset1;
    private JButton mainMenuButton;
    private JButton transactionsButton;
    private JTextArea totalSales;
    private JTextArea trucksDeployedInfo;
    private JTextArea allInventoriesInfo;
    private String[] inventoryTypes = {
            "Coffee Beans",
            "Water",
            "Milk",
            "Hazelnut",
            "Vanilla",
            "Chocolate",
            "Almond",
            "Sucrose",
            "Small Cup",
            "Medium Cup",
            "Large Cup"
    };
    private JLabel title;

    public DashboardPanel() {
        grayRed = new Color(194, 133, 131);
        pastelGrayOrange = new Color(216, 175, 157);
        darkBrown = new Color(96, 63, 38);
        peachyOrange = new Color(255, 243, 224);
        gray = new Color(115, 115, 115);
        Dimension buttonSize = new Dimension(350, 100);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60)); // padding
        this.setOpaque(false);

        title = new JLabel("Business Dashboard");
        title.setForeground(grayRed);
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        trucksDeployedInfo = new JTextArea();
        trucksDeployedInfo.setFont(new Font("Monospaced", Font.PLAIN, 16));
        trucksDeployedInfo.setEditable(false);
        trucksDeployedInfo.setOpaque(false);
        trucksDeployedInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        trucksDeployedInfo.setMaximumSize(new Dimension(550, 600));
        trucksDeployedInfo.setLineWrap(true);
        trucksDeployedInfo.setWrapStyleWord(true);

        allInventoriesInfo = new JTextArea();
        allInventoriesInfo.setFont(new Font("Monospaced", Font.PLAIN, 16));
        allInventoriesInfo.setEditable(false);
        allInventoriesInfo.setOpaque(false);
        allInventoriesInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        allInventoriesInfo.setMaximumSize(new Dimension(550, 600));
        allInventoriesInfo.setLineWrap(true);
        allInventoriesInfo.setWrapStyleWord(true);

        totalSales = new JTextArea();
        totalSales.setFont(new Font("Monospaced", Font.PLAIN, 16));
        totalSales.setEditable(false);
        totalSales.setOpaque(false);
        totalSales.setAlignmentX(Component.CENTER_ALIGNMENT);
        totalSales.setMaximumSize(new Dimension(550, 600));
        totalSales.setLineWrap(true);
        totalSales.setWrapStyleWord(true);

        transactionsButton = new JButton("Transactions");
        transactionsButton.setFont(new Font("Arial", Font.BOLD, 20));
        transactionsButton.setForeground(darkBrown);
        transactionsButton.setBackground(pastelGrayOrange);
        transactionsButton.setMaximumSize(buttonSize);
        transactionsButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainMenuButton = new JButton("Main Menu");
        mainMenuButton.setFont(new Font("Arial", Font.BOLD, 20));
        mainMenuButton.setForeground(darkBrown);
        mainMenuButton.setBackground(pastelGrayOrange);
        mainMenuButton.setMaximumSize(buttonSize);
        mainMenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(title);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(trucksDeployedInfo);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(allInventoriesInfo);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(totalSales);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(transactionsButton);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(mainMenuButton);
    }

    public void setTruckInfo(String output) {
        trucksDeployedInfo.setText(output);
    }

    public void setInventoryInfo(String output) {
        allInventoriesInfo.setText(output);
    }

    public void setSalesInfo(String output) {
        totalSales.setText(output);
    }

    public void addTransactionsListener(ActionListener listener) {
        transactionsButton.addActionListener(listener);
    }

    public void addMainMenuListener(ActionListener listener) {
        mainMenuButton.addActionListener(listener);
    }

}
