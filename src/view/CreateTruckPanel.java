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
 * {@code CreateTruckPanel} is a custom JPanel that allows users to create a coffee truck.
 * It includes input for truck name, radio buttons to select truck type (Regular or Special),
 * and a button to submit the form.
 */
public class CreateTruckPanel extends JPanel {

    /** Color used for titles. */
    private Color grayRed;

    /** Light red background for radio buttons. */
    private Color lightRed;

    /** Color for button backgrounds. */
    private Color pastelGrayOrange;

    /** Dark brown used for text and borders. */
    private Color darkBrown;

    /** Light peach background color for input fields. */
    private Color peachyOrange;

    /** Radio button for selecting a regular truck type. */
    private JRadioButton regularTruck;

    /** Radio button for selecting a special truck type. */
    private JRadioButton specialTruck;

    /** Button to trigger truck creation. */
    private JButton createTruckButton;

    /** Text field for entering the truck's name. */
    private JTextField truckNameField;

    /** Panel containing the radio buttons. */
    private JPanel radioButtons;

    /** Label indicating where to input truck name. */
    private JLabel nameLabel;

    /** Title label at the top of the panel. */
    private JLabel title;

    /**
     * Constructs a {@code CreateTruckPanel} with pre-styled Swing components for truck creation.
     * Sets layout, initializes UI elements, and groups radio buttons.
     */
    public CreateTruckPanel() {
        grayRed = new Color(194, 133, 131);
        lightRed = new Color(248, 218, 217);
        pastelGrayOrange = new Color(216, 175, 157);
        darkBrown = new Color(96, 63, 38);
        peachyOrange = new Color(255, 243, 224);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));
        this.setOpaque(false);

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
        this.add(Box.createRigidArea(new Dimension(0, 30)));
        this.add(nameLabel);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(truckNameField);
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(radioButtons);
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(createTruckButton);
    }

    /**
     * Gets the user-entered name for the truck.
     *
     * @return the name of the truck as a {@code String}
     */
    public String getTruckLocation() {
        return truckNameField.getText();
    }

    /**
     * Gets the selected truck type.
     *
     * @return {@code "Regular"}, {@code "Special"}, or {@code null} if none is selected
     */
    public String getTruckType() {
        if (regularTruck.isSelected()) {
            return "Regular";
        }
        if (specialTruck.isSelected()) {
            return "Special";
        }
        return null;
    }

    /**
     * Adds an {@code ActionListener} to the "Create Coffee Truck" button.
     *
     * @param listener the action listener to handle button events
     */
    public void addCreateTruckListener(ActionListener listener) {
        createTruckButton.addActionListener(listener);
    }

}
