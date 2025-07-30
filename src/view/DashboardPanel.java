package view;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * DashboardPanel
 */
public class DashboardPanel extends JPanel {

    private Color grayRed;
    private Color lightRed;
    private Color pastelGrayOrange;
    private Color brown;
    private Color darkBrown;
    private ImageIcon image;
    private ImageIcon asset1;
    private JButton mainMenuButton;
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
        lightRed = new Color(248, 218, 217);
        pastelGrayOrange = new Color(216, 175, 157);
        brown = new Color(108, 78, 49);
        darkBrown = new Color(96, 63, 38);
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

        mainMenuButton = new JButton("Create Coffee Truck");
        mainMenuButton.setFont(new Font("Arial", Font.BOLD, 20));
        mainMenuButton.setForeground(darkBrown);
        mainMenuButton.setBackground(pastelGrayOrange);
        mainMenuButton.setMaximumSize(buttonSize);
        mainMenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(title);
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(trucksDeployedInfo);
        this.add(Box.createRigidArea(new Dimension(0, 30))); // spacing
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

    public void addMainMenuListener(ActionListener listener) {
        mainMenuButton.addActionListener(listener);
    }

}
