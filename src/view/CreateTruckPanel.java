package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

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
 * MainMenuPanel
 */
public class CreateTruckPanel extends JPanel {

    private JRadioButton regularTruck;
    private JRadioButton specialTruck;
    private JButton createTruckButton;
    private JTextField truckNameField;
    private JPanel radioButtons;
    private JLabel nameLabel;
    private JLabel title;

    public CreateTruckPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60)); // padding

        title = new JLabel("Create Coffee Truck");
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        createTruckButton = new JButton("Create Coffee Truck");

        createTruckButton.setFont(new Font("Arial", Font.BOLD, 20));

        Dimension buttonSize = new Dimension(350, 100);
        createTruckButton.setMaximumSize(buttonSize);
        createTruckButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        nameLabel = new JLabel("Truck Name:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        truckNameField = new JTextField();
        truckNameField.setMaximumSize(new Dimension(350, 40));
        truckNameField.setFont(new Font("Arial", Font.PLAIN, 16));
        truckNameField.setAlignmentX(Component.CENTER_ALIGNMENT);

        regularTruck = new JRadioButton("Regular");
        specialTruck = new JRadioButton("Special");

        radioButtons = new JPanel();
        radioButtons.setLayout(new BoxLayout(radioButtons, BoxLayout.X_AXIS));
        radioButtons.add(regularTruck);
        radioButtons.add(specialTruck);

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

    public String getSelectedTruck() {
        if (regularTruck.isSelected()) {
            return "regular";
        }
        if (specialTruck.isSelected()) {
            return "special";
        }
        return null;
    }

}
