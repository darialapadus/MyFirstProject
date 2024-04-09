package lab6.task3;

import java.util.Random;
public class Transaction {
    private Client client;
    private double requiredAmount;
    private String paymentMethod;

    public Transaction(Client client, double requiredAmount) {
        this.client = client;
        this.requiredAmount = requiredAmount;
        this.paymentMethod = client.getPreferredPaymentMethod();
        if (this.paymentMethod == null) {
            this.paymentMethod = randomlySelectPaymentMethod();
        }
    }

    private String randomlySelectPaymentMethod() {
        String[] paymentMethods = {"Cash", "Bank Transfer", "Card"};
        Random random = new Random();
        return paymentMethods[random.nextInt(paymentMethods.length)];
    }

    public void execute() {
        if (client.hasSufficientFunds(requiredAmount)) {
            client.makePayment(requiredAmount);
            System.out.println("Transaction processed successfully for " + client.getName() +
                    " using payment method: " + paymentMethod);
        } else {
            System.out.println("Transaction failed for " + client.getName() +
                    " - insufficient funds for payment method: " + paymentMethod);
        }
    }

    @Override
    public String toString() {
        return "Transaction for " + client.getName() +
                " with amount " + requiredAmount +
                " using payment method: " + paymentMethod;
    }
}
