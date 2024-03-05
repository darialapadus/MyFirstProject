package lab2.task7;

import java.util.ArrayList;
import java.util.List;

public class SmarterCalculator {
    public static List<CalculatorResult> calculate(String[] args) {
        List<CalculatorRequest> requests = InputConverter.mapRequests(args);
        List<CalculatorResult> results = new ArrayList<>();

        for (CalculatorRequest request : requests) {
            switch (request.getRequestType()) {
                case INTEGER:
                    results.add(new IntegerCalculatorResult(request));
                    break;
                case DOUBLE:
                    results.add(new DoubleCalculatorResult(request));
                    break;
                case BOOLEAN:
                    results.add(new BooleanCalculatorResult(request));
                    break;
                default:
                    break;
            }
        }

        return results;
    }
}

class CalculatorRequest {
    private Object leftOperand;
    private Object rightOperand;
    private String operation;

    public CalculatorRequest(Object leftOperand, Object rightOperand, String operation) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.operation = operation;
    }

    public RequestType getRequestType() {
        if (leftOperand instanceof Integer || rightOperand instanceof Integer ||
                operation.equals("+") || operation.equals("-") ||
                operation.equals("*") || operation.equals("/")) {
            return RequestType.INTEGER;
        } else if (leftOperand instanceof Double || rightOperand instanceof Double) {
            return RequestType.DOUBLE;
        } else if (leftOperand instanceof Boolean && rightOperand instanceof Boolean &&
                (operation.equals("&") || operation.equals("|"))) {
            return RequestType.BOOLEAN;
        } else {
            return RequestType.UNKNOWN;
        }
    }

    public Object getLeftOperand() {
        return leftOperand;
    }

    public Object getRightOperand() {
        return rightOperand;
    }

    public String getOperation() {
        return operation;
    }

    @Override
    public String toString() {
        return leftOperand.toString() + " " + operation + " " + rightOperand.toString();
    }
}

class InputConverter {
    public static List<CalculatorRequest> mapRequests(String[] args) {
        List<CalculatorRequest> requests = new ArrayList<>();

        for (String arg : args) {
            String[] tokens = arg.split(" ");
            if (tokens.length == 3) {
                try {
                    Object leftOperand;
                    Object rightOperand;

                    if (tokens[0].equalsIgnoreCase("true") || tokens[0].equalsIgnoreCase("false")) {
                        leftOperand = Boolean.parseBoolean(tokens[0]);
                    } else if (tokens[0].contains(".")) {
                        leftOperand = Double.parseDouble(tokens[0]);
                    } else {
                        leftOperand = Integer.parseInt(tokens[0]);
                    }

                    if (tokens[2].equalsIgnoreCase("true") || tokens[2].equalsIgnoreCase("false")) {
                        rightOperand = Boolean.parseBoolean(tokens[2]);
                    } else if (tokens[2].contains(".")) {
                        rightOperand = Double.parseDouble(tokens[2]);
                    } else {
                        rightOperand = Integer.parseInt(tokens[2]);
                    }

                    requests.add(new CalculatorRequest(leftOperand, rightOperand, tokens[1]));
                } catch (NumberFormatException ignored) {
                }
            }
        }

        return requests;
    }
}

abstract class CalculatorResult {
    protected CalculatorRequest calculatorRequest;

    protected CalculatorResult(CalculatorRequest calculatorRequest) {
        this.calculatorRequest = calculatorRequest;
    }

    public CalculatorRequest getRequest() {
        return calculatorRequest;
    }

    public abstract Object computeResult();
}

class IntegerCalculatorResult extends CalculatorResult {
    public IntegerCalculatorResult(CalculatorRequest calculatorRequest) {
        super(calculatorRequest);
    }

    @Override
    public Integer computeResult() {
        Object leftOperandObj = calculatorRequest.getLeftOperand();
        Object rightOperandObj = calculatorRequest.getRightOperand();

        int left;
        int right;

        if (leftOperandObj instanceof Integer) {
            left = (int) leftOperandObj;
        } else if (leftOperandObj instanceof Double) {
            left = (int) Math.round((double) leftOperandObj);
        } else {
            throw new IllegalArgumentException("Left operand must be Integer or Double");
        }

        if (rightOperandObj instanceof Integer) {
            right = (int) rightOperandObj;
        } else if (rightOperandObj instanceof Double) {
            right = (int) Math.round((double) rightOperandObj);
        } else {
            throw new IllegalArgumentException("Right operand must be Integer or Double");
        }

        String operation = calculatorRequest.getOperation();

        switch (operation) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            case "/":
                if (right != 0) {
                    return left / right;
                } else {
                    throw new ArithmeticException("Division by zero");
                }
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
    }

}

class DoubleCalculatorResult extends CalculatorResult {
    public DoubleCalculatorResult(CalculatorRequest calculatorRequest) {
        super(calculatorRequest);
    }

    @Override
    public Double computeResult() {
        double left = (double) calculatorRequest.getLeftOperand();
        double right = (double) calculatorRequest.getRightOperand();
        String operation = calculatorRequest.getOperation();

        switch (operation) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            case "/":
                if (right != 0) {
                    return left / right;
                } else {
                    throw new ArithmeticException("Division by zero");
                }
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
    }
}

class BooleanCalculatorResult extends CalculatorResult {
    public BooleanCalculatorResult(CalculatorRequest calculatorRequest) {
        super(calculatorRequest);
    }

    @Override
    public Boolean computeResult() {
        boolean left = (boolean) calculatorRequest.getLeftOperand();
        boolean right = (boolean) calculatorRequest.getRightOperand();
        String operation = calculatorRequest.getOperation();

        switch (operation) {
            case "&":
                return left && right;
            case "|":
                return left || right;
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
    }
}

enum RequestType {
    INTEGER, DOUBLE, BOOLEAN, UNKNOWN
}


