package lab4.task2;

import lab4.task2.calculatorResult.CalculationResult;
import lab4.task2.calculatorResult.InvalidOperationException;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        args = new String[]{
                "1", "+", "2",
                "2", "*", "5",
                "1", "+", "5.0",
                "1.0", "-", "2",
                "10.0", "/", "1",
        };
        List<CalculationResult> calculationResults =  SmarterCalculator.calculate(args);

        for (CalculationResult result : calculationResults) {
            CalculationRequest request = result.getRequest();
            try {
                System.out.println("Operation " + request + " has result " + result.computeResult());
            } catch (InvalidOperationException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
