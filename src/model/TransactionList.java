package model;

import java.util.ArrayList;

/**
 * TransactionList
 */
public class TransactionList {

    private ArrayList<Receipt> receipts;

    public TransactionList() {
        receipts = new ArrayList<Receipt>();
    }

    public void addReceipt(Receipt receipt) {
        receipts.add(receipt);
    }
}
