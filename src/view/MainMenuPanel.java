package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * MainMenuPanel
 */
public class MainMenuPanel extends JPanel {

    private JButton createTruckButton;
    private JButton manageTrucksButton;
    private JButton viewDashboardButton;
    private JLabel title;

    public MainMenuPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60)); // padding

        title = new JLabel("Coffee Truck Management");
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        createTruckButton = new JButton("Create Coffee Truck");
        manageTrucksButton = new JButton("Manage Existing Trucks");
        viewDashboardButton = new JButton("View Business Dashboard");

        createTruckButton.setFont(new Font("Arial", Font.BOLD, 20));
        manageTrucksButton.setFont(new Font("Arial", Font.BOLD, 20));
        viewDashboardButton.setFont(new Font("Arial", Font.BOLD, 20));

        Dimension buttonSize = new Dimension(350, 100);
        createTruckButton.setMaximumSize(buttonSize);
        manageTrucksButton.setMaximumSize(buttonSize);
        viewDashboardButton.setMaximumSize(buttonSize);

        createTruckButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        manageTrucksButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewDashboardButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(title);
        this.add(Box.createRigidArea(new Dimension(0, 30))); // spacing
        this.add(createTruckButton);
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(manageTrucksButton);
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(viewDashboardButton);
    }

    public void addCreateTruckListener(ActionListener listener) {
        createTruckButton.addActionListener(listener);
    }

    public void addManageTrucksListener(ActionListener listener) {
        manageTrucksButton.addActionListener(listener);
    }

    public void addViewDashboardListener(ActionListener listener) {
        viewDashboardButton.addActionListener(listener);
    }

}
