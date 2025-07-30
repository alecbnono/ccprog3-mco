package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The {@code SetLocationPanel} class is a GUI panel that allows the user
 * to input and set the location (name) of a coffee truck.
 * It also provides a button to go back to the interactions menu.
 */
public class SetLocationPanel extends JPanel {

    /** Color used for grayish red components. */
    private Color grayRed;
    /** Color used for pastel orange-gray components. */
    private Color pastelGrayOrange;
    /** Color used for dark brown components. */
    private Color darkBrown;
    /** Color used for light peachy-orange components. */
    private Color peachyOrange;

    /** Button used to submit the location input. */
    private JButton setLocationButton;

    /** Button used to navigate back to the interactions menu. */
    private JButton interactionsMenuButton;

    /** Text field to input the new truck location. */
    private JTextField truckLocationField;

    /** Label describing the name input field. */
    private JLabel nameLabel;

    /** Title label of the panel. */
    private JLabel title;

    /**
     * Constructs a new {@code SetLocationPanel} and initializes its components.
     */
    public SetLocationPanel() {
        grayRed = new Color(194, 133, 131);
        pastelGrayOrange = new Color(216, 175, 157);
        darkBrown = new Color(96, 63, 38);
        peachyOrange = new Color(255, 243, 224);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));
        this.setOpaque(false);

        title = new JLabel("Change Coffee Truck Location");
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setForeground(grayRed);

        setLocationButton = new JButton("Create Coffee Truck");
        setLocationButton.setFont(new Font("Arial", Font.BOLD, 20));
        setLocationButton.setForeground(darkBrown);
        setLocationButton.setBackground(pastelGrayOrange);
        Dimension buttonSize = new Dimension(350, 100);
        setLocationButton.setMaximumSize(buttonSize);
        setLocationButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        nameLabel = new JLabel("Truck Name:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameLabel.setForeground(darkBrown);

        truckLocationField = new JTextField();
        truckLocationField.setMaximumSize(new Dimension(350, 40));
        truckLocationField.setFont(new Font("Arial", Font.PLAIN, 16));
        truckLocationField.setAlignmentX(Component.CENTER_ALIGNMENT);
        truckLocationField.setBackground(peachyOrange);
        truckLocationField.setForeground(darkBrown);

        interactionsMenuButton = new JButton("Back");
        interactionsMenuButton.setFont(new Font("Arial", Font.BOLD, 20));
        interactionsMenuButton.setForeground(darkBrown);
        interactionsMenuButton.setBackground(pastelGrayOrange);
        interactionsMenuButton.setMaximumSize(buttonSize);
        interactionsMenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(title);
        this.add(Box.createRigidArea(new Dimension(0, 30)));
        this.add(nameLabel);
        this.add(Box.createRigidArea(new Dimension(0, 30)));
        this.add(truckLocationField);
        this.add(Box.createRigidArea(new Dimension(0, 30)));
        this.add(setLocationButton);
        this.add(Box.createRigidArea(new Dimension(0, 30)));
        this.add(interactionsMenuButton);
    }

    /**
     * Returns the user-inputted truck location.
     *
     * @return the text entered in the location field
     */
    public String getNewLocation() {
        return truckLocationField.getText();
    }

    /**
     * Adds an {@code ActionListener} to the back button.
     *
     * @param listener the listener to handle back button actions
     */
    public void addInteractionsMenuListener(ActionListener listener) {
        interactionsMenuButton.addActionListener(listener);
    }

    /**
     * Adds an {@code ActionListener} to the set location button.
     *
     * @param listener the listener to handle set location button actions
     */
    public void addSetLocationListener(ActionListener listener) {
        setLocationButton.addActionListener(listener);
    }

}
