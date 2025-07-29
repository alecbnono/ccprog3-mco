package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

/**
 * ReceiptPanel
 */
public class ReceiptPanel extends JPanel {

    private JLabel receipt;
    private JButton interactionsMenuButton;
    private JLabel title;

    public ReceiptPanel() {

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60)); // padding
        this.setOpaque(false);

        title = new JLabel("Receipt");
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        interactionsMenuButton = new JButton("Back");
        interactionsMenuButton.setFont(new Font("Arial", Font.BOLD, 20));

        ImageIcon image = new ImageIcon("../assets/receipt.png");

        receipt = new JLabel();
        receipt.setIcon(image);
        receipt.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(title);
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(receipt);
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(interactionsMenuButton);
    }

    public void setOutputString(String string) {
        receipt.setText(string);
    }

    public void addInteractionsMenuListener(ActionListener listener) {
        interactionsMenuButton.addActionListener(listener);
    }

}
