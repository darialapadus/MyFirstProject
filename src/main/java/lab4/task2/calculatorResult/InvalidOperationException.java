package lab4.task2.calculatorResult;

import lab4.task2.CalculatorException;

public class InvalidOperationException extends CalculatorException {
    public InvalidOperationException(String message) {
        super(message);
    }
}
