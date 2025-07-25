package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

/**
 * SetBinsPanel
 */
public class SetBinsPanel extends JPanel {

    private JButton submitButton;
    private ArrayList<JPanel> storageBins;
    private ArrayList<JComboBox<String>> binTypeSelectors = new ArrayList<>();
    private ArrayList<JSpinner> binAmountFields = new ArrayList<>();
    private final String[] options = { "", "Small Cup", "Medium Cup", "Large Cup", "Coffee Beans", "Milk", "Water" };
    private JLabel nameLabel;
    private JLabel typeLabel;
    private JLabel title;

    public SetBinsPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60)); // padding

        title = new JLabel("Create Coffee Truck");
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        submitButton = new JButton("Create Coffee Truck");

        submitButton.setFont(new Font("Arial", Font.BOLD, 20));

        Dimension buttonSize = new Dimension(350, 100);
        submitButton.setMaximumSize(buttonSize);
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        nameLabel = new JLabel("");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        typeLabel = new JLabel("");
        typeLabel.setFont(new Font("Arial", Font.BOLD, 20));

        storageBins = new ArrayList<JPanel>();

        for (int i = 0; i < 8; i++) {
            storageBins.add(i, new JPanel());
            storageBins.get(i).setLayout(new BoxLayout(storageBins.get(i), BoxLayout.X_AXIS));
            JLabel label = new JLabel("Box #" + (i + 1));
            label.setFont(new Font("Arial", Font.BOLD, 20));
            storageBins.get(i).add(label);
            storageBins.get(i).add(Box.createRigidArea(new Dimension(30, 0))); // spacing

            JComboBox<String> comboBox = new JComboBox<String>(options);
            comboBox.setSelectedIndex(0);
            comboBox.setFont(new Font("Arial", Font.BOLD, 20));
            comboBox.setMaximumSize(new Dimension(350, 40));
            binTypeSelectors.add(comboBox);
            storageBins.get(i).add(comboBox);
            storageBins.get(i).add(Box.createRigidArea(new Dimension(30, 0))); // spacing

            SpinnerNumberModel spinnerModel = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1); // (initial, min, max,
                                                                                                  // step)
            JSpinner spinner = new JSpinner(spinnerModel);
            spinner.setFont(new Font("Arial", Font.BOLD, 20));
            spinner.setMaximumSize(new Dimension(350, 40));
            binAmountFields.add(spinner);
            storageBins.get(i).add(spinner);

            comboBox.addActionListener(e -> {
                String selected = (String) comboBox.getSelectedItem();

                int max = getMax(selected);

                SpinnerNumberModel model = (SpinnerNumberModel) spinner.getModel();

                int current = (int) model.getValue();
                model.setMaximum(max);
                if (current > max) {
                    model.setValue(max); // clamp
                }
            });

        }

        submitButton.addActionListener(e -> {
            for (JSpinner spinner : binAmountFields) {

                SpinnerNumberModel model = (SpinnerNumberModel) spinner.getModel();
                int value = (int) model.getValue();
                int min = ((Number) model.getMinimum()).intValue();
                int max = ((Number) model.getMaximum()).intValue();

                if (value < min) {
                    model.setValue(min); // Clamp underflow
                } else if (value > max) {
                    model.setValue(max); // Clamp overflow
                }
            }

        });

        this.add(title);
        this.add(Box.createRigidArea(new Dimension(0, 30))); // spacing
        this.add(nameLabel);
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(typeLabel);
        this.add(Box.createRigidArea(new Dimension(0, 15)));

        for (int i = 0; i < 8; i++) {
            this.add(storageBins.get(i));
            this.add(Box.createRigidArea(new Dimension(0, 15)));
        }

        this.add(submitButton);
    }

    private int getMax(String item) {

        int max;
        switch (item) {
            case "Small Cup":
                max = 80;
                break;
            case "Medium Cup":
                max = 64;
                break;
            case "Large Cup":
                max = 40;
                break;
            case "Coffee Beans":
                max = 1008;
                break;
            case "Milk":
            case "Water":
                max = 640;
                break;
            default:
                max = 1008;
                break;
        }
        return max;
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
    }

    public void addSetBinsListener(ActionListener listener) {
        submitButton.addActionListener(listener);
    }

}
