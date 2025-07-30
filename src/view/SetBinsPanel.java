package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

/**
 * The {@code SetBinsPanel} class represents a UI panel for setting the inventory
 * of a truck, including both regular and special storage bins. Users can select
 * item types and specify quantities for each bin using combo boxes and spinners.
 *
 * <p>It supports dynamic rendering of UI components based on truck type
 * (e.g., special trucks showing additional ingredient bins).</p>
 */
public class SetBinsPanel extends JPanel {
    // Theme colors
    private Color grayRed;
    private Color lightRed;
    private Color pastelGrayOrange;
    private Color darkBrown;
    private Color peachyOrange;

    // Components
    private JButton submitButton;
    private ArrayList<JPanel> regularStorageBins;
    private ArrayList<JPanel> specialStorageBins;
    private JPanel regularMenu;
    private JPanel specialMenu;
    private JPanel allMenus;
    private ArrayList<JComboBox<String>> binTypeSelectors = new ArrayList<>();
    private ArrayList<JSpinner> binAmountFields = new ArrayList<>();
    private final String[] regularOptions = { "", "Small Cup", "Medium Cup", "Large Cup", "Coffee Beans", "Milk", "Water" };
    private final String[] specialOptions = { "", "Hazelnut", "Vanilla", "Chocolate", "Almond", "Sucrose" };
    private JLabel nameLabel;
    private JLabel typeLabel;
    private JLabel title;

    /**
     * Constructs a new {@code SetBinsPanel}, initializing all UI components
     * and layout for truck inventory setup.
     */
    public SetBinsPanel() {
        // Color initialization
        grayRed = new Color(194, 133, 131);
        lightRed = new Color(248, 218, 217);
        pastelGrayOrange = new Color(216, 175, 157);
        darkBrown = new Color(96, 63, 38);
        peachyOrange = new Color(255, 243, 224);
        Dimension buttonSize = new Dimension(350, 100);

        // Layout and spacing
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));
        this.setOpaque(false);

        // Title
        title = new JLabel("Set Truck Inventory");
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setForeground(grayRed);

        // Submit Button
        submitButton = new JButton("Set Truck Inventory");
        submitButton.setForeground(darkBrown);
        submitButton.setBackground(pastelGrayOrange);
        submitButton.setFont(new Font("Arial", Font.BOLD, 20));
        submitButton.setMaximumSize(buttonSize);
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Truck labels
        nameLabel = new JLabel("");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        nameLabel.setForeground(darkBrown);

        typeLabel = new JLabel("");
        typeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        typeLabel.setForeground(darkBrown);

        // Regular bin menu
        binTypeSelectors = new ArrayList<>();
        binAmountFields = new ArrayList<>();
        regularStorageBins = new ArrayList<>();
        regularMenu = new JPanel();
        regularMenu.setLayout(new BoxLayout(regularMenu, BoxLayout.Y_AXIS));
        regularMenu.setOpaque(false);

        // Special bin menu
        specialMenu = new JPanel();
        specialMenu.setLayout(new BoxLayout(specialMenu, BoxLayout.Y_AXIS));
        specialMenu.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
        specialMenu.setOpaque(false);

        // Container for all menus
        allMenus = new JPanel();
        allMenus.setLayout(new BoxLayout(allMenus, BoxLayout.X_AXIS));
        allMenus.setMaximumSize(new Dimension(1000, 720));
        allMenus.setBackground(lightRed);

        // Create regular bins
        for (int i = 0; i < 8; i++) {
            JPanel panel = createBinPanel(i, "Box #", regularOptions, false);
            regularStorageBins.add(panel);
            regularMenu.add(panel);
        }

        // Create special bins
        specialStorageBins = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            JPanel panel = createBinPanel(i, "Special Box #", specialOptions, true);
            specialStorageBins.add(panel);
            specialMenu.add(panel);
        }

        // Add menus to layout
        allMenus.add(regularMenu);

        // Final layout
        this.add(title);
        this.add(Box.createRigidArea(new Dimension(0, 30)));
        this.add(nameLabel);
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(typeLabel);
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(allMenus);
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(submitButton);
    }

    /**
     * Returns the list of {@code JSpinner} components representing quantity fields.
     *
     * @return list of spinners for bin quantities
     */
    public ArrayList<JSpinner> getSpinners() {
        return binAmountFields;
    }

    /**
     * Returns the list of {@code JComboBox} components representing bin type selectors.
     *
     * @return list of combo boxes for selecting bin contents
     */
    public ArrayList<JComboBox<String>> getComboBoxes() {
        return binTypeSelectors;
    }

    /**
     * Sets the text displayed for the selected truck's name.
     *
     * @param text the truck name to display
     */
    public void setSelectedTruckText(String text) {
        nameLabel.setText(text);
    }

    /**
     * Sets the text for the truck type and dynamically shows/hides special bins.
     *
     * @param text the truck type to display (e.g., "Special")
     */
    public void setTruckTypeText(String text) {
        typeLabel.setText(text);
        allMenus.remove(specialMenu);
        if (text.equals("Special")) {
            allMenus.add(specialMenu);
        }
        allMenus.revalidate();
        allMenus.repaint();
    }

    /**
     * Adds an action listener to the submit button.
     *
     * @param listener the {@code ActionListener} to be triggered on submit
     */
    public void addSetBinsListener(ActionListener listener) {
        submitButton.addActionListener(listener);
    }

    /**
     * Helper method to create a bin panel (regular or special) with label,
     * combo box, and spinner.
     *
     * @param index       the bin number index
     * @param labelPrefix the label text prefix (e.g., "Box #")
     * @param options     the options to include in the combo box
     * @param isSpecial   whether the bin is a special ingredient bin
     * @return a configured {@code JPanel} for the bin
     */
    private JPanel createBinPanel(int index, String labelPrefix, String[] options, boolean isSpecial) {
        JPanel panel = new JPanel();
        panel.setBackground(lightRed);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        JLabel label = new JLabel(labelPrefix + (index + 1));
        label.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(30, 0)));

        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setSelectedIndex(0);
        comboBox.setFont(new Font("Arial", Font.BOLD, 20));
        comboBox.setMaximumSize(new Dimension(150, 40));
        comboBox.setBackground(peachyOrange);
        comboBox.setForeground(darkBrown);
        binTypeSelectors.add(comboBox);
        panel.add(comboBox);
        panel.add(Box.createRigidArea(new Dimension(30, 0)));

        SpinnerNumberModel spinnerModel = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
        JSpinner spinner = new JSpinner(spinnerModel);
        spinner.setFont(new Font("Arial", Font.BOLD, 20));
        spinner.setPreferredSize(new Dimension(150, 40));
        spinner.setMaximumSize(new Dimension(160, 40));
        binAmountFields.add(spinner);

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

        panel.add(spinner);
        return panel;
    }
}
