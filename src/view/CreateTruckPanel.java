package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * CreateTruckPanel
 */
public class CreateTruckPanel extends JPanel {
    private Color grayRed;
    private Color lightRed;
    private Color pastelGrayOrange;
    private Color brown;
    private Color darkBrown;
    private Color lightGray;
    private Color peachyOrange;
    private JRadioButton regularTruck;
    private JRadioButton specialTruck;
    private JButton createTruckButton;
    private JTextField truckNameField;
    private JPanel radioButtons;
    private JLabel nameLabel;
    private JLabel title;

    public CreateTruckPanel() {
        grayRed = new Color(194, 133, 131);
        lightRed = new Color(248, 218, 217);
        pastelGrayOrange = new Color(216, 175, 157);
        brown = new Color(108, 78, 49);
        darkBrown = new Color(96, 63, 38);
        lightGray = new Color(217, 217, 217);
        peachyOrange = new Color(255, 243, 224);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60)); // padding
        this.setOpaque(false);

/*
        createTruckButton.setForeground(darkBrown);
        createTruckButton.setBackground(pastelGrayOrange);
 */
        title = new JLabel("Create Coffee Truck");
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setForeground(grayRed);

        createTruckButton = new JButton("Create Coffee Truck");

        createTruckButton.setFont(new Font("Arial", Font.BOLD, 20));
        createTruckButton.setForeground(darkBrown);
        createTruckButton.setBackground(pastelGrayOrange);

        Dimension buttonSize = new Dimension(350, 100);
        createTruckButton.setMaximumSize(buttonSize);
        createTruckButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        nameLabel = new JLabel("Truck Name:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameLabel.setForeground(darkBrown);

        truckNameField = new JTextField();
        truckNameField.setMaximumSize(new Dimension(350, 40));
        truckNameField.setFont(new Font("Arial", Font.PLAIN, 16));
        truckNameField.setAlignmentX(Component.CENTER_ALIGNMENT);
        truckNameField.setBackground(peachyOrange);
        truckNameField.setForeground(darkBrown);

        regularTruck = new JRadioButton("Regular");
        specialTruck = new JRadioButton("Special");

        radioButtons = new JPanel();
        radioButtons.setLayout(new BoxLayout(radioButtons, BoxLayout.X_AXIS));
        radioButtons.add(regularTruck);
        radioButtons.add(specialTruck);
        radioButtons.setBackground(pastelGrayOrange);


        regularTruck.setBackground(lightRed);
        regularTruck.setForeground(darkBrown);
        regularTruck.setFocusPainted(false);
        regularTruck.setOpaque(true);


        specialTruck.setBackground(lightRed);
        specialTruck.setForeground(darkBrown);
        specialTruck.setFocusPainted(false);
        specialTruck.setOpaque(true);

        ButtonGroup group = new ButtonGroup();
        group.add(regularTruck);
        group.add(specialTruck);

        this.add(title);
        this.add(Box.createRigidArea(new Dimension(0, 30))); // spacing
        this.add(nameLabel);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(truckNameField);
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(radioButtons);
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(createTruckButton);
    }

    public String getTruckLocation() {
        return truckNameField.getText();
    }

    public String getTruckType() {
        if (regularTruck.isSelected()) {
            return "Regular";
        }
        if (specialTruck.isSelected()) {
            return "Special";
        }
        return null;
    }

    public void addCreateTruckListener(ActionListener listener) {
        createTruckButton.addActionListener(listener);
    }

}
