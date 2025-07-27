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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 * SetBinsPanel
 */
public class SetBinsPanel extends JPanel {

    private JButton submitButton;
    private ArrayList<JPanel> regularStorageBins;
    private ArrayList<JPanel> specialStorageBins;
    private JPanel regularMenu;
    private JPanel specialMenu;
    private JPanel allMenus;
    private ArrayList<JComboBox<String>> binTypeSelectors = new ArrayList<>();
    private ArrayList<JSpinner> binAmountFields = new ArrayList<>();
    private final String[] regularOptions = { "", "Small Cup", "Medium Cup", "Large Cup", "Coffee Beans", "Milk",
            "Water" };
    private final String[] specialOptions = { "", "Hazelnut", "Vanilla", "Chocolate", "Almond", "Sucrose" };
    private JLabel nameLabel;
    private JLabel typeLabel;
    private JLabel title;

    public SetBinsPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60)); // padding

        title = new JLabel("Set Truck Inventory");
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        submitButton = new JButton("Set Truck Inventory");

        submitButton.setFont(new Font("Arial", Font.BOLD, 20));

        Dimension buttonSize = new Dimension(350, 100);
        submitButton.setMaximumSize(buttonSize);
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        nameLabel = new JLabel("");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        typeLabel = new JLabel("");
        typeLabel.setFont(new Font("Arial", Font.BOLD, 20));

        binTypeSelectors = new ArrayList<>();
        binAmountFields = new ArrayList<>();

        regularStorageBins = new ArrayList<JPanel>();
        regularMenu = new JPanel();
        regularMenu.setLayout(new BoxLayout(regularMenu, BoxLayout.Y_AXIS));
        specialMenu = new JPanel();
        specialMenu.setLayout(new BoxLayout(specialMenu, BoxLayout.Y_AXIS));
        specialMenu.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));

        allMenus = new JPanel();
        allMenus.setLayout(new BoxLayout(allMenus, BoxLayout.X_AXIS));
        allMenus.setMaximumSize(new Dimension(1000, 720));

        for (int i = 0; i < 8; i++) {
            JPanel panel = new JPanel();
            regularStorageBins.add(i, panel);
            regularStorageBins.get(i).setLayout(new BoxLayout(regularStorageBins.get(i), BoxLayout.X_AXIS));
            JLabel label = new JLabel("Box #" + (i + 1));
            label.setFont(new Font("Arial", Font.BOLD, 20));
            regularStorageBins.get(i).add(label);
            regularStorageBins.get(i).add(Box.createRigidArea(new Dimension(30, 0))); // spacing

            JComboBox<String> comboBox = new JComboBox<String>(regularOptions);
            comboBox.setSelectedIndex(0);
            comboBox.setFont(new Font("Arial", Font.BOLD, 20));
            comboBox.setMaximumSize(new Dimension(150, 40));
            binTypeSelectors.add(comboBox);
            regularStorageBins.get(i).add(comboBox);
            regularStorageBins.get(i).add(Box.createRigidArea(new Dimension(30, 0))); // spacing

            SpinnerNumberModel spinnerModel = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1); // (initial, min, max,
                                                                                                  // step)
            JSpinner spinner = new JSpinner(spinnerModel);
            spinner.setFont(new Font("Arial", Font.BOLD, 20));
            spinner.setPreferredSize(new Dimension(150, 40));
            spinner.setMaximumSize(new Dimension(160, 40));
            binAmountFields.add(spinner);
            regularStorageBins.get(i).add(spinner);

            regularMenu.add(panel);
        }

        specialStorageBins = new ArrayList<JPanel>();

        for (int i = 0; i < 2; i++) {
            JPanel panel = new JPanel();
            specialStorageBins.add(i, panel);
            specialStorageBins.get(i).setLayout(new BoxLayout(specialStorageBins.get(i), BoxLayout.X_AXIS));
            JLabel label = new JLabel("Special Box #" + (i + 1));
            label.setFont(new Font("Arial", Font.BOLD, 20));
            specialStorageBins.get(i).add(label);
            specialStorageBins.get(i).add(Box.createRigidArea(new Dimension(30, 0))); // spacing

            JComboBox<String> comboBox = new JComboBox<String>(specialOptions);
            comboBox.setSelectedIndex(0);
            comboBox.setFont(new Font("Arial", Font.BOLD, 20));
            comboBox.setMaximumSize(new Dimension(150, 40));
            binTypeSelectors.add(comboBox);
            specialStorageBins.get(i).add(comboBox);
            specialStorageBins.get(i).add(Box.createRigidArea(new Dimension(30, 0))); // spacing

            SpinnerNumberModel spinnerModel = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1); // (initial, min, max,
                                                                                                  // step)
            JSpinner spinner = new JSpinner(spinnerModel);
            spinner.setFont(new Font("Arial", Font.BOLD, 20));
            spinner.setPreferredSize(new Dimension(150, 40));
            spinner.setMaximumSize(new Dimension(160, 40));
            binAmountFields.add(spinner);
            specialStorageBins.get(i).add(spinner);

            specialMenu.add(panel);
        }

        allMenus.add(regularMenu);

        this.add(title);
        this.add(Box.createRigidArea(new Dimension(0, 30))); // spacing
        this.add(nameLabel);
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(typeLabel);
        this.add(Box.createRigidArea(new Dimension(0, 15)));

        this.add(allMenus);
        this.add(Box.createRigidArea(new Dimension(0, 15)));

        this.add(submitButton);
    }

    public ArrayList<JSpinner> getSpinners() {
        return binAmountFields;
    }

    public ArrayList<JComboBox<String>> getComboBoxes() {
        return binTypeSelectors;
    }

    public void setSelectedTruckText(String text) {
        nameLabel.setText(text);
    }

    public void setTruckTypeText(String text) {
        typeLabel.setText(text);
        allMenus.remove(specialMenu);

        if (text.equals("Special")) {
            allMenus.add(specialMenu);
        }

        allMenus.revalidate();
        allMenus.repaint();
    }

    public void addSetBinsListener(ActionListener listener) {
        submitButton.addActionListener(listener);
    }

}
