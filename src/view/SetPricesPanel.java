package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

/**
 * A panel for setting the prices of coffee drinks for a truck.
 * Allows the user to input prices for various drink-size combinations and an add-on price.
 */
public class SetPricesPanel extends JPanel {

    /** Custom gray-red color */
    private Color grayRed;
    /** Light red background color */
    private Color lightRed;
    /** Dark brown text color */
    private Color darkBrown;
    /** Peachy orange background color */
    private Color peachyOrange;

    /** Button to submit the price settings */
    private JButton submitButton;
    /** Container panel for the drink price menus */
    private JPanel menus;

    /** List of panels containing drink/size and price input */
    private ArrayList<JPanel> priceEntries;

    /** List of spinner fields for entering prices */
    private ArrayList<JSpinner> priceFields = new ArrayList<>();

    /** Names of available drinks */
    private final String[] drinks = { "Americano", "Latte", "Cappuccino" };
    /** Available sizes for each drink */
    private final String[] sizes = { "Small", "Medium", "Large" };

    /** Label displaying the selected truck name */
    private JLabel nameLabel;
    /** Label displaying the selected truck type */
    private JLabel typeLabel;
    /** Title label */
    private JLabel title;

    /**
     * Constructs a SetPricesPanel with input fields for all drink-size combinations and an add-on.
     */
    public SetPricesPanel() {
        grayRed = new Color(194, 133, 131);
        lightRed = new Color(248, 218, 217);
        darkBrown = new Color(96, 63, 38);
        peachyOrange = new Color(255, 243, 224);
        Dimension buttonSize = new Dimension(350, 100);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));
        this.setOpaque(false);

        title = new JLabel("Set Truck Prices");
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setForeground(grayRed);

        submitButton = new JButton("Set Truck Prices");
        submitButton.setBackground(peachyOrange);
        submitButton.setForeground(darkBrown);
        submitButton.setFont(new Font("Arial", Font.BOLD, 20));
        submitButton.setMaximumSize(buttonSize);
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        nameLabel = new JLabel("");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        nameLabel.setForeground(darkBrown);
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        typeLabel = new JLabel("");
        typeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        typeLabel.setForeground(darkBrown);
        typeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        priceEntries = new ArrayList<JPanel>();
        menus = new JPanel();
        menus.setLayout(new BoxLayout(menus, BoxLayout.Y_AXIS));
        menus.setMaximumSize(new Dimension(600, 720));
        menus.setOpaque(false);

        int i = 0;
        for (String drink : drinks) {
            for (String size : sizes) {
                priceEntries.add(i, new JPanel());
                priceEntries.get(i).setLayout(new BoxLayout(priceEntries.get(i), BoxLayout.X_AXIS));
                priceEntries.get(i).setBackground(lightRed);

                JLabel label = new JLabel(drink + " (" + size + ")");
                label.setFont(new Font("Arial", Font.BOLD, 20));
                label.setForeground(darkBrown);
                priceEntries.get(i).add(label);
                priceEntries.get(i).add(Box.createHorizontalGlue());

                SpinnerNumberModel spinnerModel = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
                JSpinner spinner = new JSpinner(spinnerModel);
                spinner.setFont(new Font("Arial", Font.BOLD, 20));
                spinner.setMaximumSize(new Dimension(150, 40));
                priceFields.add(spinner);
                priceEntries.get(i).add(spinner);

                JComponent editor = spinner.getEditor();
                JFormattedTextField spinnerTextField = ((JSpinner.DefaultEditor) editor).getTextField();
                spinnerTextField.setBackground(peachyOrange);
                spinnerTextField.setForeground(darkBrown);

                for (Component comp : spinner.getComponents()) {
                    if (comp instanceof JButton) {
                        JButton smallButton = (JButton) comp;
                        smallButton.setBackground(peachyOrange);
                        smallButton.setForeground(darkBrown);
                        smallButton.setBorder(BorderFactory.createLineBorder(darkBrown));
                    }
                }

                i++;
            }
        }

        // Add-on spinner
        priceEntries.add(i, new JPanel());
        priceEntries.get(i).setLayout(new BoxLayout(priceEntries.get(i), BoxLayout.X_AXIS));
        priceEntries.get(i).setBackground(lightRed);

        JLabel label = new JLabel("Add-ons");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(darkBrown);
        priceEntries.get(i).add(label);
        priceEntries.get(i).add(Box.createHorizontalGlue());

        SpinnerNumberModel spinnerModel = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
        JSpinner spinner = new JSpinner(spinnerModel);
        spinner.setFont(new Font("Arial", Font.BOLD, 20));
        spinner.setMaximumSize(new Dimension(150, 40));
        priceFields.add(spinner);
        priceEntries.get(i).add(spinner);

        JComponent editor = spinner.getEditor();
        JFormattedTextField spinnerTextField = ((JSpinner.DefaultEditor) editor).getTextField();
        spinnerTextField.setBackground(peachyOrange);
        spinnerTextField.setForeground(darkBrown);

        for (Component comp : spinner.getComponents()) {
            if (comp instanceof JButton) {
                JButton smallButton = (JButton) comp;
                smallButton.setBackground(peachyOrange);
                smallButton.setForeground(darkBrown);
                smallButton.setBorder(BorderFactory.createLineBorder(darkBrown));
            }
        }

        this.add(title);
        this.add(Box.createRigidArea(new Dimension(0, 30)));
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

    /**
     * Returns the list of JSpinners containing the input prices.
     *
     * @return list of JSpinner components
     */
    public ArrayList<JSpinner> getSpinners() {
        return priceFields;
    }

    /**
     * Returns the array of drink names.
     *
     * @return array of drink names
     */
    public String[] getDrinks() {
        return drinks;
    }

    /**
     * Returns the array of drink sizes.
     *
     * @return array of drink sizes
     */
    public String[] getSizes() {
        return sizes;
    }

    /**
     * Sets the text for the truck name label.
     *
     * @param text the truck name
     */
    public void setSelectedTruckText(String text) {
        nameLabel.setText(text);
    }

    /**
     * Sets the text for the truck type label.
     *
     * @param text the truck type
     */
    public void setTruckTypeText(String text) {
        typeLabel.setText(text);
    }

    /**
     * Adds an ActionListener for the submit button.
     *
     * @param listener the ActionListener to be added
     */
    public void addSetPricesListener(ActionListener listener) {
        submitButton.addActionListener(listener);
    }
}
