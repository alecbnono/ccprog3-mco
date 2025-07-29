package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

/**
 * ReceiptPanel
 */
public class ReceiptPanel extends JPanel {
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

    public ReceiptPanel() {
        grayRed = new Color(194, 133, 131);
        lightRed = new Color(248, 218, 217);
        pastelGrayOrange = new Color(216, 175, 157);
        brown = new Color(108, 78, 49);
        darkBrown = new Color(96, 63, 38);
        lightGray = new Color(217, 217, 217);
        peachyOrange = new Color(255, 243, 224);
        Dimension buttonSize = new Dimension(350, 100);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60)); // padding
        this.setOpaque(false);

        title = new JLabel("Receipt");
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setForeground(grayRed);

        interactionsMenuButton = new JButton("Back");
        interactionsMenuButton.setFont(new Font("Arial", Font.BOLD, 20));
        interactionsMenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        interactionsMenuButton.setBackground(pastelGrayOrange);
        interactionsMenuButton.setForeground(darkBrown);
        interactionsMenuButton.setMaximumSize(buttonSize);

        ImageIcon image = new ImageIcon("../assets/receipt.png");

        receipt = new JLabel();
        receipt.setIcon(image);
        receipt.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(title);
        this.add(Box.createRigidArea(new Dimension(0, 35)));
        this.add(receipt);
        this.add(Box.createRigidArea(new Dimension(0, 45)));
        this.add(interactionsMenuButton);
    }

    public void setOutputString(String string) {
        receipt.setText(string);
    }

    public void addInteractionsMenuListener(ActionListener listener) {
        interactionsMenuButton.addActionListener(listener);
    }

}
