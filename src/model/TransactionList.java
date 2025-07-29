package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionList {

    private ArrayList<Receipt> receipts;

    public TransactionList() {
        receipts = new ArrayList<>();
    }

    public void addReceipt(Receipt receipt) {
        receipts.add(receipt);
    }

    public void printAllTransactionsToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("ALL TRANSACTIONS\n");
            writer.write("-----------------------------------------------------------------------------\n");
            writer.write(String.format("%-20s %-15s %-15s %10s%n", "Time", "Location", "Drink Name", "Price"));
            writer.write("-----------------------------------------------------------------------------\n");

            for (Receipt r : receipts) {
                writer.write(String.format("%-20s %-15s %-15s %10.2f%n",
                        r.getTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                        r.getLocation(),
                        r.getProduct().getType(),
                        r.getPrice()));
            }

            writer.write("-----------------------------------------------------------------------------\n");
        } catch (IOException e) {
            System.err.println("Error writing all transactions to file: " + e.getMessage());
        }
    }

    public void printTransactionsByTruckToFile(String fileName) {
        Map<String, List<Receipt>> locationGroups = new HashMap<>();

        for (Receipt r : receipts) {
            locationGroups.putIfAbsent(r.getLocation(), new ArrayList<>());
            locationGroups.get(r.getLocation()).add(r);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String location : locationGroups.keySet()) {
                writer.write("TRANSACTIONS FOR TRUCK AT: " + location + "\n");
                writer.write("-----------------------------------------------------------------------------\n");
                writer.write(String.format("%-20s %-15s %-15s %10s%n", "Time", "Location", "Drink Name", "Price"));
                writer.write("-----------------------------------------------------------------------------\n");

                for (Receipt r : locationGroups.get(location)) {
                    writer.write(String.format("%-20s %-15s %-15s %10.2f%n",
                            r.getTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                            r.getLocation(),
                            r.getProduct().getType(),
                            r.getPrice()));
                }

                writer.write("-----------------------------------------------------------------------------\n\n");
            }
        } catch (IOException e) {
            System.err.println("Error writing transactions by truck to file: " + e.getMessage());
        }
    }
}
