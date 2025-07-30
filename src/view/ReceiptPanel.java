package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;

/**
 * The {@code ReceiptPanel} class represents the panel used to display
 * a receipt in the Coffee Truck Management system. It contains a title,
 * a receipt text area, an optional image, and a navigation button.
 */
public class ReceiptPanel extends JPanel {
    private Color grayRed;
    private Color pastelGrayOrange;
    private Color darkBrown;

    private Color lightGray;
    private Color peachyOrange;

    private JTextArea receiptTextArea;
    private JLabel imageLabel;
    private JButton interactionsMenuButton;
    private JLabel title;

    /**
     * Constructs a new {@code ReceiptPanel}, initializing its layout,
     * colors, components, and styling.
     */
    public ReceiptPanel() {
        grayRed = new Color(194, 133, 131);
        pastelGrayOrange = new Color(216, 175, 157);
        darkBrown = new Color(96, 63, 38);
        Dimension buttonSize = new Dimension(350, 100);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));
        this.setOpaque(false);

        title = new JLabel("Receipt");
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setForeground(grayRed);

        receiptTextArea = new JTextArea();
        receiptTextArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
        receiptTextArea.setEditable(false);
        receiptTextArea.setOpaque(false);
        receiptTextArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        receiptTextArea.setMaximumSize(new Dimension(550, 600));
        receiptTextArea.setLineWrap(true);
        receiptTextArea.setWrapStyleWord(true);
        

        interactionsMenuButton = new JButton("Back");
        interactionsMenuButton.setFont(new Font("Arial", Font.BOLD, 20));
        interactionsMenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        interactionsMenuButton.setBackground(pastelGrayOrange);
        interactionsMenuButton.setForeground(darkBrown);
        interactionsMenuButton.setMaximumSize(buttonSize);

        this.add(title);
        this.add(Box.createRigidArea(new Dimension(0, 35)));
        this.add(receiptTextArea);
        this.add(Box.createRigidArea(new Dimension(0, 45)));
        this.add(interactionsMenuButton);
    }

    /**
     * Sets the text content to be displayed in the receipt area.
     *
     * @param string the receipt text to display
     */
    public void setOutputString(String string) {
        receiptTextArea.setText(string);
    }

    /**
     * Adds an {@code ActionListener} to the "Back" button.
     *
     * @param listener the {@code ActionListener} to attach
     */
    public void addInteractionsMenuListener(ActionListener listener) {
        interactionsMenuButton.addActionListener(listener);
    }
}
