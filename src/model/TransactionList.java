package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.swing.table.DefaultTableModel;

/**
 * Manages a collection of transaction receipts and provides
 * utilities for reporting and exporting transaction data.
 */
public class TransactionList {

    private ArrayList<Receipt> receipts;

    /**
     * Constructs an empty TransactionList.
     */
    public TransactionList() {
        receipts = new ArrayList<>();
    }

    /**
     * Adds a receipt to the transaction list.
     *
     * @param receipt the receipt to add
     */
    public void addReceipt(Receipt receipt) {
        receipts.add(receipt);
    }

    /**
     * Builds a DefaultTableModel containing all recorded receipts.
     *
     * @return a table model of all transactions
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
     * Builds a map of DefaultTableModels grouped by truck location.
     *
     * @return a map with location names as keys and corresponding transaction
     *         tables as values
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
     * Saves the given DefaultTableModel to a text file with aligned columns.
     *
     * @param model    the table model to save
     * @param filename the file path to save to
     */
    public void saveTableModelToTxt(DefaultTableModel model, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // Write column headers
            for (int col = 0; col < model.getColumnCount(); col++) {
                writer.write(String.format("%-20s", model.getColumnName(col)));
            }
            writer.write("\n");
            writer.write("--------------------------------------------------------------------------------\n");

            // Write table rows
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
     * Saves both the full transaction list and the per-location grouped tables to
     * text files.
     * The output files are named:
     * - all_transactions.txt
     * - transactions_{location}.txt for each truck location
     */
    public void saveAllTablesToFiles() {
        // Save all transactions
        saveTableModelToTxt(buildAllTransactionsTableModel(), "all_transactions.txt");

        // Save grouped tables per location
        Map<String, DefaultTableModel> groupedModels = buildGroupedTransactionsTableModels();
        for (Map.Entry<String, DefaultTableModel> entry : groupedModels.entrySet()) {
            String location = entry.getKey().replaceAll("\\s+", "_").toLowerCase();
            saveTableModelToTxt(entry.getValue(), "transactions_" + location + ".txt");
        }
    }

    /**
     * Generates a textual summary of all drinks and add-ons sold across all
     * transactions.
     *
     * @return a formatted string summarizing sales count and total revenue per
     *         category
     */
    public String getAggregateSales() {

        StringBuilder output = new StringBuilder();
        output.append("Combined Transaction Summary:\n");

        int americanoCount = 0;
        double americanoTotal = 0;
        int latteCount = 0;
        double latteTotal = 0;
        int cappuccinoCount = 0;
        double cappuccinoTotal = 0;
        int addOnCount = 0;
        double addOnTotal = 0;

        for (Receipt receipt : receipts) {
            String productName = receipt.getProduct().toString();

            if (productName.equals("Americano")) {
                americanoCount++;
                americanoTotal += receipt.getPrice();
            } else if (productName.equals("Latte")) {
                latteCount++;
                latteTotal += receipt.getPrice();
            } else if (productName.equals("Cappuccino")) {
                cappuccinoCount++;
                cappuccinoTotal += receipt.getPrice();
            } else {
                addOnCount++;
                addOnTotal += receipt.getPrice();
            }
        }

        double grandTotal = americanoTotal + latteTotal + cappuccinoTotal + addOnTotal;
        int grandCount = americanoCount + latteCount + cappuccinoCount + addOnCount;

        output.append(String.format("- %-12s %5d sold ₱%5.2f Total\n", "Americano:", americanoCount, americanoTotal));
        output.append(String.format("- %-12s %5d sold ₱%5.2f Total\n", "Latte:", latteCount, latteTotal));
        output.append(
                String.format("- %-12s %5d sold ₱%5.2f Total\n", "Cappuccino:", cappuccinoCount, cappuccinoTotal));
        output.append(String.format("- %-12s %5d sold ₱%5.2f Total\n", "Add-Ons:", addOnCount, addOnTotal));
        output.append(String.format("- %-12s %5d sold ₱%5.2f Total\n", "Grand Total:", grandCount, grandTotal));


        return output.toString();
    }
}
