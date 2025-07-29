package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

/**
 * RecieptPanel
 */
public class RecieptPanel extends JPanel {
    private Color grayRed;
    private Color lightRed;
    private Color pastelGrayOrange;
    private Color brown;
    private Color darkBrown;
    private Color lightGray;
    private Color peachyOrange;
    private JLabel receipt;
    private JButton interactionsMenuButton;
    private JLabel title;

    public RecieptPanel() {
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

        title = new JLabel("Receipt");
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        interactionsMenuButton = new JButton("Back");
        interactionsMenuButton.setFont(new Font("Arial", Font.BOLD, 20));

        this.add(title);
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(interactionsMenuButton);
    }

    public void addInteractionsMenuListener(ActionListener listener) {
        interactionsMenuButton.addActionListener(listener);
    }

}
