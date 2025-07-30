package view;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * The {@code MainMenuPanel} class represents the main menu view of the Coffee Truck Management system.
 * It provides buttons to navigate to other parts of the application such as creating a truck,
 * managing trucks, and viewing the dashboard.
 */
public class MainMenuPanel extends JPanel {

    private Color grayRed;
    private Color pastelGrayOrange;
    private Color darkBrown;
    private JButton createTruckButton;
    private JButton manageTrucksButton;
    private JButton viewDashboardButton;
    private JLabel title;

    /**
     * Constructs a {@code MainMenuPanel} and initializes all its components with styles and layout.
     */
    public MainMenuPanel() {
        grayRed = new Color(194, 133, 131);
        pastelGrayOrange = new Color(216, 175, 157);
        darkBrown = new Color(96, 63, 38);
        Dimension buttonSize = new Dimension(350, 100);

        JLabel image = createImageLabel("src/assets/pic.png", 150, 150);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60)); // padding
        this.add(image);
        this.setOpaque(false);

        title = new JLabel("Coffee Truck Management");
        title.setForeground(grayRed);
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        createTruckButton = new JButton("Create Coffee Truck");
        createTruckButton.setFont(new Font("Arial", Font.BOLD, 20));
        createTruckButton.setForeground(darkBrown);
        createTruckButton.setBackground(pastelGrayOrange);
        createTruckButton.setMaximumSize(buttonSize);
        createTruckButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        manageTrucksButton = new JButton("Manage Existing Trucks");
        manageTrucksButton.setFont(new Font("Arial", Font.BOLD, 20));
        manageTrucksButton.setForeground(darkBrown);
        manageTrucksButton.setBackground(pastelGrayOrange);
        manageTrucksButton.setMaximumSize(buttonSize);
        manageTrucksButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        viewDashboardButton = new JButton("View Business Dashboard");
        viewDashboardButton.setFont(new Font("Arial", Font.BOLD, 20));
        viewDashboardButton.setForeground(darkBrown);
        viewDashboardButton.setBackground(pastelGrayOrange);
        viewDashboardButton.setMaximumSize(buttonSize);
        viewDashboardButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(title);
        this.add(Box.createRigidArea(new Dimension(0, 30))); // spacing
        this.add(createTruckButton);
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(manageTrucksButton);
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(viewDashboardButton);
    }

    /**
     * Creates a scaled image label to display at the top of the menu.
     *
     * @param imagePath the path to the image file
     * @param width the width to scale the image to
     * @param height the height to scale the image to
     * @return a {@code JLabel} containing the scaled image
     */
    private JLabel createImageLabel(String imagePath, int width, int height) {
        ImageIcon icon = new ImageIcon(imagePath);
        Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(scaledImage);

        JLabel imageLabel = new JLabel(resizedIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        return imageLabel;
    }

    /**
     * Adds a listener to the "Create Coffee Truck" button.
     *
     * @param listener the {@code ActionListener} to attach
     */
    public void addCreateTruckListener(ActionListener listener) {
        createTruckButton.addActionListener(listener);
    }

    /**
     * Adds a listener to the "Manage Existing Trucks" button.
     *
     * @param listener the {@code ActionListener} to attach
     */
    public void addManageTrucksListener(ActionListener listener) {
        manageTrucksButton.addActionListener(listener);
    }

    /**
     * Adds a listener to the "View Business Dashboard" button.
     *
     * @param listener the {@code ActionListener} to attach
     */
    public void addViewDashboardListener(ActionListener listener) {
        viewDashboardButton.addActionListener(listener);
    }
}
