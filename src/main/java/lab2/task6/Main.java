package lab2.task6;

public class Main {
    public static void main(String[] args) {
        Paralelogram paralelogram = new Paralelogram(6, 7, 30);
        System.out.println("Aria paralelogramului: " + paralelogram.calculeazaArie());

        Romb romb = new Romb(6, 6, 60, 8, 10);
        System.out.println("Aria rombului: " + romb.calculeazaArie());

        Dreptunghi dreptunghi = new Dreptunghi(4, 8);
        System.out.println("Aria dreptunghiului: " + dreptunghi.calculeazaArie());

        Patrat patrat = new Patrat(5);
        System.out.println("Aria patratului: " + patrat.calculeazaArie());
    }
}
