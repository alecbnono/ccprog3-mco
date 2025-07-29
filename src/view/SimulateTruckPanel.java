package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

/**
 * SimulateTruckPanel
 */
public class SimulateTruckPanel extends JPanel {

    private JPanel fullMenuPanel;

    private final String[] drinks = { "Americano", "Latte", "Cappuccino" };
    private final String[] sizes = { "Small", "Medium", "Large" };
    private JComboBox<String> drinkComboBox;
    private JComboBox<String> sizeComboBox;
    private JPanel baseDrinkPanel;

    private final String[] baseEspressos = { "Light", "Standard", "Strong", "Custom" };
    private JComboBox<String> baseEspresso;
    private JPanel baseEspressoPanel;
    private JSpinner baseRatio;

    private final String[] addOns = { "", "Hazelnut", "Vanilla", "Chocolate", "Almond", "Sucrose" };
    private JComboBox<String> addOnSyrups;

    private final String[] addOnEspressos = { "", "Light", "Standard", "Strong", "Custom" };
    private JComboBox<String> addOnEspresso;
    private JPanel addOnEspressoPanel;
    private JSpinner addOnRatio;

    private JPanel specialMenuPanel;

    private JButton interactionsMenuButton;
    private JButton submitButton;
    private JLabel title;

    public SimulateTruckPanel() {

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setAlignmentY(Component.CENTER_ALIGNMENT);
        this.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60)); // padding
        this.setOpaque(false);

        title = new JLabel("Simulate Drink Sale");
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        fullMenuPanel = new JPanel();
        fullMenuPanel.setLayout(new BoxLayout(fullMenuPanel, BoxLayout.Y_AXIS));
        fullMenuPanel.setAlignmentY(Component.CENTER_ALIGNMENT);

        baseDrinkPanel = new JPanel();
        baseDrinkPanel.setLayout(new BoxLayout(baseDrinkPanel, BoxLayout.X_AXIS));
        baseDrinkPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        drinkComboBox = new JComboBox<>(drinks);
        drinkComboBox.setMaximumSize(new Dimension(150, 40));
        sizeComboBox = new JComboBox<>(sizes);
        sizeComboBox.setMaximumSize(new Dimension(150, 40));

        baseDrinkPanel.add(drinkComboBox);
        baseDrinkPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        baseDrinkPanel.add(sizeComboBox);

        baseEspressoPanel = new JPanel();
        baseEspressoPanel.setLayout(new BoxLayout(baseEspressoPanel, BoxLayout.Y_AXIS));
        baseEspressoPanel.setAlignmentY(Component.CENTER_ALIGNMENT);

        baseEspresso = new JComboBox<String>(baseEspressos);
        baseEspresso.setMaximumSize(new Dimension(150, 40));
        baseEspresso.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        baseEspressoPanel.add(baseEspresso);

        baseRatio = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
        baseRatio.setMaximumSize(new Dimension(150, 40));

        baseEspresso.addActionListener(e -> {
            if (baseEspresso.getSelectedItem().equals("Custom"))
                baseEspressoPanel.add(baseRatio);
            else
                baseEspressoPanel.remove(baseRatio);
        });

        specialMenuPanel = new JPanel();
        specialMenuPanel.setLayout(new BoxLayout(specialMenuPanel, BoxLayout.Y_AXIS));
        specialMenuPanel.setAlignmentY(Component.CENTER_ALIGNMENT);

        addOnSyrups = new JComboBox<>(addOns);
        addOnSyrups.setMaximumSize(new Dimension(150, 40));
        addOnSyrups.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        addOnEspressoPanel = new JPanel();
        addOnEspressoPanel.setLayout(new BoxLayout(addOnEspressoPanel, BoxLayout.X_AXIS));
        addOnEspressoPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        addOnEspresso = new JComboBox<>(addOnEspressos);
        addOnEspresso.setMaximumSize(new Dimension(150, 40));
        addOnEspresso.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        addOnEspressoPanel.add(addOnEspresso);

        addOnRatio = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
        addOnRatio.setMaximumSize(new Dimension(150, 40));

        addOnEspresso.addActionListener(e -> {
            if (addOnEspresso.getSelectedItem().equals("Custom"))
                addOnEspressoPanel.add(addOnRatio);
            else
                addOnEspressoPanel.remove(addOnRatio);
        });

        specialMenuPanel.add(new JLabel("Select Brew Strength"));
        specialMenuPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        specialMenuPanel.add(baseEspressoPanel);
        specialMenuPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        specialMenuPanel.add(new JLabel("Select Syrup Add-On (Optional)"));
        specialMenuPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        specialMenuPanel.add(addOnSyrups);
        specialMenuPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        specialMenuPanel.add(new JLabel("Select Extra Shot (Optional)"));
        specialMenuPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        specialMenuPanel.add(addOnEspressoPanel);
        specialMenuPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        fullMenuPanel.add(baseDrinkPanel);
        fullMenuPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        interactionsMenuButton = new JButton("Back");
        submitButton = new JButton("Submit");
        interactionsMenuButton.setFont(new Font("Arial", Font.BOLD, 20));
        submitButton.setFont(new Font("Arial", Font.BOLD, 20));

        this.add(title);
        this.add(Box.createRigidArea(new Dimension(0, 30))); // spacing
        this.add(new JLabel("Select Drink and Size"));
        this.add(Box.createRigidArea(new Dimension(0, 15)));

        this.add(fullMenuPanel);
        this.add(Box.createRigidArea(new Dimension(0, 15)));

        this.add(submitButton);
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(interactionsMenuButton);
    }

    public void setMenu(String truckType) {
        fullMenuPanel.remove(specialMenuPanel);

        if (truckType.equals("Special")) {
            fullMenuPanel.add(specialMenuPanel);
        }

        fullMenuPanel.revalidate();
        fullMenuPanel.repaint();
    }

    public void addSubmitButtonListener(ActionListener listener) {
        submitButton.addActionListener(listener);
    }

    public void addInteractionsMenuListener(ActionListener listener) {
        interactionsMenuButton.addActionListener(listener);
    }

}
