package lab6.task3;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Transaction> transactions;
    private String shopName;

    public Shop(String shopName) {
        this.shopName = shopName;
        this.transactions = new ArrayList<>();
    }

    public void makeTransaction(double amount, Client client) {
        Transaction transaction = new Transaction(client, amount);
        transactions.add(transaction);
    }

    public void processTransactions() {
        for (Transaction transaction : transactions) {
            transaction.execute();
        }
        transactions.clear();
    }

    public void showTransactions() {
        for (Transaction transaction : transactions) {
            System.out.println(transaction.toString());
        }
    }
}