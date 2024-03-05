package lab2.task7;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] input = {"1 + 2", "2 * 5", "1.0 + 5.0", "1.0 - 2", "10.0 / 1"};

        List<CalculatorResult> results = SmarterCalculator.calculate(input);

        for (CalculatorResult result : results) {
            CalculatorRequest request = result.getRequest();
            Object computationResult = result.computeResult();
            System.out.println("Operation " + request + " has result " + computationResult);
        }
    }
}
