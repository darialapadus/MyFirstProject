package lab8.task1;

import lab8.task1.calculatorResult.BooleanCalculationResult;
import lab8.task1.calculatorResult.CalculationResult;
import lab8.task1.calculatorResult.DoubleCalculationResult;
import lab8.task1.calculatorResult.IntegerCalculationResult;

import java.util.List;
import java.util.stream.Collectors;

public class SmarterCalculator {

    public static List<CalculationResult> calculate(String[] args) {
        return InputConverter.mapRequests(args)
                .stream()
                .map(SmarterCalculator::createCalculatorResponse)
                .collect(Collectors.toList());
    }

    private static CalculationResult createCalculatorResponse(CalculationRequest request) {
        return switch (request.getRequestType()) {
            case Boolean -> new BooleanCalculationResult(request);
            case Integer -> new IntegerCalculationResult(request);
            case Double -> new DoubleCalculationResult(request);
            default -> throw new IllegalArgumentException();
        };
    }
}
