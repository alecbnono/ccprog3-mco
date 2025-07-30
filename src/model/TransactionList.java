package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.swing.table.DefaultTableModel;

/**
 * TransactionList
 */
public class TransactionList {

    private ArrayList<Receipt> receipts;

    public TransactionList() {
        receipts = new ArrayList<>();
    }

    public void addReceipt(Receipt receipt) {
        receipts.add(receipt);
    }

    /**
     * Builds a DefaultTableModel containing all receipts
     */
    public DefaultTableModel buildAllTransactionsTableModel() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Time");
        model.addColumn("Location");
        model.addColumn("Drink");
        model.addColumn("Price");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        for (Receipt receipt : receipts) {
            model.addRow(new Object[] {
                    receipt.getTime().format(formatter),
                    receipt.getLocation(),
                    receipt.getProduct(),
                    String.format("₱%.2f", receipt.getPrice())
            });
        }

        return model;
    }

    /**
     * Builds a map of DefaultTableModels grouped by truck location
     */
    public Map<String, DefaultTableModel> buildGroupedTransactionsTableModels() {
        Map<String, DefaultTableModel> models = new HashMap<>();
        Map<String, List<Receipt>> grouped = new HashMap<>();

        for (Receipt receipt : receipts) {
            grouped.putIfAbsent(receipt.getLocation(), new ArrayList<>());
            grouped.get(receipt.getLocation()).add(receipt);
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        for (String location : grouped.keySet()) {
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Time");
            model.addColumn("Location");
            model.addColumn("Drink");
            model.addColumn("Price");

            for (Receipt receipt : grouped.get(location)) {
                model.addRow(new Object[] {
                        receipt.getTime().format(formatter),
                        receipt.getLocation(),
                        receipt.getProduct(),
                        String.format("₱%.2f", receipt.getPrice())
                });
            }

            models.put(location, model);
        }

        return models;
    }

    /**
     * Saves any DefaultTableModel to a .txt file
     */
    public void saveTableModelToTxt(DefaultTableModel model, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // Write column names
            for (int col = 0; col < model.getColumnCount(); col++) {
                writer.write(String.format("%-20s", model.getColumnName(col)));
            }
            writer.write("\n");
            writer.write("--------------------------------------------------------------------------------\n");

            // Write rows
            for (int row = 0; row < model.getRowCount(); row++) {
                for (int col = 0; col < model.getColumnCount(); col++) {
                    writer.write(String.format("%-20s", model.getValueAt(row, col)));
                }
                writer.write("\n");
            }

            writer.write("--------------------------------------------------------------------------------\n");

        } catch (IOException e) {
            System.err.println("Failed to save table model: " + e.getMessage());
        }
    }

    /**
     * Helper method to save both all transactions and grouped tables
     */
    public void saveAllTablesToFiles() {
        // Save all transactions
        saveTableModelToTxt(buildAllTransactionsTableModel(), "all_transactions.txt");

        // Save per-location grouped tables
        Map<String, DefaultTableModel> groupedModels = buildGroupedTransactionsTableModels();
        for (Map.Entry<String, DefaultTableModel> entry : groupedModels.entrySet()) {
            String location = entry.getKey().replaceAll("\\s+", "_").toLowerCase();
            saveTableModelToTxt(entry.getValue(), "transactions_" + location + ".txt");
        }
    }

    public String getAggregateSales() {

        StringBuilder output = new StringBuilder();

        output.append(String.format("Combined Transaction Summary:\n"));

        int americanoCount = 0;
        double americanoTotal = 0;
        int latteCount = 0;
        double latteTotal = 0;
        int cappuccinoCount = 0;
        double cappuccinoTotal = 0;

        int addOnCount = 0;
        double addOnTotal = 0;

        for (Receipt receipt : receipts) {
            if (receipt.getProduct().equals("Americano")) {
                americanoCount++;
                americanoTotal += receipt.getPrice();
            } else if (receipt.getProduct().equals("Latte")) {
                latteCount++;
                latteTotal += receipt.getPrice();
            } else if (receipt.getProduct().equals("Cappuccino")) {
                cappuccinoCount++;
                cappuccinoTotal += receipt.getPrice();
            } else {
                addOnCount++;
                addOnTotal += receipt.getPrice();
            }
        }

        output.append(String.format("- Americano: %d sold ₱%.2f Total\n", americanoCount, americanoTotal));
        output.append(String.format("- Latte: %d sold ₱%.2f Total\n", latteCount, latteTotal));
        output.append(String.format("- Cappuccino: %d sold ₱%.2f Total\n", cappuccinoCount, cappuccinoTotal));
        output.append(String.format("- Add-Ons: %d sold ₱%.2f Total\n", addOnCount, addOnTotal));
        return output.toString();
    }
}
