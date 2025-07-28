package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 * SetPricesPanel
 */
public class SetPricesPanel extends JPanel {

    private JButton submitButton;
    private JPanel menus;
    private ArrayList<JPanel> priceEntries;
    private ArrayList<JSpinner> priceFields = new ArrayList<>();
    private final String[] drinks = { "Americano", "Latte", "Cappuccino" };
    private final String[] sizes = { "Small", "Medium", "Large" };
    private JLabel nameLabel;
    private JLabel typeLabel;
    private JLabel title;

    public SetPricesPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60)); // padding
        this.setOpaque(false);

        title = new JLabel("Set Truck Prices");
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        submitButton = new JButton("Set Truck Prices");

        submitButton.setFont(new Font("Arial", Font.BOLD, 20));

        Dimension buttonSize = new Dimension(350, 100);
        submitButton.setMaximumSize(buttonSize);
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        nameLabel = new JLabel("");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        typeLabel = new JLabel("");
        typeLabel.setFont(new Font("Arial", Font.BOLD, 20));

        priceEntries = new ArrayList<JPanel>();
        menus = new JPanel();
        menus.setLayout(new BoxLayout(menus, BoxLayout.Y_AXIS));
        menus.setMaximumSize(new Dimension(600, 720));

        int i = 0;

        for (String drink : drinks) {
            for (String size : sizes) {
                priceEntries.add(i, new JPanel());
                priceEntries.get(i).setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
                JLabel label = new JLabel(drink + " (" + size + ")");
                label.setFont(new Font("Arial", Font.BOLD, 20));
                priceEntries.get(i).add(label);
                priceEntries.get(i).add(Box.createRigidArea(new Dimension(30, 0))); // spacing

                SpinnerNumberModel spinnerModel = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1); // (initial, min,
                                                                                                      // max,

                JSpinner spinner = new JSpinner(spinnerModel);
                spinner.setFont(new Font("Arial", Font.BOLD, 20));
                spinner.setMaximumSize(new Dimension(150, 40));
                priceFields.add(spinner);
                priceEntries.get(i).add(spinner);
                i++;
            }
        }
        priceEntries.add(i, new JPanel());
        priceEntries.get(i).setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        JLabel label = new JLabel("Add-ons");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        priceEntries.get(i).add(label);
        priceEntries.get(i).add(Box.createRigidArea(new Dimension(30, 0))); // spacing

        SpinnerNumberModel spinnerModel = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1); // (initial, min,
        // max,
        JSpinner spinner = new JSpinner(spinnerModel);
        spinner.setFont(new Font("Arial", Font.BOLD, 20));
        spinner.setMaximumSize(new Dimension(150, 40));
        priceFields.add(spinner);
        priceEntries.get(i).add(spinner);

        this.add(title);
        this.add(Box.createRigidArea(new Dimension(0, 30))); // spacing
        this.add(nameLabel);
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(typeLabel);
        this.add(Box.createRigidArea(new Dimension(0, 15)));

        for (i = 0; i < 10; i++) {
            menus.add(priceEntries.get(i));
            menus.add(Box.createRigidArea(new Dimension(0, 2)));
        }
        this.add(menus);

        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(submitButton);
    }

    public ArrayList<JSpinner> getSpinners() {
        return priceFields;
    }

    public String[] getDrinks() {
        return drinks;
    }

    public String[] getSizes() {
        return sizes;
    }

    public void setSelectedTruckText(String text) {
        nameLabel.setText(text);
    }

    public void setTruckTypeText(String text) {
        typeLabel.setText(text);
    }

    public void addSetPricesListener(ActionListener listener) {
        submitButton.addActionListener(listener);
    }

}
