package lab6.task3;

public class Main {
    public static void main(String[] args) {
        Shop s1 = new Shop("Magazin");
        Client c1 = new Client("Daria", 156.4, "Cash");
        Client c2 = new Client("Ada", 184.2, "Card");
        Client c4 = new Client("Patrisia", 500.3, "Bank Transfer");
        s1.makeTransaction(10.2, c1);
        s1.makeTransaction(5.3, c2);
        s1.makeTransaction(495.2, c1);
        s1.makeTransaction(300.0, c4);
        s1.showTransactions();
    }
}
