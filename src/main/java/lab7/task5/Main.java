package lab7.task5;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Numarul total de numere: ");
        int totalNumbers = readInteger(scanner);

        List<Integer> numbers = IntStream.range(0, totalNumbers)
                .mapToObj(i -> {
                    System.out.print("Numarul " + (i + 1) + ": ");
                    return readInteger(scanner);
                })
                .collect(Collectors.toList());

        List<Operation> operations = Arrays.asList(
                num -> num * 2.0,
                num -> num + 1.0,
                num -> num != 0 ? (double) 1 / num : 0,
                num -> num * num,
                Math::sin
        );

        Random random = new Random();
        Operation operation = operations.get(random.nextInt(operations.size()));

        System.out.println("Rezultatele operatiei alese:");
        numbers.forEach(num -> System.out.println(operation.apply(num)));
    }

    private static Integer readInteger(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Introduceti un număr întreg!");
            scanner.next();
        }
        return scanner.nextInt();
    }

    @FunctionalInterface
    interface Operation {
        double apply(int num);
    }
}




