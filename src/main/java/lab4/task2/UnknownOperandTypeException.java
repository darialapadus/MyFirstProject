package lab4.task2;

public class UnknownOperandTypeException extends CalculatorException {
    public UnknownOperandTypeException() {
        super("Unknown operand type");
    }
}
