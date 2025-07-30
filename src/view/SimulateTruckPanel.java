package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

/**
 * The {@code SimulateTruckPanel} class represents a GUI panel that allows users
 * to simulate a drink sale, including selecting the drink, size, espresso strength,
 * and optional add-ons.
 */
public class SimulateTruckPanel extends JPanel {
    /** Color used for gray-red accents */
    private Color grayRed;

    /** Color used for dark brown text and elements */
    private Color darkBrown;

    /** Color used for peachy-orange backgrounds */
    private Color peachyOrange;

    /** Main panel that holds the full menu UI */
    private JPanel fullMenuPanel;

    /** Array of available drinks */
    private final String[] drinks = { "Americano", "Latte", "Cappuccino" };

    /** Array of available cup sizes */
    private final String[] sizes = { "Small", "Medium", "Large" };

    /** Dropdown for selecting the drink type */
    private JComboBox<String> drinkComboBox;

    /** Dropdown for selecting the cup size */
    private JComboBox<String> sizeComboBox;

    /** Panel for base drink controls */
    private JPanel baseDrinkPanel;

    /** Array of base espresso options */
    private final String[] baseEspressos = { "Light", "Standard", "Strong", "Custom" };

    /** Dropdown for selecting base espresso type */
    private JComboBox<String> baseEspresso;

    /** Panel for base espresso options */
    private JPanel baseEspressoPanel;

    /** Spinner for custom base espresso ratio */
    private JSpinner baseRatio;

    /** Array of syrup add-ons */
    private final String[] addOns = { "", "Hazelnut", "Vanilla", "Chocolate", "Almond", "Sucrose" };

    /** Dropdown for selecting a syrup add-on */
    private JComboBox<String> addOnSyrups;

    /** Array of add-on espresso options */
    private final String[] addOnEspressos = { "", "Light", "Standard", "Strong", "Custom" };

    /** Dropdown for selecting add-on espresso type */
    private JComboBox<String> addOnEspresso;

    /** Panel for add-on espresso options */
    private JPanel addOnEspressoPanel;

    /** Spinner for custom add-on espresso ratio */
    private JSpinner addOnRatio;

    /** Panel that holds special menu items */
    private JPanel specialMenuPanel;

    /** Button to return to the interactions menu */
    private JButton interactionsMenuButton;

    /** Button to submit the drink configuration */
    private JButton submitButton;

