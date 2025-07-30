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

public class ChangeTruckLocationPanel extends JPanel {
    private Color grayRed;
    private Color pastelGrayOrange;
    private Color darkBrown;
    private Color peachyOrange;
    private JButton createTruckButton;
    private JButton mainMenuButton;
    private JTextField truckNameField;
    private JLabel nameLabel;
    private JLabel title;


    public ChangeTruckLocationPanel() {
        grayRed = new Color(194, 133, 131);
        pastelGrayOrange = new Color(216, 175, 157);
        darkBrown = new Color(96, 63, 38);
        peachyOrange = new Color(255, 243, 224);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60)); // padding
        this.setOpaque(false);

        title = new JLabel("Change Coffee Truck Location");
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

        mainMenuButton = new JButton("Main Menu");
        mainMenuButton.setFont(new Font("Arial", Font.BOLD, 20));
        mainMenuButton.setForeground(darkBrown);
        mainMenuButton.setBackground(pastelGrayOrange);
        mainMenuButton.setMaximumSize(buttonSize);
        mainMenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(title);
        this.add(Box.createRigidArea(new Dimension(0, 30))); // spacing
        this.add(nameLabel);
        this.add(Box.createRigidArea(new Dimension(0, 30))); // spacing
        this.add(truckNameField);
        this.add(Box.createRigidArea(new Dimension(0, 30))); // spacing
        this.add(createTruckButton);
        this.add(Box.createRigidArea(new Dimension(0, 30))); // spacing
        this.add(mainMenuButton);

    }
}
