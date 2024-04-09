package lab6.task3;

public class Client {
    private String name;
    private double availableFunds;
    private String preferredPaymentMethod;

    public Client(String name, double availableFunds, String preferredPaymentMethod) {
        this.name = name;
        this.availableFunds = availableFunds;
        this.preferredPaymentMethod = preferredPaymentMethod;
    }

    public boolean hasSufficientFunds(double amount) {
        return availableFunds >= amount;
    }

    public void makePayment(double amount) {
        availableFunds -= amount;
    }

    public String getName() {
        return name;
    }

    public String getPreferredPaymentMethod() {
        return preferredPaymentMethod;
    }
}