    /** Label for the panel title */
    private JLabel title;
    /**
     * Constructs a new {@code SimulateTruckPanel} with all the necessary GUI components
     * for simulating a coffee drink sale. The panel includes controls for selecting
     * drink type, cup size, base espresso strength (including custom ratios), syrup add-ons,
     * and optional espresso shots. It also configures layout, colors, and event handling
     * for dynamic input components.
     *
     * <p>This constructor organizes all interactive components using {@code BoxLayout}
     * and {@code FlowLayout}, applies consistent visual styling with custom colors and fonts,
     * and wires listeners to dynamically add or remove custom ratio fields based on selections.</p>
     */
    public SimulateTruckPanel() {
        grayRed = new Color(194, 133, 131);
        darkBrown = new Color(96, 63, 38);
        peachyOrange = new Color(255, 243, 224);
        Dimension vertical = new Dimension(0, 15);
        Dimension comboBoxSize = new Dimension(150, 40);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setAlignmentY(Component.CENTER_ALIGNMENT);
        this.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60)); // padding
        this.setOpaque(false);
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setAlignmentY(Component.CENTER_ALIGNMENT);

        title = new JLabel("Simulate Drink Sale");
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setForeground(grayRed);

        drinkComboBox = new JComboBox<>(drinks);
        drinkComboBox.setMaximumSize(comboBoxSize);
        drinkComboBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        drinkComboBox.setBackground(peachyOrange);
        drinkComboBox.setForeground(darkBrown);

        sizeComboBox = new JComboBox<>(sizes);
        sizeComboBox.setMaximumSize(comboBoxSize);
        sizeComboBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        sizeComboBox.setBackground(peachyOrange);
        sizeComboBox.setForeground(darkBrown);

        fullMenuPanel = new JPanel();
        fullMenuPanel.setLayout(new BoxLayout(fullMenuPanel, BoxLayout.Y_AXIS));
        fullMenuPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
        fullMenuPanel.setOpaque(false);

        baseDrinkPanel = new JPanel();
        baseDrinkPanel.setLayout(new BoxLayout(baseDrinkPanel, BoxLayout.X_AXIS));
        baseDrinkPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        baseDrinkPanel.setOpaque(false);
        baseDrinkPanel.add(drinkComboBox);
        baseDrinkPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        baseDrinkPanel.add(sizeComboBox);

        baseEspressoPanel = new JPanel();
        baseEspressoPanel.setLayout(new BoxLayout(baseEspressoPanel, BoxLayout.Y_AXIS));
        baseEspressoPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
        baseEspressoPanel.setOpaque(false);

        baseEspresso = new JComboBox<String>(baseEspressos);
        baseEspresso.setMaximumSize(comboBoxSize);
        baseEspresso.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        baseEspresso.setAlignmentX(Component.CENTER_ALIGNMENT);
        baseEspresso.setBackground(peachyOrange);
        baseEspresso.setForeground(darkBrown);
        baseEspresso.setOpaque(false);
        JPanel baseEspressoWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER));
        baseEspressoWrapper.setOpaque(false);
        baseEspressoWrapper.add(baseEspresso);
        baseEspressoPanel.add(baseEspressoWrapper);

        baseRatio = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
        baseRatio.setMaximumSize(comboBoxSize);

        baseEspresso.addActionListener(e -> {
            if (baseEspresso.getSelectedItem().equals("Custom"))
                baseEspressoPanel.add(baseRatio);
            else
                baseEspressoPanel.remove(baseRatio);
        });

        specialMenuPanel = new JPanel();
        specialMenuPanel.setLayout(new BoxLayout(specialMenuPanel, BoxLayout.Y_AXIS));
        specialMenuPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
        specialMenuPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        specialMenuPanel.setOpaque(false);

        addOnSyrups = new JComboBox<>(addOns);
        addOnSyrups.setMaximumSize(comboBoxSize);
        addOnSyrups.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        addOnSyrups.setAlignmentX(Component.CENTER_ALIGNMENT);
        addOnSyrups.setBackground(peachyOrange);
        addOnSyrups.setForeground(darkBrown);
        addOnSyrups.setOpaque(false);
        JPanel addOnSyrupPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        addOnSyrupPanel.setOpaque(false);
        addOnSyrupPanel.add(addOnSyrups);

        addOnEspressoPanel = new JPanel();
        addOnEspressoPanel.setLayout(new BoxLayout(addOnEspressoPanel, BoxLayout.X_AXIS));
        addOnEspressoPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        addOnEspressoPanel.setOpaque(false);

        addOnEspresso = new JComboBox<>(addOnEspressos);
        addOnEspresso.setMaximumSize(comboBoxSize);
        addOnEspresso.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        addOnEspresso.setAlignmentX(Component.CENTER_ALIGNMENT);
        addOnEspresso.setBackground(peachyOrange);
        addOnEspresso.setForeground(darkBrown);
        addOnEspresso.setOpaque(false);
        JPanel addOnEspressoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        addOnEspressoPanel.setOpaque(false);
        addOnEspressoPanel.add(addOnEspresso);

        addOnRatio = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
        addOnRatio.setMaximumSize(comboBoxSize);
        fullMenuPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        baseDrinkPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        baseEspressoPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        specialMenuPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        addOnEspressoPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        addOnEspresso.addActionListener(e -> {
            if (addOnEspresso.getSelectedItem().equals("Custom"))
                addOnEspressoPanel.add(addOnRatio);
            else
                addOnEspressoPanel.remove(addOnRatio);
        });

        // Brew Strength Label (Centered)
        JLabel brewLabel = new JLabel("Select Brew Strength", SwingConstants.CENTER);
        brewLabel.setForeground(darkBrown);
        JPanel brewLabelWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER));
        brewLabelWrapper.setOpaque(false);
        brewLabelWrapper.add(brewLabel);

        // Syrup Add-On Label (Centered)
        JLabel syrupLabel = new JLabel("Select Syrup Add-On (Optional)", SwingConstants.CENTER);
        syrupLabel.setForeground(darkBrown);
        JPanel syrupLabelWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER));
        syrupLabelWrapper.setOpaque(false);
        syrupLabelWrapper.add(syrupLabel);

        // Extra Shot Label (Centered)
        JLabel shotLabel = new JLabel("Select Extra Shot (Optional)", SwingConstants.CENTER);
        shotLabel.setForeground(darkBrown);
        JPanel shotLabelWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER));
        shotLabelWrapper.setOpaque(false);
        shotLabelWrapper.add(shotLabel);

        // Add to specialMenuPanel in vertical layout
        specialMenuPanel.add(brewLabelWrapper);
        specialMenuPanel.add(Box.createRigidArea(vertical));
        specialMenuPanel.add(baseEspressoPanel);
        specialMenuPanel.add(Box.createRigidArea(vertical));
        specialMenuPanel.add(syrupLabelWrapper);
        specialMenuPanel.add(Box.createRigidArea(vertical));
        specialMenuPanel.add(addOnSyrupPanel);
        specialMenuPanel.add(Box.createRigidArea(vertical));
        specialMenuPanel.add(shotLabelWrapper);
        specialMenuPanel.add(Box.createRigidArea(vertical));
        specialMenuPanel.add(addOnEspressoPanel);
        specialMenuPanel.add(Box.createRigidArea(vertical));

        fullMenuPanel.add(baseDrinkPanel);
        fullMenuPanel.add(Box.createRigidArea(vertical));

        interactionsMenuButton = new JButton("Back");
        interactionsMenuButton.setFont(new Font("Arial", Font.BOLD, 20));
        interactionsMenuButton.setBackground(peachyOrange);
        interactionsMenuButton.setForeground(darkBrown);

        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 20));
        submitButton.setBackground(peachyOrange);
        submitButton.setForeground(darkBrown);

        this.add(title);
        this.add(Box.createRigidArea(new Dimension(0, 30))); // spacing

        // Wrap "Select Drink and Size" label
        JLabel label = new JLabel("Select Drink and Size");
        label.setForeground(darkBrown);
        JPanel labelWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER));
        labelWrapper.setOpaque(false);
        labelWrapper.add(label);

        // Wrap fullMenuPanel
        JPanel menuWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER));
        menuWrapper.setOpaque(false);
        menuWrapper.add(fullMenuPanel);

        // Wrap submit button
        JPanel submitWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER));
        submitWrapper.setOpaque(false);
        submitWrapper.add(submitButton);

        // Wrap back button
        JPanel backWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER));
        backWrapper.setOpaque(false);
        backWrapper.add(interactionsMenuButton);

        this.add(labelWrapper);
        this.add(Box.createRigidArea(vertical));
        this.add(menuWrapper);
        this.add(Box.createRigidArea(vertical));
        this.add(submitWrapper);
        this.add(Box.createRigidArea(vertical));
        this.add(backWrapper);

    }

    public void setMenu(String truckType) {
        fullMenuPanel.remove(specialMenuPanel);

        if (truckType.equals("Special")) {
            fullMenuPanel.add(specialMenuPanel);
        }

        fullMenuPanel.revalidate();
        fullMenuPanel.repaint();
    }

    /**
     * Returns the selected drink name from the drink combo box.
     *
     * @return the name of the selected drink
     */
    public String getDrinkName() {
        return (String) drinkComboBox.getSelectedItem();
    }

    /**
     * Returns the selected cup size from the size combo box.
     *
     * @return the name of the selected cup size
     */
    public String getCupName() {
        return (String) sizeComboBox.getSelectedItem();
    }

    /**
     * Returns the selected syrup add-on from the syrup combo box.
     *
     * @return the name of the selected syrup add-on
     */
    public String getAddOn() {
        return (String) addOnSyrups.getSelectedItem();
    }

    /**
     * Returns the selected base espresso shot strength.
     *
     * @return the name of the selected base espresso strength
     */
    public String getBaseShot() {
        return (String) baseEspresso.getSelectedItem();
    }

    /**
     * Returns the custom ratio value for the base espresso shot.
     *
     * @return the base espresso ratio value
     */
    public int getBaseRatio() {
        return (Integer) baseRatio.getValue();
    }

    /**
     * Returns the selected additional espresso shot strength.
     *
     * @return the name of the selected additional espresso shot
     */
    public String getAddOnShot() {
        return (String) addOnEspresso.getSelectedItem();
    }

    /**
     * Returns the custom ratio value for the additional espresso shot.
     *
     * @return the add-on espresso ratio value
     */
    public int getAddOnRatio() {
        return (Integer) addOnRatio.getValue();
    }

    /**
     * Registers a listener to the submit button.
     *
     * @param listener the ActionListener to be triggered when the submit button is clicked
     */
    public void addSubmitButtonListener(ActionListener listener) {
        submitButton.addActionListener(listener);
    }

    /**
     * Registers a listener to the back/interactions menu button.
     *
     * @param listener the ActionListener to be triggered when the interactions menu button is clicked
     */
    public void addInteractionsMenuListener(ActionListener listener) {
        interactionsMenuButton.addActionListener(listener);
    }


}
