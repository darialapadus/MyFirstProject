package lab8.task1;

import lab8.task1.calculatorResult.PrintingCalculationResult;

public class Main {
    public static void main(String[] args) {
        args = new String[]{
                "1", "+", "2",
                "2", "*", "5",
                "1", "+", "5.0",
                "1.0", "-", "2",
                "10.0", "/", "1",
        };

        runSmarterCalculator(args);
    }

    private static void runSmarterCalculator(String[] args) {
        SmarterCalculator
                .calculate(args)
                .stream()
                .map(PrintingCalculationResult::new)
                .forEach(PrintingCalculationResult::computeResult);
    }
}
