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

public class SetLocationPanel extends JPanel {
    private Color grayRed;
    private Color lightRed;
    private Color pastelGrayOrange;
    private Color brown;
    private Color darkBrown;
    private Color lightGray;
    private Color peachyOrange;
    private JButton setLocationButton;
    private JButton interactionsMenuButton;
    private JTextField truckLocationField;
    private JLabel nameLabel;
    private JLabel title;

    public SetLocationPanel() {
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
        this.add(Box.createRigidArea(new Dimension(0, 30))); // spacing
        this.add(nameLabel);
        this.add(Box.createRigidArea(new Dimension(0, 30))); // spacing
        this.add(truckLocationField);
        this.add(Box.createRigidArea(new Dimension(0, 30))); // spacing
        this.add(setLocationButton);
        this.add(Box.createRigidArea(new Dimension(0, 30))); // spacing
        this.add(interactionsMenuButton);

    }

    public String getNewLocation() {
        return truckLocationField.getText();
    }

    public void addInteractionsMenuListener(ActionListener listener) {
        interactionsMenuButton.addActionListener(listener);
    }

    public void addSetLocationListener(ActionListener listener) {
        setLocationButton.addActionListener(listener);
    }

}
